#include <iostream>
#include "imprimir_palavra.hpp"

using namespace std;

void imprimir_palavra_secreta(string palavra_secreta, map<char, bool> chutou) {
    for (char letra : palavra_secreta) {
        if (chutou[letra]) {
            cout << letra << " ";
        } else {
            cout << "_ ";
        }
    }
}