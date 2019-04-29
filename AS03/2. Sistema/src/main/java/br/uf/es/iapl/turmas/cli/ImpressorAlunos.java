package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.dominio.Aluno;
import br.uf.es.iapl.turmas.repositorio.RepositorioAluno;
import br.uf.es.iapl.turmas.serializador.fixedlentxt.impl.SerializadorFLAluno;

import java.io.IOException;
import java.util.List;

public class ImpressorAlunos {

  private final Appendable saida;
  private final RepositorioAluno repositorioAluno;

  public ImpressorAlunos(Appendable saida, RepositorioAluno repositorioAluno) {
    this.saida = saida;
    this.repositorioAluno = repositorioAluno;
  }

  public void imprimeTodosAlunos() throws IOException {
    final SerializadorFLAluno serializador = new SerializadorFLAluno();
    final List<Aluno> alunos = repositorioAluno.encontrarTodosAlunos();

    for (final Aluno aluno : alunos) {
      saida.append(serializador.converterParaLinha(aluno)).append(System.lineSeparator());
    }
  }
}
