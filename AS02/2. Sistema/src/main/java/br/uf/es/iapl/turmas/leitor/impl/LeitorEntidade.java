package br.uf.es.iapl.turmas.leitor.impl;

import br.uf.es.iapl.turmas.leitor.LeitorDados;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class LeitorEntidade<T> implements LeitorDados<T> {

  abstract T objetoBase();

  abstract T valoresTextoParaEntidade(final T base, final Queue<String> valores);

  abstract List<String> entidadeParaValoresTexto(final T entidade);

  abstract List<DescritorDeValores> descritores();

  @Override
  public final T lerDeLinha(final String linha) {
    final Queue<String> valores = new LinkedList<>();

    String valorAtual;
    String restoDaLinha = linha;

    for (final DescritorDeValores descritor : descritores()) {
      final int tamanhoValor = descritor.getTamanho();

      valorAtual = restoDaLinha.length() > tamanhoValor
          ? restoDaLinha
          : restoDaLinha.substring(0, tamanhoValor - 1);

      restoDaLinha = restoDaLinha.length() > tamanhoValor
          ? "" : restoDaLinha.substring(tamanhoValor - 1);

      valores.add(valorAtual);

      if (restoDaLinha.isEmpty()) {
        break;
      }
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

      builderLinha.append(valor.substring(0, descritor.getTamanho() - 1));
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
