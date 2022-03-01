# Atualizar o valor da chave "total_de_respostas" para 1446015 e
# recuperar o valor para confirmar sua atualização.

SET "total_de_respostas" 1446015
GET "total_de_respostas"


# Definir "guilherme silveira" como chave e remover chave e valor utilizando DEL. 
SET "ultimo_usuario_que_se_logou" "guilherme silveira"
GET "ultimo_usuario_que_se_logou"
DEL "ultimo_usuario_que_se_logou"

# Verificar se chave e valor foram removidos utilizando GET, que deve devolver nil.
GET "ultimo_usuario_que_se_logou"

# Por padrão o banco Redis não envolve duas chamadas em um conceito de transição, 
# e cada uma delas é executada de maneira atômica por si só, mas não em conjunto. 
#Por exemplo um GET que retorna 40, e um SET que vai alterar o valor para 500, 
# podem ter sido feitos 100, 1000, 10000 atualizações neste valor.

# O comando SETBIT permite que seja representada uma sequência de valores binários, 
# ou bitmaps. Um bitmap funciona como um array que armazena zeros e uns 
# associados a um offset.