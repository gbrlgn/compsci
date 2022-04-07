#include <iostream>
#include "chuta.cpp"
#include "headers/letra_existe.cpp"

using namespace std;

void chutar(map<char, bool> chutou, vector<char> chutes_errados) {
    cout <<  "Entre seu chute:" << endl;
    char chute;
    cin >> chute;

    (*chutou)[chute] = true;
    cout <<  "O seu chute foi: " << chute << endl;

    if (letra_existe(chute)) {
        cout <<  "Você acertou!" << endl;
    } else {
        cout <<  "Você errou!" << endl;
        chutes_errados->push_back(chute);
    }
    cout << endl;
}