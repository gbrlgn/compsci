                    # Análise de dependências com o spaCy #

###############################################################################
import spacy
from pathlib import Path

# inicializar uma variável para ser tokenizada
txt = 'You? Never... did - The Kenosha, Kid!'

# carregar o módulo portugês do spaCy
nlp = spacy.load('en_core_news_lg')

# tokenizar o texto a partir do múdulo, 
# engendrando assim um objeto Document
doc = nlp(txt)

syntax = [(token.orth_, token.dep_) for token in doc]
print(syntax)

# gerar um SVG das dependências entre tokens 
# selecionados por meio da função render
svg = spacy.displacy.render(doc, style='dep')

# criar um caminho de saída para um arquivo SVG
# utilizando a codificação UTF-8
output_path.open('dependency-analysis.svg', 'w', encoding='utf-8')
output_path.write(svg)
output_path.close()

#######################################