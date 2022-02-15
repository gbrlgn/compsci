## R coerces values to according types
x <- c(1, "Monad", 3)
class(x)

## convert to characters with as.character
x <- c(1, 2, 3)
class(x)

y <- as.character(x)
class(y)

## convert to numeric with as.numeric
x <- c("1", "2", "3")
class(x)

y <- as.numeric(x)
class(y)

## R has a type for missing numbers: NA
x <- c("1", "b", "3")
class(x)

y <- as.numeric(x)
class(y)