                    # Visualização com o displaCy #

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

# gerar um HTML das entidades selecionadas
# por meio da função render
html = spacy.displacy.render(doc, style='ent')

# criar um caminho de saída para um arquivo HTML
# utilizando a codificação UTF-8
output_path.open('named-entities.html', 'w', encoding='utf-8')
output_path.write(html)
output_path.close()

#######################################