library(dslabs)
data(movielens)

## 01
a <- 2
b <- -1
c <- -4
  
solution_1 <- (-b + sqrt(b^2 - 4*a*c)) / (2*a)
solution_2 <- (-b - sqrt(b^2 - 4*a*c)) / (2*a)

print(solution_1)
print(solution_2)

## 02
print(log(1024, 4))

## 03a, b, c, d
str(movielens)
class(movielens$title)
class(movielens$genres)

## 04
nlevels(movielens$genres)
