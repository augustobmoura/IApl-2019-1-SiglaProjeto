package br.uf.es.iapl.turmas.leitor;

public interface LeitorDados<T> {

  T lerDeLinha(final String linha);

  String converterParaLinha(final T entidade);

}
