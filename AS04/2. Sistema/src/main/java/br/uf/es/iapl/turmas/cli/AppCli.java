package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.dominio.Entidade;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AppCli {

  @SuppressWarnings("unchecked")
  public static <T extends Entidade> void main(String[] args) throws IOException {
    final String log = System.getenv("LOG");
    if (log == null || log.isBlank()) {
      disableLogging();
    }

    final AppModule appModule = new AppModule(args);

    if (appModule.getEntrada().isEmpty()) {
      final ImpressorEntidade<T> impressor = new ImpressorEntidade<>(
          appModule.getRepositorio(),
          appModule.getClasse(),
          appModule.getSerializadorFactory().encontrarFabrica(appModule.getClasse())
      );

      impressor.imprimeTodosAlunos(System.out);
    } else {
      final LeitorEntidade<T> leitorEntidade = new LeitorEntidade<>(
          appModule.getRepositorio(),
          appModule.getSerializadorFactory().encontrarFabrica(appModule.getClasse())
      );

      leitorEntidade.gravarTodosDe(new FileReader(appModule.getEntrada().get()));
    }
  }

  private static void disableLogging() {
    LogManager logManager = LogManager.getLogManager();
    Logger logger = logManager.getLogger("");
    logger.setLevel(Level.SEVERE); //could be Level.OFF
  }
}
