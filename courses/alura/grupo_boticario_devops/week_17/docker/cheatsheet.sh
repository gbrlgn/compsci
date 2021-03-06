# Pós instalação:
systemctl enable docker
sudo groupadd docker
sudo usermod -aG docker $USER 
newgrp docker

# Montar imagem de uma Dockerfile.
docker build -t tag diretorio

# Puxar do Docker Hub.
docker pull container

# Rodar container.
docker run container

# Executar comando em container já em execução.
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

# Mapear para uma porta específica, neste caso a 8080.
docker run -d -p 8080:80 dockersamples/static-site

# Listar imagens do Docker.
docker images

# Inspecionar imagem.
docker inspect id 

# Mostra o histórico da imagem e suas camadas.
docker history id

# Camadas são um conjunto de regras de
# execução de uma imagem.
# Como a imagem é read-only, cada container
# baseado nela faz uma camada write própria.

# Parar todos os containers.
docker stop $(docker container ls -q)

# Gerar imagem e enviar ao Docker Hub.
docker tag danielartine/app-node1.0 aluradocker/app-node:1.0

docker push aluradocker/app-node:1.0

# Remover todos os containers.
docker container rm $(docker container ls -aq)

# Remover todas as imagens.
docker rmi $(docker image ls -aq)

# Tamanho do container.
docker ps -s

# Roda o container (nginx) montado a um diretório.
docker run -it -v /home/diretorio:app nginx

docker run --mount type=bind.source=/home/diretorio.target=/app nginx

# O volume ficaria em /var/lib/docker/volumes/meu-volume
docker run -it -v meu-volume:/app nginx

# Rodar container com um volume sem bind.
docker run -it --mount source=meu-volume,target=/app ubuntu bash

# Rodar container com um volume tmpfs (apenas Linux).
docker run -it --tmpfs=/app ubuntu bash

# O mesmo que:
docker run --mount type=tmpfs.source=/home/diretorio.target=/app ubuntu bash

# Os containers estão na mesma rede, como mostrado
# pelo docker inspect.

# Listar as redes disponíveis.
docker network ls

# Rodar container com um nome específico.
docker run -it --name ubuntu1 ubuntu bash

# Criar rede bridge.
docker network create --driver bridge minha-bridge

# Executar ping por meio do nome do container.
docker run -it --name pong --network minha-bridge ubuntu sleep 1d

docker run -it --name ubuntu1 --network minha-bridge ubuntu bash

$ apt install -y iputils-ping
ping pong