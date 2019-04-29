package br.uf.es.iapl.turmas.dominio;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

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
