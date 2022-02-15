#!/bin/bash

CAMINHO_RESTORE=backup/restore_aws

aws s3 sync s3://curso-shell-script/$(date +%F) $CAMINHO_RESTORE

cd $CAMINHO_RESTORE

if [ -f $1.sql ]
then
    mysql -u root multillidae < $1.sql
    if [ $? -eq 0 ]
    then
        echo "Restauração realizada com sucesso"
    fi
else
    echo "O arquivo requisitado não existe no diretório"
fi
