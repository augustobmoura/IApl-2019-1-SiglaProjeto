package br.uf.es.iapl.turmas.serializador.fixedlentxt.impl;

import br.uf.es.iapl.turmas.dominio.Pessoa;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public abstract class SerializadorFLPessoa<T extends Pessoa> extends SerializadorFLEntidade<T> {

  @Override
  T valoresTextoParaEntidade(T base, Queue<String> valores) {
    base.setId(Long.parseLong(valores.remove()));
    base.setNome(valores.remove());
    base.setIdade(Integer.parseInt(valores.remove()));
    base.setCpf(valores.remove());

    return base;
  }

  @Override
  List<String> entidadeParaValoresTexto(final T entidade) {
    return Arrays.asList(
        entidade.getId().toString(),
        entidade.getNome(),
        entidade.getIdade().toString(),
        entidade.getCpf()
    );
  }

  @Override
  List<DescritorDeValores> descritores() {
    return Arrays.asList(
        new DescritorDeValores(32),
        new DescritorDeValores(128),
        new DescritorDeValores(14),
        new DescritorDeValores(3)
    );
  }
}
