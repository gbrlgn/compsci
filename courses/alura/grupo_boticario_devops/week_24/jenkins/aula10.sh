# Criar o job para colocar a app em producao:
    Nome: todo-list-producao
    Tipo: Freestyle
    # Este build é parametrizado com 2 Builds de Strings:
        Nome: image
        Valor padrão: - Vazio, pois o valor sera recebido do job anterior.

        Nome: DOCKER_HOST
        Valor padrão: tcp://127.0.0.1:2376

    # Ambiente de build > Provide configuration files
        File: .env-prod
        Target: .env

    # Build > Executar shell
        #Execute shell
        #!/bin/sh
        { 
            docker run -d -p 80:8000 -v /var/run/mysqld/mysqld.sock:/var/run/mysqld/mysqld.sock -v /var/lib/jenkins/workspace/todo-list-producao/.env:/usr/src/app/to_do/.env --name=django-todolist-prod $image:latest

        } || { # catch
            docker rm -f django-todolist-prod
            docker run -d -p 80:8000 -v /var/run/mysqld/mysqld.sock:/var/run/mysqld/mysqld.sock -v /var/lib/jenkins/workspace/todo-list-producao/.env:/usr/src/app/to_do/.env --name=django-todolist-prod $image:latest
        }    

Ações de pós-build > Slack Notifications: Notify Success e Notify Every Failure