package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.dominio.Entidade;
import br.uf.es.iapl.turmas.repositorio.Repositorio;
import br.uf.es.iapl.turmas.serializador.fixedlentxt.SerializadorFixedLength;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class LeitorEntidade<T extends Entidade> {

  private final Repositorio repositorio;

  private final SerializadorFixedLength<T> serializador;

  public LeitorEntidade(Repositorio repositorio, SerializadorFixedLength<T> serializador) {
    this.repositorio = repositorio;
    this.serializador = serializador;
  }

  public void gravarTodosDe(final Reader reader) throws IOException {
    try (final BufferedReader bufferedReader = new BufferedReader(reader)) {
      for (
          String linha = bufferedReader.readLine();
          linha != null;
          linha = bufferedReader.readLine()
      ) {
        repositorio.salvar(serializador.lerDeLinha(linha));
      }
    }
  }

}
