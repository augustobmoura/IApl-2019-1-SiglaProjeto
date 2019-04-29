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

public class AppJson {

  public static <T extends Entidade> void main(String[] args) throws IOException {
    final String log = System.getenv("LOG");
    if (log == null || log.isBlank()) {
      disableLogging();
    }

    if (entrada.isEmpty()) {
    } else {
    }
  }

  private static void disableLogging() {
    LogManager logManager = LogManager.getLogManager();
    Logger logger = logManager.getLogger("");
    logger.setLevel(Level.SEVERE); //could be Level.OFF
  }
}
