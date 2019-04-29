package br.uf.es.iapl.turmas.serializador.fixedlentxt;

import br.uf.es.iapl.turmas.repositorio.Repositorio;
import br.uf.es.iapl.turmas.serializador.fixedlentxt.impl.SerializadorFLAluno;
import br.uf.es.iapl.turmas.serializador.fixedlentxt.impl.SerializadorFLProfessor;
import br.uf.es.iapl.turmas.serializador.fixedlentxt.impl.SerializadorFLTurma;

public class SerializadorFactory {

  private Repositorio repositorio;

  public SerializadorFactory(Repositorio repositorio) {
    this.repositorio = repositorio;
  }

  public <T> SerializadorFixedLength<T> encontrarFabrica(Class<T> classe) {
    SerializadorFixedLength serializador = null;

    switch (classe.getSimpleName()) {
      case "Aluno":
        serializador = new SerializadorFLAluno();
        break;

      case "Professor":
        serializador = new SerializadorFLProfessor();
        break;

      case "Turma":
        serializador = new SerializadorFLTurma(repositorio);
        break;
    }

    return (SerializadorFixedLength<T>) serializador;
  }
}
