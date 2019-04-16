package br.uf.es.iapl.turmas.dominio;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public abstract class Pessoa implements Serializable {

  @NotNull
  private String nome;

  @NotNull
  @Min(0L)
  private Integer idade;

  @NotNull
  private String cpf;

  abstract public Long getId();

  abstract public void setId(final Long id);

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
