                    # Manipulação de corpi com o NLTK #

###############################################################################
import nltk
from nltk import RegexpTokenizer

corpus = open('../corpus.txt', 'r')

# este tokenizador mantém stopwords
corpAllTokenizer = RegexpTokenizer(r'\w+')
corpAllRegexpTks = corpAllTokenizer.tokenize(corpus.read())

# lista com stopwords da língua portuguesa
stopwords = nltk.corpus.stopwords.words('english')

listaSuja, listaLimpa = []

# adicionar todos os tokens em uma lista não filtrada
listaSuja = [i.lower() for i in corpAllRegexpTks]

print(listaSuja)

# adicionar os tokens que não se enquadram como stopwords
# em uma lista filtrada a partir da lista de stopwords
listaLimpa = [j.lower() for j in corpAllRegexpTks if j or j.lower() not in stopwords]

print(listaLimpa)

# exibir a frequência dos tokens da lista suja
corpFreqSuja = nltk.FreqDist(listaSuja)
print(corpFreqSuja.most_common())

# exibir a frequência dos tokens da lista limpa
corpFreqLimp = nltk.FreqDist(listaLimpa)
print(corpFreqLimp.most_common())

#######################################