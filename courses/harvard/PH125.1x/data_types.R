library(dslabs)

a <- 2

## get data type
class(a)
class(ls)

## import dataframe
data("murders")
class(murders)

## show structure of the dataframe
str(murders)

## show first six rows of the dataframe
head(murders)

## access variable (column) with $
murders$state

## access names of the columns
names(murders)


## define population object and get its
## vector length (number of items)
pop <- murders$population
length(pop)
class(pop)  

## character types use double quotes
class(murders$state)

## logical vectors (booleans)
z <- 3 == 2
class(z)
print(z)


## factor types store categorical data
## divided by levels
class(murders$region)
levels(murders$region)

## show number of occurrences of terms
## in a table
table(murders$region)
