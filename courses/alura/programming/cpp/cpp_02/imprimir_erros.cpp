#include <iostream>
#include "imprimir_erros.hpp"

using namespace std;

void imprimir_erros(vector<char> chutes_errados) {
    cout << "Chutes errados:" << endl;
    for (char letra : chutes_errados) {
        cout << letra << " ";
    }
    cout << endl;
}