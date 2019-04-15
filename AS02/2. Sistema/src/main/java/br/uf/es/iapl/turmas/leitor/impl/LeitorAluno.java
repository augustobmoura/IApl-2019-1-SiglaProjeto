package br.uf.es.iapl.turmas.leitor.impl;

import br.uf.es.iapl.turmas.dominio.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeitorAluno extends LeitorPessoa<Aluno> {

  @Override
  Aluno objetoBase() {
    return new Aluno();
  }

  @Override
  Aluno valoresTextoParaEntidade(Aluno base, Queue<String> valores) {
    final Aluno entidade = super.valoresTextoParaEntidade(base, valores);
    entidade.setCurso(valores.remove());

    return entidade;
  }

  @Override
  List<String> entidadeParaValoresTexto(Aluno entidade) {
    final List<String> valoresSuper = new ArrayList<>(super.entidadeParaValoresTexto(entidade));
    valoresSuper.add(entidade.getCurso());

    return valoresSuper;
  }

  @Override
  List<DescritorDeValores> descritores() {
    final List<DescritorDeValores> valores = super.descritores();
    valores.add(new DescritorDeValores(128));

    return valores;
  }
}
