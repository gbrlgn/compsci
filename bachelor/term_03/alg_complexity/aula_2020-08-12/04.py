#      0  1  2  3  4  5  6  7  8
lst = [1, 1, 1, 2, 3, 4, 5, 5, 6]

sum = 0
for p in lst :
  
    sum += p
    print(p)

    if sum > 300:
      
        print('sum result {} > 9'.format(sum))
        break

print('out of loop')
print('job end')
