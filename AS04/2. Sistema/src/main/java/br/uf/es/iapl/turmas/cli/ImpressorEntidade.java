package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.dominio.Entidade;
import br.uf.es.iapl.turmas.repositorio.Repositorio;
import br.uf.es.iapl.turmas.serializador.fixedlentxt.SerializadorFixedLength;

import java.io.IOException;
import java.util.List;

public class ImpressorEntidade<T extends Entidade> {

  private final Repositorio repositorio;
  private final Class<T> classe;
  private final SerializadorFixedLength<T> serializador;

  public ImpressorEntidade(Repositorio repositorio, Class<T> classe, SerializadorFixedLength<T> serializador) {
    this.repositorio = repositorio;
    this.classe = classe;
    this.serializador = serializador;
  }

  public void imprimeTodosAlunos(final Appendable saida) throws IOException {
    final List<T> entidades = repositorio.encontrarTodos(classe);

    for (final T entidade : entidades) {
      saida.append(serializador.converterParaLinha(entidade)).append(System.lineSeparator());
    }
  }
}
