                    # Tokenização com o NLTK #

###############################################################################
import nltk

txt = '''Il n'ya pas lieu de craindre ou d'ésperer, 
        mais de chercher de nouvelles armes.'''
tokens = nltk.word_tokenize(txt)
print(tokens)

#######################################

# site para testes de expressões regulares: pythex.org

# tokenizar utilizando expressões regulares 
from nltk.tokenize import RegexpTokenizer

# todos os tokens (palavras, dígitos e underscores)
allTokenizer = RegexpTokenizer(r'\w+')
allRegexpTks = allTokenizer.tokenize(txt)
print(allRegexpTks)

# somente tokens alfabéticos
wordTokenizer = RegexpTokenizer(r'[A-z]\w*')
wordRegexpTks = wordTokenizer.tokenize(txt)
print(wordRegexpTks)

# utilização da classe FreqDist para a contagem de tokens
# e obtenção da frequência de aparecimento de termos
freq = nltk.FreqDist(allRegexpTks)

# impressão dos 5 tokens mais comuns no texto
print(freq.most_common(5))

#######################################