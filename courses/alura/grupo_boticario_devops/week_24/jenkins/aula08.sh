# Criar app no slack: alura-jenkins.slack.com
    URL básico: <Url do Jenkins app no seu canal do Slack>
    Token de integração: <Token do Jenkins app no seu canal do Slack>

# Instalar o plugin do slack: Gerenciar Jenkins > Gerenciar Plugins > Disponíveis: Slack Notification
        # Configurar no jenkins: Gerenciar Jenkins > Configuraçao o sistema > Global Slack Notifier Settings
            # Slack compatible app URL (optional): <Url do Jenkins app no seu canal do Slack>
            # Integration Token Credential ID : ADD > Jenkins > Secret Text
                # Secret: <Token do Jenkins app no seu canal do Slack>
                # ID: slack-token
            # Channel or Slack ID: pipeline-todolist

# As notificações vão funcionar da seguinte maneira:
Job: todo-list-desenvolvimento será feito pelo Jenkinsfile (Próximas aulas)
Job: todo-list-producao: Ações de pós-build > Slack Notifications: Notify Success e Notify Every Failure