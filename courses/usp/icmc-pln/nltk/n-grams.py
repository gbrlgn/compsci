                    # N-grams com o NLTK #

###############################################################################
import nltk
from nltk import bigrams, trigrams, ngrams

corpus = open('../corpus.txt', 'r')

gramTokens = nltk.word_tokenize(corpus.read())

# gerar N-gramas de três tipos
biTokens = list(bigrams(gramTokens))
triTokens = list(trigrams(gramTokens))
nTokens = list(ngrams(gramTokens, 4))

print(biTokens, '\n', triTokens, '\n', nTokens)

# imprimir bigramas com letras maiúsculas
# pois denotam nomes próprios
print(b for b in biTokens if b[0][0].isupper() and b[1][0].isupper())

# imprimir trigramas com letras maiúsculas
# pois denotam nomes próprios
print(t for t in triTokens if t[0][0].isupper() and t[1][0].isupper() and t[2][0].isupper(0))

corpus.close()

#######################################