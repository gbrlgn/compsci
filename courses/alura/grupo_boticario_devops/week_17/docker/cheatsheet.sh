# Pós instalação
systemctl enable docker
sudo groupadd docker
sudo usermod -aG docker $USER 
newgrp docker

# Puxar do Docker Hub.
docker pull container

# Rodar container.
docker run container

# Executar comando em container já em
# execução.
docker exec -it

# Rodar no modo interativo com tty.
docker run -it ubuntu bash

# Detached, no background.
docker run -d dockersamples/static-site

# /bin/sh -c trava o terminal. O container
# utiliza as portas 80 e 443 isoladas
# do Docker.

# Roda o container sem travar o terminal,
# mapeando portas para um IP.
docker run –d -P dockersamples/static-site

# Mostrar o mapeamento de portas.
docker port dockersamples/static-site

# Mapear para uma porta específica, neste
# caso a 8080.
docker run -d -p 8080:80 dockersamples/static-site

# Listar imagens do Docker
docker images

# Inspecionar imagem
docker inspect id 

# Mostra o histórico da imagem e suas
# camadass
docker history id

# Camadas são um conjunto de regras de
# execução de uma imagem.
# Como a imagem é read-only, cada container
# baseado nela faz uma camada write própria.