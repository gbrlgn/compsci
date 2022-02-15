                    # Natural Language Toolkit #

###############################################################################
import nltk 

# baixar pacotes do NLTK
nltk.download()

# resgatar recursos associados ao corpus
dir(nltk.corpus.mac_morpho)

# número de palavras do corpus
nltk.corpus.mac_morpho.words()
len(nltk.corpus.mac_morpho.words())

# número de sentenças do corpus
nltk.corpus.mac_morpho.sents()
len(nltk.corpus.mac_morpho.sents())

# primeira sentença do mac_morpho
nltk.corpus.mac_morpho.sents()[1]

# palavras etiquetadas
nltk.corpus.mac_morpho.tagged_words()

# sentenças etiquetadas
nltk.corpus.mac_morpho.tagged_sents()

#######################################