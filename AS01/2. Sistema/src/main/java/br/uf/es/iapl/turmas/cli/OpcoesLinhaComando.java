package br.uf.es.iapl.turmas.cli;

import br.uf.es.iapl.turmas.dominio.Entidade;
import br.uf.es.iapl.turmas.dominio.Pessoa;
import br.uf.es.iapl.turmas.dominio.Professor;
import br.uf.es.iapl.turmas.dominio.Turma;

import java.io.File;
import java.util.*;

public class OpcoesLinhaComando {

  private static final Map<String, Class<? extends Entidade>> classesPorTabela = Map.of(
      "aluno", Pessoa.class,
      "professor", Professor.class,
      "turma", Turma.class
  );

  private Class<? extends Entidade> tabelaAlvo;

  private Optional<File> input = Optional.empty();

  public OpcoesLinhaComando(final String[] args) {
    final Queue<String> pilha = new LinkedList<>(Arrays.asList(args));
    String valor;

    while (!pilha.isEmpty()) {
      valor = pilha.remove();

      switch (valor) {
        case "-t":
        case "--tabela":
          lerTabela(pilha);
          break;

        default:
          input = Optional.of(valor).map(File::new);
      }
    }
  }

  private void lerTabela(final Queue<String> pilha) {
    Class tabelaEscolhida = null;

    if (pilha.isEmpty()) {
      throw new IllegalArgumentException(String.format(
          "Opção de tabela usada, mas nem uma tabela fornecida. Opções: %s",
          String.join(", ", classesPorTabela.keySet())
      ));
    }

    final String tabela = pilha.remove();

    for (final var valores : classesPorTabela.entrySet()) {
      if (valores.getKey().equalsIgnoreCase(tabela)) {
        tabelaEscolhida = valores.getValue();
      }
    }

    if (tabelaEscolhida == null) {
      throw new IllegalStateException(String.format(
          "Tabela com identificador %s não encontrada. Opções: %s",
          tabela,
          String.join(", ", classesPorTabela.keySet())
      ));
    }

    tabelaAlvo = tabelaEscolhida;
  }

  public Optional<File> getInput() {
    return input;
  }

  public Class<? extends Entidade> getTabelaAlvo() {
    return tabelaAlvo;
  }
}
