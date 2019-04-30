package br.uf.es.iapl.turmas.dominio;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Classe Professor, extende uma pessoa e adiciona
 * o atributo de especialidade do professor.
 */
@Entity
public class Professor extends Pessoa {

  @NotNull
  private String especialidade;

  public String getEspecialidade() {
    return especialidade;
  }

  public void setEspecialidade(String especialidade) {
    this.especialidade = especialidade;
  }

}
