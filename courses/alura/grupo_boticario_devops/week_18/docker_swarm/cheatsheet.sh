# Inicializa um cluster do Docker Swarm, com o nó
# atual como o manager do cluster.
docker swarm init --advertise-addr 192.168.0.1

# Adiciona um worker ao swarm.
docker swarm join --token token ip:porta

# Recupera um token para um nó worker.
docker swarm join-token worker

# Lista os nós do swarm (somente manager).
docker node ls 

# Remove um nó.
docker swarm leave # de dentro do nó.
docker node rm id

# Como o docker run sobe um container apenas no
# escopo local, para subir um container no
# escopo do swarm, devemos utilizar:
docker service create -p porta:porta nome # somente manager.

# Lista os serviços swarm.
docker service ls

# Lista os processos swarm.
docker service ps

# O conteúdo do Swarm fica em /var/lib/docker/swarm.

# Inicia um cluster com configurações pós backup.
docker swarm init --force-new-cluster --advertise-addr 192.168.0.1

# Recupera o token para um nó manager.
docker swarm join-token manager

# O primeiro manager do swarm é o leader; outros
# são listados como reachable.

# Devemos primeiramente rebaixar o cargo do nó e depois removê-lo.
docker demote id
docker rm id

# Remover todos os serviços.
docker service rm $(docker service ls -q)

# Modificar o estado de disponibilidade do nó.
docker node update --availability drain nó 

# Drain torna o nó incapaz de receber serviços.

# Restringe um serviço.
docker service update --constraint-add node.role==role id

# Reistrige o serviço ci10k3u7q6ti para 
# funcionar somente no nó t76gee19fjs8.
docker service update --constraint-add node.id==t76gee19fjs8 ci10k3u7q6ti