import random

def imprime_matriz(matriz, case, n):

    if case == 0:
        print(f"Matriz original {n}:\n")
    else:
        print("Matriz após a soma:\n")

    for fil in range(len(matriz)):
        print(str(matriz[fil]) + "\n")


def gera_matriz(dim, ini, fim):
   
    tmp = [random.randint(ini, fim) for i in range(dim * dim)]
    ds = []
    pos = 0

    for _ in range(dim):
        linha = []

        for _ in range(dim):
            linha.append(tmp[pos])
            pos += 1
        
        ds.append(linha)

    return ds

def normalizar(matriz):

    soma = matriz

    max = 0
    for l in range(len(soma)):
        for c in range(len(soma[l])):
            if soma[l][c] > max:
                max = soma[l][c] 
            else:
                max = max

    min = 255
    for l in range(len(soma)):
        for c in range(len(soma[l])):
            if soma[l][c] < min:
                min = soma[l][c] 
            else:
                min = min

    for l in range(len(soma)):
        for c in range(len(soma[l])):
            soma[l][c] = int((255 / (max - min)) * soma[l][c] - min)

    return soma


def soma_matriz(mat1, mat2):

    soma = []
    pos = 0

    for l in range(len(mat1)):
        linha = []

        for c in range(len(mat1)):
            linha.append(mat1[l][c] + mat2[l][c])
            pos += 1
            
        soma.append(linha)

    min = 0
    for l in range(len(soma)):
        for c in range(len(soma[l])):
            if soma[l][c] < min:
                min = soma[l][c] 
            else:
                min = min

    return normalizar(soma)


ds1 = gera_matriz(5, 0, 100)
ds2 = gera_matriz(5, 101, 200)

imprime_matriz(ds1, 0, 1)
print("\n")

imprime_matriz(ds2, 0, 2)
print("\n")

soma = soma_matriz(ds1, ds2)
imprime_matriz(soma, 1, 0)