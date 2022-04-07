#include <iostream>
#include "headers/imprimir_erros.hpp"

void forca::imprimir_erros(const vector<char> &chutes_errados) {
    using namespace std;
    
    cout << "Chutes errados:" << endl;
    for (char letra : chutes_errados) {
        cout << letra << " ";
    }
    cout << endl;
}
