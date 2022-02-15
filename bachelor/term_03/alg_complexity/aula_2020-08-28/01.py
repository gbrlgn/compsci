#     0    1
p = [0.7, 1.2] #peso sináptico

ds = 
[
#    0  1
    [1, 0],
    [0, 1],
    [1, 1],
    [0, 0]
]

#    0  1  2  3
s = [0, 1, 1, 1]

#____MÈTODOS____
def soma(amostras, pesos):
    for i, v in enumerate(amostras):
        total += v * pesos[i]
        return total

def ativacao(soma):
    valor = 1

    if soma > 0:
        valor = 0

    return valor

def validacao(saida, idx):
    if saida == s[idx]:


    
    
# ____MAIN____
for i, a in enumerate(ds):

    total - soma(a, p)
    saida = ativacao(total)
    result = validacao(saida, i)

    print('Sum (a: {}, p: {}) = {}'.format(amostras, pesos, total))

print('End')
