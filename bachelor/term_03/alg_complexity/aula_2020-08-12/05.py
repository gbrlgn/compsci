# i =  0  1  2  3  4  5  6  7  8
lst = [1, 1, 1, 2, 3, 4, 5, 5, 6]

sum = 0
for i,p in enumerate(lst) :
   
    sum += p
    print(p)

    if sum > 9:
       
        print('sum result {} > 9, and, ended in the iteration {}'.format(sum, i))
        break
        # fim do bloco if

    # fim do bloco for

print('out of loop')
print('job end')
