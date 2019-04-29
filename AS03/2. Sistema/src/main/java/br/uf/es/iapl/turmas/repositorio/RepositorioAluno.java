package br.uf.es.iapl.turmas.repositorio;

import br.uf.es.iapl.turmas.dominio.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class RepositorioAluno {

  private final EntityManager entityManager;

  public RepositorioAluno(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<Aluno> encontrarTodosAlunos() {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<Aluno> criteriaQuery = criteriaBuilder.createQuery(Aluno.class);

    final CriteriaQuery<Aluno> criteria = criteriaQuery.select(criteriaQuery.from(Aluno.class));

    return entityManager.createQuery(criteria).getResultList();
  }

  public void salvarAluno(final Aluno aluno) {
    try {
      entityManager.getTransaction().begin();

      entityManager.merge(aluno);

      entityManager.getTransaction().commit();
    } catch (final Throwable e) {
      entityManager.getTransaction().rollback();
      throw e;
    }
  }
}
