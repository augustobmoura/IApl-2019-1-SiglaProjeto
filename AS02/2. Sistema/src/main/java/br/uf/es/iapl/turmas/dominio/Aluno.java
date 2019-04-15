package br.uf.es.iapl.turmas.dominio;

import br.uf.es.iapl.turmas.leitor.LeitorDados;
import br.uf.es.iapl.turmas.leitor.impl.LeitorAluno;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno extends Pessoa<Aluno> {

  @NotNull
  private String curso;

  @Override
  public LeitorDados<Aluno> leitor() {
    return new LeitorAluno();
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

}
