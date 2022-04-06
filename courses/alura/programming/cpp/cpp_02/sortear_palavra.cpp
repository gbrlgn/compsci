#include <vector>
#include "letra_existe.hpp"

using namespace std;

extern string palavra_secreta;

string sortear_palavra() {
    vector<string> palavras = le_arquivo();
    srand(time(NULL));
    int indice_sorteado = rand() % palavras.size();

    return palavras[indice_sorteado];
}