list1 = [1, 2, 3, 4, 5, 'a', 'b', 'c', 'd']
list2 = ['banana', 'pineapple']
mat = [
    [1, 0, 1],
    [0, 4, 0],
    [1, 0, 1]
]

print(len(list2))
print(len(list1))

print('------')

list2.append('orange')

print(len(list2))
list2.append(list1)
list2.append(mat)
print(len(list2))

print(list2)
