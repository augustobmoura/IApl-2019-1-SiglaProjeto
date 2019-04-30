package br.uf.es.iapl.turmas.repositorio;

import br.uf.es.iapl.turmas.dominio.Entidade;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Classe resposável por gerenciar a persistência no banco de dados.
 */
public class Repositorio {

  private final EntityManager entityManager;

  /**
   * Construtor padrão do repositório.
   * @param entityManager Recebe um gerenciador de entidades para manipular o repositório.
   */
  public Repositorio(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  /**
   * Método que lista as entidades presentes no banco de dados.
   * @param classe Informa a classe da entidade que deseja procurar no banco de dados.
   * @param <T> Identifica que o parâmetro de entrada é do mesmo tipo do retorno.
   * @return Retorna uma lista de entidades que extende do mesmo tipo da variável de entrada.
   */
  public <T extends Entidade> List<T> encontrarTodos(final Class<T> classe) {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(classe);

    final CriteriaQuery<T> criteria = criteriaQuery.select(criteriaQuery.from(classe));

    return entityManager.createQuery(criteria).getResultList();
  }

  /**
   * Método que salva uma entidade serializável no banco de dados.
   *
   * @param entidade Classe que implementa uma entidade.
   * @param <T> Identifica que o parâmetro de entrada é do mesmo tipo do retorno.
   *
   * @return Retorna uma entidade. (Em alguns casos é necessário modificar a entidade para
   * persistí-la no banco de dados, por isso o retorno da entidade).
   */
  public <T extends Entidade> T salvar(final T entidade) {
    entityManager.getTransaction().begin();

    T e = entidade;
    if (entidade.getId() == null) {
      entityManager.persist(entidade);
    } else {
      e = entityManager.merge(entidade);
    }

    entityManager.getTransaction().commit();
    return e;
  }

  /**
   * Método de busca por identificador.
   * @param classEntidade Tipo de entidade que irá buscar no banco.
   * @param id Identificador do objeto da entidade.
   * @param <T> Identifica que o parâmetro de entrada é do mesmo tipo do retorno.
   * @param <T> Identifica que o parâmetro de entrada é do mesmo tipo do retorno.
   * @return Retorna uma entidade conforme os valores informados.
   */
  public <I extends Serializable, T extends Entidade<I>> T encontrarPorId(
      final Class<T> classEntidade,
      final I id
  ) {
    return entityManager.find(classEntidade, id);
  }
}
