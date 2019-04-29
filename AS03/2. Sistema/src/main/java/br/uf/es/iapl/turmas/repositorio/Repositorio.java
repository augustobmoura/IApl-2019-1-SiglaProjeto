package br.uf.es.iapl.turmas.repositorio;

import br.uf.es.iapl.turmas.dominio.Entidade;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class Repositorio {

  private final EntityManager entityManager;

  public Repositorio(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public <T extends Entidade> List<T> encontrarTodos(final Class<T> classe) {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(classe);

    final CriteriaQuery<T> criteria = criteriaQuery.select(criteriaQuery.from(classe));

    return entityManager.createQuery(criteria).getResultList();
  }

  public <T extends Entidade> T salvar(final T entidade) {
    if (entidade.getId() == null) {
      entityManager.persist(entidade);
      return entidade;
    } else {
      return entityManager.merge(entidade);
    }
  }

  public <I extends Serializable, T extends Entidade<I>> T encontrarPorId(
      final Class<T> classEntidade,
      final I id
  ) {
    return entityManager.find(classEntidade, id);
  }
}
