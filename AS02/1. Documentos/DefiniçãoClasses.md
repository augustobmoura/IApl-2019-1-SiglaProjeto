# Documentação:

## Classes:
### Pessoa
![alt text](https://github.com/augustobmoura/IApl-2019-1-TURMA/blob/master/AS02/1.%20Documentos/FormatoCampos/CampoPessoa.png)
Uma pessoa é uma classe genérica que é extendida por outras, cada pessoa possui os atributos:
- Identificador (Float - Valor Incremental); Tamanho - 32 caracteres.
- Nome (String); Tamanho - 128 caracteres.
- Idade (Inteiro - Minímo de 0); Tamanho - 3 caracteres.
- Cpf (Inteiro); Tamanho - 14 caracteres.
![alt text](https://github.com/augustobmoura/IApl-2019-1-TURMA/blob/master/AS02/1.%20Documentos/FormatoCampos/CampoPessoa.png)

### Aluno
Cada aluno é também uma pessoa, porém, seu diferencial é o curso que o aluno está matriculado.
- Curso (String); Tamanho - 128 caracteres.
![alt text](https://github.com/augustobmoura/IApl-2019-1-TURMA/blob/master/AS02/1.%20Documentos/FormatoCampos/CampoAluno.png)

### Professor
Assim como os alunos, o professor possui todos os atributos de uma pessoa qualquer, porém, em adicional possui sua especialidade.
- Especialidade (String); Tamanho - 128 caracteres.
![alt text](https://github.com/augustobmoura/IApl-2019-1-TURMA/blob/master/AS02/1.%20Documentos/FormatoCampos/CampoProfessor.png)

### Turma
A turma é uma classe que une o restante dos elementos. Sendo assim, cada turma possui os atributos:
- Identificador ( Valor incremental )
- Nome
- Professor ( Um único por turma)
- Alunos ( Vários alunos por turma)
