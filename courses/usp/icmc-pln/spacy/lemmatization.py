                    # Lematização com o spaCy #

###############################################################################
import spacy

# carregar corpus
corpus = open('../corpus.txt', 'r')

# carregar o módulo inglês do spaCy
nlp = spacy.load('en_core_news_lg')

# tokenizar o texto a partir do múdulo, 
# engendrando assim um objeto Document
doc = nlp(corpus)

# utilizar o parâmetro pos_ (part of speech) para obter os verbos
# de cada token do Document caso 'VERB' == true, assim como o
# parâmetro lemma_ para lemmatizar cada uma das palavras obtidas.
lemmaTokens = [token.lemma_ for token in doc if token.pos_ == 'VERB']
print(lemmaTokens)

#######################################