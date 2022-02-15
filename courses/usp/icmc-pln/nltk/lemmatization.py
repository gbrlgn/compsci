                    # Lemmatização com o NLTK #

###############################################################################
import nltk

# criar um lemmatizador para o inglês utilizando o 
# Wordnet, que converte a palavra para o infinitivo
lemmatizer = nltk.stem.WordNetLemmatizer()

print(lemmatizer.lemmatize('friendly', pos='n'))
print(lemmatizer.lemmatize('propose', pos='v'))
print(lemmatizer.lemmatize('studied', pos='n'))
print(lemmatizer.lemmatize('studying', pos='v'))
print(lemmatizer.lemmatize('sings', pos='v'))

#######################################