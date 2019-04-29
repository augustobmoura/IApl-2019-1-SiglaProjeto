package br.uf.es.iapl.turmas.dominio;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Turma implements Entidade<Long> {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String nome;

  @NotNull
  @ManyToOne
  private Professor professor;

  @ManyToMany
  private Set<Aluno> alunos;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Professor getProfessor() {
    return professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  public Set<Aluno> getAlunos() {
    return alunos;
  }

  public void setAlunos(Set<Aluno> alunos) {
    this.alunos = alunos;
  }
}
