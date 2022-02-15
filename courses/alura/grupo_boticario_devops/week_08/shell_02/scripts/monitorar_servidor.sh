#!/bin/bash

resp_http=$(curl --write-out %{http} --silent --output /dev/null http://localhost)

if [ $resp_http -ne 200 ]
then
   mail -s "Problema no servidor" adm.multillidae@gmail.com<<del Houve um problema no servidor e os usuários perderam acesso ao servidor.
   del
   systemctl restart apache2
fi
