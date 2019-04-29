package br.uf.es.iapl.turmas.dominio;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno extends Pessoa {

  @NotNull
  private String curso;

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

}
