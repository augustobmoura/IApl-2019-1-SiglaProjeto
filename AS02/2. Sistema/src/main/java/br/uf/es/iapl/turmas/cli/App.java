package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.repositorio.RepositorioAluno;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class App {

  public static void main(String[] args) {
//    disableLogging();

    final EntityManagerFactory emFactory = Persistence
        .createEntityManagerFactory("org.hibernate.tutorial.jpa");

    final RepositorioAluno repositorioAluno =
        new RepositorioAluno(emFactory.createEntityManager());

    final OpcoesLinhaComando opcoesLinhaComando = new OpcoesLinhaComando(args);


  }

  private static void disableLogging() {
    LogManager logManager = LogManager.getLogManager();
    Logger logger = logManager.getLogger("");
    logger.setLevel(Level.SEVERE); //could be Level.OFF
  }
}
