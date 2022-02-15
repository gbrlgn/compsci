                    # Stemmização com o NLTK #

###############################################################################
import nltk

# criar um stemmatizador para a língua portuguesa utilizando
# o RSLP, que remove sufixos de palavras
stemmer = nltk.RSLPStemmer()

print(stemmer.stem('amigão'))
print(stemmer.stem('propuseram'))
print(stemmer.stem('propõem'))
print(stemmer.stem('propondo'))

#######################################