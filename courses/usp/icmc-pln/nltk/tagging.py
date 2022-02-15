                    # Etiquetamento com o NLTK #

###############################################################################
import nltk
from nltk.corpus import mac_morpho
from nltk.tag import UnigramTagger

corpus = open('../corpus.txt', 'r')
tokens = nltk.word_tokenize(corpus.read())

# declarar sentenças treinadoras por meio do
# corpus padrão mac_morpho
trainSents = mac_morpho.tagged_sents()

# como o etiquetador não consegue identificar todas as palavras,
# deve-se classificar todas as palavras como substantivas (N) e
# treinar novamente o etiquetador
from nltk.tag import DefaultTagger
defTagger = DefaultTagger('N')

# criar etiquetador de unigramas
tagger = UnigramTagger(trainSents, backoff=defTagger)

# criar tags e imprimi-las
print(tagger.tag(tokens))

#######################################