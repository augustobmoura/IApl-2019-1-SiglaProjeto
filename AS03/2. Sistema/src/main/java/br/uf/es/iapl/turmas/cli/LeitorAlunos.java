package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.repositorio.RepositorioAluno;
import br.uf.es.iapl.turmas.serializador.fixedlentxt.impl.SerializadorFLAluno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class LeitorAlunos {

  private final RepositorioAluno repositorioAluno;

  public LeitorAlunos(RepositorioAluno repositorioAluno) {
    this.repositorioAluno = repositorioAluno;
  }

  public void gravarTodosAlunosDe(Reader reader) throws IOException {
    final SerializadorFLAluno serializador = new SerializadorFLAluno();

    try (final BufferedReader bufferedReader = new BufferedReader(reader)) {
      for (
          String linha = bufferedReader.readLine();
          linha != null;
          linha = bufferedReader.readLine()
      ) {
        repositorioAluno.salvarAluno(serializador.lerDeLinha(linha));
      }
    }
  }

}
