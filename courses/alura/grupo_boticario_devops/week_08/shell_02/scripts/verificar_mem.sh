#!/bin/bash

mem_total=$(free | grep -i mem | awk ' { print $2 }')
mem_cons=$(free | grep -i mem | awk ' { print $3 }')
rel_mem=$(bc <<< "scale=2;$mem_cons/$mem_total*100" | awk -F. '{ print $1 }')

if [ $rel_mem -gt 50 ]
then
    mail -s "Consumo de memória acima do limite" adm.multillidae@gmail.com<<del O consumo de memória excedeu o limite especificado. Atualmente o consumo é de $(free -h | grep -i mem | awk ' { print $3 }').
    del
fi
