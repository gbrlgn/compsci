                    # Chunking com o NLTK #

###############################################################################
import nltk
from nltk.corpus import mac_morpho
from nltk.tag import UnigramTagger
from nltk.chunk import RegexpParser

tokens = nltk.word_tokenize(nltk.corpus.mac_morpho)
trainSents = mac_morpho.tagged_sents()

from nltk.tag import DefaultTagger
defTagger = DefaultTagger('N')

tagger = UnigramTagger(trainSents, backoff=defTagger)
tags = tagger.tag(tokens)

# usar esta expressão regular como padrão utilizado no 
# chunking, podendo assim recuperar entidades nomeadas 
# como nomes próprios ou substantivos em pares
pattern = 'NP:{<NPROP><NPROP>|<N><N>}'

# definir uma análise gramatical por meio da expressão
# regular definida como padrão 
gramAnalysis = RegexpParser(pattern)

# gerar uma árvore sintática partindo da análise gramatical
tree = gramAnalysis.parse(tags)
print(tree)

# desenhar a árvore sintática
tree.draw()

#######################################