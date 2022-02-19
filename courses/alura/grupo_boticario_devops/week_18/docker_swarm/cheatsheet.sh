# Inicializar um cluster do Docker Swarm, com o nó
# atual como o manager do cluster.
docker swarm init --advertise-addr 192.168.0.1

# Adiciona um worker ao swarm.
docker swarm join --token token ip:porta

# Recupera token para entrar no swarm.
docker swarm join-token worker

# Lista os nós do swarm (somente manager).
docker node ls 

# Remove um nó.
docker swarm leave # de dentro do nó.
docker node rm id