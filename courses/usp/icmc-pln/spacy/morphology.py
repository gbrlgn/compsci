                    # Morfologia no spaCy #

###############################################################################
import spacy

# carregar corpus
corpus = open('../corpus.txt', 'r')

# carregar o módulo inglês do spaCy
nlp = spacy.load('en_core_news_lg')

# tokenizar o texto a partir do módulo, 
# engendrando assim um objeto Document
doc = nlp(corpus)

# etiquetar cada token em uma lista de tuplas com
# palavras e sua morfologia por meio dos parâmetros 
# orth_ e morph_
morphologies = [(token.orth_, token.morph_) for token in doc]
print(morphologies)

#######################################