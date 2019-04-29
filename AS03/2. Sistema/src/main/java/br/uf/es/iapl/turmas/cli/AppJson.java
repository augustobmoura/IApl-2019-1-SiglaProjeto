package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.dominio.Entidade;
import br.uf.es.iapl.turmas.repositorio.Repositorio;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AppJson {

  @SuppressWarnings("unchecked")
  public static <T extends Entidade> void main(String[] args) throws IOException {
    final String log = System.getenv("LOG");
    if (log == null || log.isBlank()) {
      disableLogging();
    }

    final AppModule appModule = new AppModule(args);

    if (appModule.getEntrada().isEmpty()) {
      String json = appModule.getJsonMapper().writeValueAsString(
          appModule.getRepositorio().encontrarTodos(appModule.getClasse()));

      System.out.println(json);
    } else {
      Repositorio repo = appModule.getRepositorio();
      ObjectMapper jsonMapper = appModule.getJsonMapper();
      CollectionType type = jsonMapper.getTypeFactory().constructCollectionType(List.class, appModule.getClasse());
      for (Entidade item : (List<? extends Entidade>) jsonMapper.readValue(appModule.getEntrada().get(), type)) {
        repo.salvar(item);
      }
    }
  }

  private static void disableLogging() {
    LogManager logManager = LogManager.getLogManager();
    Logger logger = logManager.getLogger("");
    logger.setLevel(Level.SEVERE); //could be Level.OFF
  }
}
