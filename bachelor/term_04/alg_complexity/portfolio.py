import json

dic = open("game_list.json", "r")
games_dic = json.load(dic)


def printDic(dic):

    print(list(dic.items()), "\n")


def toList(dic):
    if dic == {}:
        print("Dicionário vazio.")
        return {}

    lst = []

    for val in list(dic.values()):
        lst.append(val)
        
    return lst


def partitionQuick(list, begin, end):
    i = (begin - 1)
    pivot = list[end]

    for j in range(begin, end):
        if list[j] <= pivot:
            i = i + 1
            list[i], list[j] = list[j], list[i]

    list[i + 1], list[end] = list[end], list[i + 1]
    return(i + 1)


def quickSort(list, begin, end):

    if list == []:
        print("Lista vazia.")
        return []

    elif begin < end:

        p = partitionQuick(list, begin, end)

        quickSort(list, begin, p - 1)
        quickSort(list, p + 1, end)
  
    return list


def mergeSort(unsorted):
    if unsorted == []:
        print("Lista vazia.")
        return []

    lst = [] 
    lst = unsorted
    size = len(lst)

    if size > 1:
        mid = size // 2
        left = lst[:mid]
        right = lst[mid:]

        mergeSort(left)
        mergeSort(right)

        p = 0
        q = 0
        r = 0
        left_size = len(left)
        right_size = len(right)

        while p < left_size and q < right_size:
            if left[p] < right[q]:
                lst[r] = left[p]
                p += 1

            else:
                lst[r] = right[q]
                q += 1
            r += 1

        while p < left_size:
            lst[r] = left[p]
            p += 1
            r += 1

        while q < right_size:
            lst[r] = right[q]
            q += 1
            r += 1

    return lst


def sorter(dic):
  
    games_lst = []
    tmp_lst = []
    
    games_lst = toList(dic)

    print("Preços dos jogos:")
    for i in games_lst:
        print("R$" + str(i))
 

    alg = input("Digite \"QUICK\" para ordenar o dicionário em ordem crescente usando o algoritmo Quick Sort; \nOu, então, digite \"MERGE\" para ordenar o dicionário usando o algoritmo Merge Sort:\n")

    if alg.upper() == "QUICK":
        print("\nOrdenando via Quick Sort...")
        tmp_lst = quickSort(games_lst, 0, len(games_lst) - 1)

    elif alg.upper() == "MERGE":
        print("\nOrdenando via Merge Sort...")
        tmp_lst = mergeSort(games_lst)

    else:
        print("Algoritmo inválido")
        return []

    return tmp_lst


print("Dicionário com valores não ordenados:")
printDic(games_dic)

sortedList = []
sortedList = sorter(games_dic)

print("\nPreços ordenados em ordem crescente:")
for i in sortedList:
    print("R$" + str(i))

dic.close()