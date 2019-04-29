package br.uf.es.iapl.turmas.dominio;

import java.io.Serializable;

public interface Entidade<I extends Serializable> {

  I getId();

}
