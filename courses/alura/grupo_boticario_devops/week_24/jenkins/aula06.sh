# Sugested Plugins
# Instalando os plugins
    Gerenciar Jenkins -> Gerenciar Plugins -> Disponíveis
        # docker
    Install without restart -> Depois reiniciar o jenkins
Gerenciar Jenkins -> Configurar o sistema -> Nuvem
    # Name: docker
    # URI: tcp://127.0.0.1:2376
    # Enabled
# This project is parameterized: 
    DOCKER_HOST
    tcp://127.0.0.1:2376
# Voltar no job criado na aula anterior
    # Manter a mesma configuracao do GIT para desenvolvimento
    # Build step 1: Executar Shell
# Validando a sintaxe do Dockerfile
docker run --rm -i hadolint/hadolint < Dockerfile
    # Build step 2: Build/Publish Docker Image
        Directory for Dockerfile: ./
        Cloud: docker
        Image: rafaelvzago/django_todolist_image_build