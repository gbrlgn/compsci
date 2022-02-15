#!/bin/bash

cd ../apache-log

if [ -z $1 ]
then
    while [ -z $req ]
    do
        read -p "Por favor insira um parâmetro (GET, POST, PUT ou DELETE)" req
        param=$(echo $req | awk '{ print toupper($1) }')
    done
else
    param=$(echo $1 | awk '{ print toupper($1) }')
fi

case $param in
    GET)
    cat apache.log | grep GET
    ;;
    POST)
    cat apache.log | grep POST
    ;;
    PUT)
    cat apache.log | grep PUT
    ;;
    DELETE)
    cat apache.log | grep DELETE
    *)
    echo "O parâmetro não é válido"
    ;;
esac
