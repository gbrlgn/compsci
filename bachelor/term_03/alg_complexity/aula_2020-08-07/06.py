list1 = [1, 2, 3, 4, 5, 'a', 'b', 'c', 'd']
list2 = ['banana', 'pineapple']
mat = [
    [1, 0, 1],
    [0, 4, 0],
    [1, 0, 1]
]


list2.append('orange')

list2.append(list1)
list2.append(mat)

print(list2[-1])
