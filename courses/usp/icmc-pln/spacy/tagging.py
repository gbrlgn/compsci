                    # Etiquetamento com o spaCy #

###############################################################################
import spacy

# carregar corpus
corpus = open('../corpus.txt', 'r')

# carregar o módulo inglês do spaCy
nlp = spacy.load('en_core_news_lg')

# tokenizar o texto a partir do módulo, 
# engendrando assim um objeto Document
doc = nlp(corpus)

# etiquetar cada token em uma lista de tuplas
# por meio dos parâmetros orth_ e pos_
pos = [(token.orth_, token.pos_) for token in doc]
print(pos)

#######################################