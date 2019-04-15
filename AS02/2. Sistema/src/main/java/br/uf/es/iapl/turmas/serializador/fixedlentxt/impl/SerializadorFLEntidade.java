package br.uf.es.iapl.turmas.serializador.fixedlentxt.impl;

import br.uf.es.iapl.turmas.serializador.fixedlentxt.SerializadorFixedLength;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class SerializadorFLEntidade<T> implements SerializadorFixedLength<T> {

  abstract T objetoBase();

  abstract T valoresTextoParaEntidade(final T base, final Queue<String> valores);

  abstract List<String> entidadeParaValoresTexto(final T entidade);

  abstract List<DescritorDeValores> descritores();

  @Override
  public final T lerDeLinha(final String linha) {
    final Queue<String> valores = new LinkedList<>();

    int i = 0;

    for (final DescritorDeValores descritor : descritores()) {
      final int tamanhoValor = descritor.getTamanho();

      final String valorAtual = StringUtils.substring(linha, i, i + tamanhoValor - 1);
      i = tamanhoValor;

      valores.add(valorAtual.trim());
    }

    return valoresTextoParaEntidade(objetoBase(), valores);
  }

  @Override
  public final String converterParaLinha(final T entidade) {
    final List<String> valores = entidadeParaValoresTexto(entidade);
    final StringBuilder builderLinha = new StringBuilder();
    final List<DescritorDeValores> descritores = this.descritores();

    for (int i = 0; i < valores.size(); i++) {
      final String valor = valores.get(i);
      final DescritorDeValores descritor = descritores.get(i);

      builderLinha.append(StringUtils.rightPad(valor, descritor.getTamanho(), ' '));
    }

    return builderLinha.toString();
  }

  protected static class DescritorDeValores {
    private final int tamanho;

    public DescritorDeValores(int tamanho) {
      this.tamanho = tamanho;
    }

    protected int getTamanho() {
      return tamanho;
    }
  }
}
