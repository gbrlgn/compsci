LPUSH ultimas_noticias "Jogador de futebol e flagrado jogando basquete na rua"
LPUSH ultimas_noticias "Novo curso de Redis e lancado pelo Alura"
LPUSH ultimas_noticias "Guilherme Silveira faz aniversário e espera presentes...sentado"

# Recuperar a notícia mais recente armazenada na lista.
LINDEX utlimas_noticias 0
# Recuperar as duas notícias mais recentes.
LINDEX ultimas_noticias 0 1

# Descobrir o tamanho da lista.
LLEN ultimas_noticias
# Deixar a lista com apenas as três últimas notícias.
LTRIM ultimas_noticias 0 2

# Confirmar que a lista possui realmente 3 elementos
# e garantir que eles estão inseridos na ordem desejada.
RPUSH "fila:confirma-email" "guilherme.silveira@alura.com.br"
LLEN "fila:confirma-email"
RPUSH "fila:confirma-email" "daniela.mikyung@alura.com.br"
LLEN "fila:confirma-email"
RPUSH "fila:confirma-email" "carlos.felicio@alura.com.br"

# Remover e recuperar o primeiro valor da fila, 
# de forma que a operação seja realizada de maneira atômica.
LPOP "fila:confirma-email"
# Remover e recuperar o último elemento.
POP "fila:confirma-email"
LEN "fila:confirma-email"

# Remover o primeiro elemento na fila cuja chave é "fila:confirma-email",
# de forma que ele fique bloqueado por 60 segundos caso não exista valor 
# a ser removido
BLPOP "fila:confirma-email" 60000

# Remover todos os elementos da fila bloqueando por um tempo inderteminado. 
BLPOP fila:confirma-email 0


# Adicionar os seguintes valores em um conjunto associados à chave "relacionamentos:guilherme".
SADD "relacionamentos:guilherme" "daniela" "carlos" "ana" "lucia"
# Descobrir a quantidade de elementos que no nosso conjunto.
SCARD "relacionamentos:guilherme"

# Remover o elemento "ana" do conjunto "relacionamentos:guilherme".
SREM "ana" "relacionamentos:guilherme"

# Recuperar todos os elementos do conjunto "relacionamentos:guilherme".
SMEMBERS "relacionamentos:guilherme"
# Descobrir se o elemento "marcela" é um membro do conjunto "relacionamentos:guilherme".
SISMEMBER "relacionamentos:guilherme" "marcela"

# Recuperar os amigos comuns entre "relacionamentos:guilherme" e "relacionamentos:marcela".
SINTER "relacionamentos:guilherme" "relacionamentos:marcela"

# Descobrir quem o Guilherme("relacionamentos:guilherme") conhece 
# que a Marcela (relacionamentos:marcela) não conhece.
SDIFF "relacionamentos:guilherme" "relacionamentos:marcela"


Para saber mais: União de conjuntos

# Retornar todos os elementos dos dois conjuntos, sem repetição. 
SUNION "relacionamentos:guilherme" "relacionamentos:marcela"

# Saber o tipo da chave "pontuações".
ZADD pontuacoes 50076 guilherme
ZADD pontuacoes 65543 carlos
ZADD pontuacoes 33786 daniela
ZADD pontuacoes 8754 paulo
TYPE "pontuacoes"

# Visualizar os elementos do conjunto criado. 
ZRANGE pontuacoes 0 3
# Visualizar em ordem reversa.
ZREVRANGE pontuacoes 0 3

# Trazer os elementos dos conjuntos e seus pontos de uma forma que não tenha
# perigo de que enquanto digitamos o comando um novo elemento seja adicionado 
# e acabe ficando de fora.
ZREVRANGE pontuacoes 0 -1 WITHSCORES

# Trazer o penúltimo e o último elemento, com a pontuação.
ZRANGE pontuacoes -2 -1 WITHSCORES

# Aumentar pontuação em 50000.
ZINCRBY pontuacoes 50000 guilherme
# Saber a pontuação do elemento "paulo". 
ZSCORE pontuacoes paulo
# Saber a posição do elemento "guilherme" no ranking em ordem crescente.
ZRANK pontuacoes guilherme
# Em ordem descrescente.
ZREVRANK pontuacoes guilherme

# Verificar se agora temos os IDs atrelados aos pontos.
ZADD pontuacoes 50000 55
ZADD pontuacoes 30000 35
ZADD pontuacoes 300000 65
ZRANGE pontuacoes 0 -1