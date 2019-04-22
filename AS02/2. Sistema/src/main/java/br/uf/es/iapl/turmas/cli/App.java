package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.repositorio.RepositorioAluno;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class App {

  public static void main(String[] args) throws IOException {
    final String log = System.getenv("LOG");
    if (log == null || log.isBlank()) {
      disableLogging();
    }

    final EntityManagerFactory emFactory = Persistence
        .createEntityManagerFactory("org.hibernate.tutorial.jpa");

    final RepositorioAluno repositorioAluno =
        new RepositorioAluno(emFactory.createEntityManager());

    final OpcoesLinhaComando opcoesLinhaComando = new OpcoesLinhaComando(args);
    final Optional<File> entrada = opcoesLinhaComando.getInput();

    if (entrada.isEmpty()) {
      final ImpressorAlunos impressor = new ImpressorAlunos(System.out, repositorioAluno);
      impressor.imprimeTodosAlunos();
    } else {
      final LeitorAlunos leitorAlunos = new LeitorAlunos(repositorioAluno);
      leitorAlunos.gravarTodosAlunosDe(new FileReader(entrada.get()));
    }
  }

  private static void disableLogging() {
    LogManager logManager = LogManager.getLogManager();
    Logger logger = logManager.getLogger("");
    logger.setLevel(Level.SEVERE); //could be Level.OFF
  }
}
