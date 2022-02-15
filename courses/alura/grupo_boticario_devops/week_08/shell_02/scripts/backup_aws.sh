#!/bin/bash

CAMINHO_BACKUP=backup/backup_aws
cd $CAMINHO_BACKUP

data=$(date +%F)
if [ ! -d $data ]
then
    mkdir $data
fi

tabelas=$(mysql -u root multillidae -e "show tables;" | grep -v Tables)

for tabela in $tabelas
do
    mysqldump -u root multillidae $tabela > $CAMINHO_BACKUP/$data/$tabela.sql
done

aws s3 sync $CAMINHO_BACKUP s3://curso-shell-script
