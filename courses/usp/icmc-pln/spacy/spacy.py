                    # spaCy #

###############################################################################
import spacy

# inicializar uma variável para ser tokenizada
txt = 'You? Never... did - The Kenosha, Kid!'

# carregar o módulo portugês do spaCy
nlp = spacy.load('en_core_news_lg')

# tokenizar o texto a partir do múdulo, 
# engendrando assim um objeto Document
doc = nlp(txt)

# utilizar o parâmetro orth_ para obter a palavra
# de cada token do Document
orth = [token.orth_ for token in doc]
print(orth)

# utilizar o parâmetro is_alpha para obter a palavra
# de cada token do Document, caso seja alfabética
alphaTokens = [token.orth_ for token in doc if token.is_alpha]
print(alphaTokens)

# utilizar o parâmetro is_digit para obter a palavra
# de cada token do Document, caso seja numérica
digitTokens = [token.orth_ for token in doc if token.is_digit]
print(digitTokens)

# utilizar o parâmetro is_punct para obter toda a
# pontuação a partir de cada token do Document
punctTokens = [token.orth_ for token in doc if token.is_punct]
print(punctTokens)

#######################################