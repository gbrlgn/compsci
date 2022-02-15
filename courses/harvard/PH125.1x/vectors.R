## concatenate values
x <- c(112, 657, 323, 986)
y <- c("Spinoza", "Leibniz", "Nietzsche", "Deleuze")
print(x)
print(y)

## naming vector entries
codes <- c(italy=380, canada=124, egypt=818)

class(codes)

## assign values to vector columns
## codes <- c(380, ...)
## country <- c("italy, ...)
## names(codes) <- country

## access with square brackets
codes[["italy"]]
codes[2]
codes[c(1,2)]
codes[1:2]

## initialize sequence; start, stop, step
seq(1, 10, 2)
1:10