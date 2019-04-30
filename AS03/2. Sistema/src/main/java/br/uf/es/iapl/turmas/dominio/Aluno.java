package br.uf.es.iapl.turmas.dominio;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Classe Aluno, contém os atributos de uma pessoa e adiciona o curso do aluno.
 * Provê também os getters and setters do curso.
 */
@Entity
public class Aluno extends Pessoa {

  /**
   * Atributo em formato de texto com 128 caractéres, representação do título de um curso.
   */
  @NotNull
  private String curso;

  /** Getters and Setters*/

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }
}