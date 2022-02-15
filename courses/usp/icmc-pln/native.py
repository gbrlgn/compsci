                    # Recursos padrões do Python #

###############################################################################

corpus = open('corpus.txt', 'r')
print(corpus.read())

sep = corpus.read()

split = sep.split()
print(split)

sepSpace = ' '.join(split)
print(sepSpace)

sepSlash = '/'.join(split)
print(sepSlash)

wdCount = len(sep.split())
print(wdCount)

corpus.close()

#######################################