#include <stdio.h>
#include <math.h>

float sigmoid(float x) {
    return 1 / (1 + exp(-1 * x));
}

int main() {
    float value = sigmoid(2);
    printf ("O valor da sigmoid é de: %f\n", value);
    return 0;
}
