# Instalar o plugin Config File Provider

# Configurar o Managed Files para Dev
    # Name : .env-dev
        [config]
        # Secret configuration
        SECRET_KEY = 'r*5ltfzw-61ksdm41fuul8+hxs$86yo9%k1%k=(!@=-wv4qtyv'
        # conf
        DEBUG=True
        # Database
        DB_NAME = "todo_dev"
        DB_USER = "devops_dev"
        DB_PASSWORD = "mestre"
        DB_HOST = "localhost"
        DB_PORT = "3306"

#Configurar o Managed Files para Prod
    # Name: .env.-prod
        [config]
        # Secret configuration
        SECRET_KEY = 'r*5ltfzw-61ksdm41fuul8+hxs$86yo9%k1%k=(!@=-wv4qtyv'
        # conf
        DEBUG=False
        # Database
        DB_NAME = "todo"
        DB_USER = "devops"
        DB_PASSWORD = "mestre"
        DB_HOST = "localhost"
        DB_PORT = "3306"

# No job: jenkins-todo-list-principal importar o env de dev para teste:

    Adicionar passo no build: Provide configuration Files
    File: .env-dev
    Target: ./to_do/.env

    Adicionar passo no build: Executar Shell

# Criando o Script para Subir o container com o arquivo de env e testar a app:
    #!/bin/sh

    # Subindo o container de teste
    docker run -d -p 82:8000 -v /var/run/mysqld/mysqld.sock:/var/run/mysqld/mysqld.sock -v /var/lib/jenkins/workspace/jenkins-todo-list-principal/to_do/.env:/usr/src/app/to_do/.env --name=todo-list-teste django_todolist_image_build

    # Testando a imagem
    docker exec -i todo-list-teste python manage.py test --keep
    exit_code=$?

    # Derrubando o container velho
    docker rm -f todo-list-teste

    if [ $exit_code -ne 0 ]; then
        exit 1
    fi