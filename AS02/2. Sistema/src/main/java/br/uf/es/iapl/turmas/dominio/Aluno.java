package br.uf.es.iapl.turmas.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno extends Pessoa {

  @Id
  @GeneratedValue(generator = "increment")
  private Long id;

  @NotNull
  private String curso;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

}
