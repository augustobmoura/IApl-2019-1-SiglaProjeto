package br.uf.es.iapl.turmas.serializador.fixedlentxt;

public interface SerializadorFixedLength<T> {

  T lerDeLinha(final String linha);

  String converterParaLinha(final T entidade);

}
