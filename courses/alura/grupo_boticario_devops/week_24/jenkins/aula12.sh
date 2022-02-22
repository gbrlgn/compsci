# Subindo o container com o Sonarcube
  Na máquina devops (Vagrant): docker run -d --name sonarqube -p 9000:9000 sonarqube:lts
  # Acessar: http://192.168.33.10:9000
    Usuário: admin
    Senha: admin
    Name: jenkins-todolist
        Provide a token: jenkins-todolist e anotar o seu token
        Run analysis on your project > Other (JS, Python, PHP, ...) > Linux > django-todo-list
        # Copie o shell script fornecido

sonar-scanner \
  -Dsonar.projectKey=jenkins-todolist \
  -Dsonar.sources=. \
  -Dsonar.host.url=http://192.168.33.10:9000 \
  -Dsonar.login=<seu token>