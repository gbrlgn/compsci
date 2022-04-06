#include <iostream>
#include <string>
#include <map>

using namespace std;

const string PALAVRA = "MELANCIA";
map<char, bool> chutou;

bool letra_existe(char chute) {
    for (char letra : PALAVRA) {
        if (PALAVRA[letra] == chute) {
            return true;
        }
    }
    return false;
}

int main () {
    cout << "*******************************" << endl;
    cout << "* Bem-vindo ao jogo da forca! *" << endl;
    cout << "*******************************" << endl;

    bool nao_acertou = true;
    bool nao_enforcou = true;
    
    while (nao_acertou && nao_enforcou) {
        for (char letra : PALAVRA) {
            if (chutou[letra]) {
                cout << letra << " ";
            } else {
                cout << "_ ";
            }
        }

        cout <<  "Entre seu chute:" << endl;
        char chute;
        cin >> chute;
        chutou[chute] = true;
        cout <<  "O seu chute foi: " << chute << endl;

        if (letra_existe(chute)) {
            cout <<  "Você acertou!" << endl;
        } else {
            cout <<  "Você errou!" << endl;
        }
    }
}