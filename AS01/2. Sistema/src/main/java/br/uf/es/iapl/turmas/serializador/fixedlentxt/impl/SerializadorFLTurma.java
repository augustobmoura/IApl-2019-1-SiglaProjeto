package br.uf.es.iapl.turmas.serializador.fixedlentxt.impl;

import br.uf.es.iapl.turmas.dominio.Professor;
import br.uf.es.iapl.turmas.dominio.Turma;
import br.uf.es.iapl.turmas.repositorio.Repositorio;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class SerializadorFLTurma extends SerializadorFLEntidade<Turma> {

  private Repositorio repositorio;

  public SerializadorFLTurma(final Repositorio repositorio) {
    this.repositorio = repositorio;
  }

  @Override
  Turma objetoBase() {
    return new Turma();
  }

  @Override
  Turma valoresTextoParaEntidade(Turma base, Queue<String> valores) {
    base.setId(Long.parseLong(valores.remove()));
    base.setNome(valores.remove());
    base.setProfessor(repositorio.encontrarPorId(Professor.class, Long.parseLong(valores.remove())));
    return base;
  }

  @Override
  List<String> entidadeParaValoresTexto(Turma entidade) {
    return null;
  }

  @Override
  List<DescritorDeValores> descritores() {
    return Arrays.asList(
        new DescritorDeValores(32),
        new DescritorDeValores(256),
        new DescritorDeValores(32)
    );
  }
}
