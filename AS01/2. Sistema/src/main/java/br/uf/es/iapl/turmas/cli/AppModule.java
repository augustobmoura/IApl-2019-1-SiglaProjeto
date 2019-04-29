package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.repositorio.Repositorio;
import br.uf.es.iapl.turmas.serializador.fixedlentxt.SerializadorFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.util.Optional;

public class AppModule {

  final EntityManagerFactory emFactory;

  final Repositorio repositorio;

  final SerializadorFactory serializadorFactory;

  final OpcoesLinhaComando opcoesLinhaComando;
  final Optional<File> entrada;

  final Class classe;

  public AppModule(final String[] args) {
    emFactory = Persistence
        .createEntityManagerFactory("org.hibernate.tutorial.jpa");
    repositorio = new Repositorio(emFactory.createEntityManager());
    serializadorFactory = new SerializadorFactory(repositorio);
    opcoesLinhaComando = new OpcoesLinhaComando(args);
    entrada = opcoesLinhaComando.getInput();
    classe = opcoesLinhaComando.getTabelaAlvo();
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
}
