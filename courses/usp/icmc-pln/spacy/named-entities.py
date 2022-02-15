                    # Entidades nomeadas no spaCy #

###############################################################################
import spacy

# carregar corpus
corpus = open('../corpus.txt', 'r')

# carregar o módulo inglês do spaCy
nlp = spacy.load('en_core_news_lg')

# tokenizar o texto a partir do módulo, 
# engendrando assim um objeto Document
doc = nlp(corpus)

# listar entidades nomeadas em cada token
namedEnts = list(doc.ents)
print(namedEnts)

# listar detalhes de cada entidade nomeada
entDetails = [(ent, ent.label_) for ent in doc.ents]

#######################################