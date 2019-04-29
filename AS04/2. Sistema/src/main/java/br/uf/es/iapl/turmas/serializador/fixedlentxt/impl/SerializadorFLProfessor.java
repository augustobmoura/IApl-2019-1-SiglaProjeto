package br.uf.es.iapl.turmas.serializador.fixedlentxt.impl;

import br.uf.es.iapl.turmas.dominio.Professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SerializadorFLProfessor extends SerializadorFLPessoa<Professor> {

  @Override
  Professor objetoBase() {
    return new Professor();
  }

  @Override
  Professor valoresTextoParaEntidade(Professor base, Queue<String> valores) {
    final Professor entidade = super.valoresTextoParaEntidade(base, valores);
    entidade.setEspecialidade(valores.remove());

    return entidade;
  }

  @Override
  List<String> entidadeParaValoresTexto(Professor entidade) {
    final List<String> valores = new ArrayList<>(super.entidadeParaValoresTexto(entidade));
    valores.add(entidade.getEspecialidade());

    return valores;
  }

  @Override
  List<DescritorDeValores> descritores() {
    final List<DescritorDeValores> descritores = new ArrayList<>(super.descritores());
    descritores.add(new DescritorDeValores(128));

    return descritores;
  }

}
