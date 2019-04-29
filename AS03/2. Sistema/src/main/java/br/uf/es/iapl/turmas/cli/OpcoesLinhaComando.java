package br.uf.es.iapl.turmas.cli;

import java.io.File;
import java.util.Optional;

public class OpcoesLinhaComando {

  private Optional<File> input = Optional.empty();

  public OpcoesLinhaComando(final String[] args) {
    if (args.length > 0) {
      input = Optional.ofNullable(args[0]).map(File::new);
    }
  }

  public Optional<File> getInput() {
    return input;
  }

}
