import random

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


def imprime_matriz(matriz, case):

    if case == 0:
        print(f"\nMatriz original:\n")
    elif case == 1:
        print("\nMatriz após espelhamento:\n")
    elif case == 2:
        print("\nMatriz após a convolução:\n")
    else:
        print("\nMatriz após a normalização:\n")
    for fil in range(len(matriz)):
        print(str(matriz[fil]) + "\n")
    
    print("\n__________________________________________________________________________________________\n")


def normalizar(matriz):

    mat = matriz
    nmLin = len(mat)

    for i in range(nmLin):
        mat[i].sort()

    maxList = []
    for i in range(nmLin):
        maxList.append(mat[i][-1])
    maxList.sort()

    minList = []
    for j in range(nmLin):
        minList.append(mat[j][0])
    minList.sort()

    max, min = maxList[-1], minList[0]

    for l in range(len(mat)):
        for c in range(len(mat[l])):
            val = mat[l][c]
            mat[l][c] = int((255 / (max - min)) * (val - min))

    return mat


def espelhar(mat):

    nmLin = len(mat)
    
    for l in range(nmLin):

            nmCol = len(mat[l])
            for c in range(nmCol):

                if l == 0 or l == nmLin -1 or c == 0 or c == nmCol - 1:
                    mat[l][c] = 0
        

def convolucao(matriz, kernel):

    mat1 = matriz
    kn = kernel

    kn1 = kn[0][0]
    kn2 = kn[0][1]
    kn3 = kn[0][2]
    kn4 = kn[1][0]
    kn5 = kn[1][1]
    kn6 = kn[1][2]
    kn7 = kn[2][0]
    kn8 = kn[2][1]
    kn9 = kn[2][2]

    espelhar(mat1)
    imprime_matriz(mat1, 1)

    nmLin = len(mat1)
    lin = 0
    for l in range(nmLin):
        if lin > 0 and lin != nmLin - 1:

            nmCol = len(mat1[l])
            col = 0
            for c in range(nmCol):
                if col > 0 and col != nmCol - 1:

                    mat1[l][c] = (mat1[l-1][c-1] * kn1) + (mat1[l-1][c] * kn2) + (mat1[l-1][c+1] * kn3) + (mat1[l][c-1] * kn4) + (mat1[l][c] * kn5) + (mat1[l][c+1] * kn6) + (mat1[l+1][c-1] * kn7) + (mat1[l+1][c] * kn8) + (mat1[l+1][c+1] * kn9)
                
                col += 1

        lin += 1
    
    imprime_matriz(mat1, 2)

    return normalizar(mat1)


kernel = [
    [0, -1,  0],
    [-1, 4, -1],
    [0, -1,  0]
]
ds1 = gera_matriz(20, 0, 200)

imprime_matriz(ds1, 0)

imprime_matriz(convolucao(ds1, kernel), 3)