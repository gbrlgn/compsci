#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <fstream>
#include <cstdlib>
#include "nao_acertou.hpp"
#include "letra_existe.hpp"
#include "imprimir_cabecalho.hpp"
#include "ler_arquivo.hpp"
#include "sortear_palavra.hpp"
#include "imprimir_erros.hpp"
#include "imprimir_palavra.hpp"
#include "chutar.hpp"
#include "adicionar_palara.hpp"

using namespace std;

map<char, bool> chutou;
vector<char> chutes_errados;

int main () {
    imprimir_cabecalho();

    string palavra_secreta = sortear_palavra();

    bool nao_enforcou = true;
    
    while (nao_acertou(palavra_secreta, chutou) && chutes_errado.size() < 5) {
        imprimir_erros(chutes_errados);

        imprimir_palavra_secreta(palavra_secreta, chutou);

        chutar(&chutou, &chutes_errados);
    }

    cout << "****************" << endl;
    cout << "* Fim de jogo! *" << endl;
    cout << "****************" << endl;
    cout << endl;

    cout << "A palavra secreta era: " << palavra_secreta << endl;
    if (nao_acertou()) {
        cout << "Você perdeu! Tente novamente." << endl;
    } else {
        cout << "Parabéns! Você acertou a palavra secreta!" << endl;

        cout << "Você deseja adicionar uma nova palavra ao banco? (S/N)" << endl;
        char resposta;
        cin >> resposta;
        if (resposta == 'S') {
            adicionar_palavra();
        }
    }
}