#! /bin/bash

OS=( 'Linux' 'Windows' 'Unix' )

echo "Ilk eleman ${OS[0]}"
echo "${OS[@]}" # @ -> all elements
echo "${!OS[@]}" # ! -> index
echo "${#OS[@]}" # # -> length

OS[3]='Mac'
echo "${OS[@]}"

echo "----------------------------------------"

unset OS[1] # silmek için (indexiyle birlikte siler)
echo "${OS[@]}"
echo "${!OS[@]}" 