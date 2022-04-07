#include <stdio.h>
#include <math.h>

void bhaskara(float a, float b, float c) {
    float delta = (pow(b, b)) - (4 * a * c);
    float xi = (-b + sqrt(delta)) / (2 * a);
    float xii = (-b - sqrt(delta)) / (2 * a);

    printf("O valor de X' é de: %f\n", xi);
    printf("O valor de X'' é de: %f\n", xii);
}

int main() {
    bhaskara(2.0, 3.0, 6.0);
    return 0;
}