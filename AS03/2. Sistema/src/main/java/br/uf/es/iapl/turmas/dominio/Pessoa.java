package br.uf.es.iapl.turmas.dominio;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Classe Pessoa, implementa uma serialização e uma entidade com o
 * id de serialização LONG.
 */
@MappedSuperclass
public abstract class Pessoa implements Serializable, Entidade<Long> {

  /**
   * Getters and Setters.
   */

  /**
   * Atributo identificador incremental.
   */
  @Id
  @GeneratedValue(generator = "increment")
  private Long id;

  @NotNull
  private String nome;

  @NotNull
  @Min(0L)
  private Integer idade;

  @NotNull
  private String cpf;

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
