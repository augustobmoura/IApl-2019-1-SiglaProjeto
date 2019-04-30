package br.uf.es.iapl.turmas.dominio;

import java.io.Serializable;

/**
 * Interface que provê serviços de serialização e desserialização.
 * Para implementar essa interface é necessário passar um Objeto serializável.
 *
 * @param <I> Objeto serializável, I extende Serializabe, e para ser uma entidade,
 * deve ser um objeto serializável.
 */
public interface Entidade<I extends Serializable> {

  I getId();

}
