package br.uf.es.iapl.turmas.dominio;

import br.uf.es.iapl.turmas.leitor.Legivel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public abstract class Pessoa<T extends Pessoa> implements Legivel<T> {

  @NotNull
  private String nome;

  @NotNull
  @Min(0L)
  private Integer idade;

  @NotNull
  private String cpf;

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
