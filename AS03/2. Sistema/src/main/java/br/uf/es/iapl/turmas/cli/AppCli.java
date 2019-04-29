package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.dominio.Entidade;
import br.uf.es.iapl.turmas.repositorio.Repositorio;
import br.uf.es.iapl.turmas.serializador.fixedlentxt.SerializadorFactory;
import br.uf.es.iapl.turmas.serializador.fixedlentxt.SerializadorFixedLength;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AppCli {

  public static <T extends Entidade> void main(String[] args) throws IOException {
    final String log = System.getenv("LOG");
    if (log == null || log.isBlank()) {
      disableLogging();
    }

    final EntityManagerFactory emFactory = Persistence
        .createEntityManagerFactory("org.hibernate.tutorial.jpa");

    final Repositorio repositorio =
        new Repositorio(emFactory.createEntityManager());

    final SerializadorFactory serializadorFactory = new SerializadorFactory(repositorio);

    final OpcoesLinhaComando opcoesLinhaComando = new OpcoesLinhaComando(args);
    final Optional<File> entrada = opcoesLinhaComando.getInput();

    final Class<T> classe = (Class<T>) opcoesLinhaComando.getTabelaAlvo();
    final SerializadorFixedLength<T> serializador =
        serializadorFactory.encontrarFabrica(classe);

    if (entrada.isEmpty()) {
      final ImpressorEntidade<T> impressor = new ImpressorEntidade<>(
          repositorio,
          classe,
          serializador
      );
      impressor.imprimeTodosAlunos(System.out);
    } else {
      final LeitorEntidade<T> leitorEntidade = new LeitorEntidade<>(repositorio, serializador);
      leitorEntidade.gravarTodosDe(new FileReader(entrada.get()));
    }
  }

  private static void disableLogging() {
    LogManager logManager = LogManager.getLogManager();
    Logger logger = logManager.getLogger("");
    logger.setLevel(Level.SEVERE); //could be Level.OFF
  }
}
