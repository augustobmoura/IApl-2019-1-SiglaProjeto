package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.repositorio.Repositorio;
import br.uf.es.iapl.turmas.serializador.fixedlentxt.SerializadorFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.util.Optional;

public class AppModule {

  private final EntityManagerFactory emFactory;

  private final Repositorio repositorio;

  private final SerializadorFactory serializadorFactory;

  private final OpcoesLinhaComando opcoesLinhaComando;
  private final Optional<File> entrada;

  private final Class classe;

  private final ObjectMapper jsonMapper;

  public AppModule(final String[] args) {
    opcoesLinhaComando = new OpcoesLinhaComando(args);
    emFactory = Persistence
        .createEntityManagerFactory("org.hibernate.tutorial.jpa");
    repositorio = new Repositorio(emFactory.createEntityManager());
    serializadorFactory = new SerializadorFactory(repositorio);
    entrada = opcoesLinhaComando.getInput();
    classe = opcoesLinhaComando.getTabelaAlvo();
    jsonMapper = new ObjectMapper();
  }

  public EntityManagerFactory getEmFactory() {
    return emFactory;
  }

  public Repositorio getRepositorio() {
    return repositorio;
  }

  public SerializadorFactory getSerializadorFactory() {
    return serializadorFactory;
  }

  public OpcoesLinhaComando getOpcoesLinhaComando() {
    return opcoesLinhaComando;
  }

  public Optional<File> getEntrada() {
    return entrada;
  }

  public Class getClasse() {
    return classe;
  }

  public ObjectMapper getJsonMapper() {
    return jsonMapper;
  }
}
