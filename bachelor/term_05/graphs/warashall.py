INF = 999

def warshall(grafo, nv): # nv = número de vértices
    distancia = list(map(lambda p: list(map(lambda q: q, p)), grafo))

    # Somar vértices individualmente
    for k in range(nv):

        for i in range(nv):

            for j in range(nv): 

                distancia[i][j] = min(distancia[i][j], distancia[i][k]+ distancia[k][j])

    saida(distancia)

# Imprimir o resultado
def saida(distancia):
    
    for p in range(nv):
        for q in range(nv):
            if (distancia[p][q] == INF):
                print("INF", end = " ")
            else:
                print(distancia[p][q], end = " 
        print(" ")
    
grafo = [[1, 6, INF, INF],
        [55, 0, 5, 19],
        [INF, 7, INF, 13],
        [0, 66, 13, INF]]

warshall(grafo, 4)