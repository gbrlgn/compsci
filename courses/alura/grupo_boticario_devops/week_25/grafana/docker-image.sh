# Entrar na VM do Vagrant.
vagrant up
vagrant ssh

# Atualizar a VM.
sudo apt-get update && sudo apt-get upgrade -y

# Download do script.
curl -fsSL https://get.docker.com -o get-docker.sh 

# Instalando.
sh get-docker.sh 

# Dando permissão para o usuário.
sudo usermod -aG docker vagrant 

# Recarregando as permissões.
exit
vagrant ssh

# Testando a instalação.
docker ps

# Criando o diretorio para a instalação do Grafana.
$ mkdir -p  $PWD/grafana-alura/volumes/grafana
$ cd $PWD/grafana-alura/

# Criando a rede do docker para o grafana.
$ docker network create grafana-net

# Definindo a instalação do grafana para o user atual e instalando.
ID=$(id -u)
docker run -d --user $ID -v "$PWD/volumes/grafana:/var/lib/graf -p 3000:3000 --name=grafana --network=grafana-net grafana/grafana
docker ps