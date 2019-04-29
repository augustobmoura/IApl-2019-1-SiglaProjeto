#! /usr/bin/env sh

set -e
tabela="$1"
if [ x = "x$tabela" ]; then
  echo Nenhum argumento foi passado. Passe o nome da base
  exit 1
fi
while IFS='' read -r line; do
  echo "$line" | awk -F ',' '
  {
    printf "INSERT INTO '$tabela' VALUES("
    printf $1
    for (i = 2; i <= NF; i++)
      printf ", %s", $i
    print ");"
  }
'
done

