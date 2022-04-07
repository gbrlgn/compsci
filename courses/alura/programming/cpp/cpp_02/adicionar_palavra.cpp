#include <iostream>
#include <vector>
#include <string>
#include <fstream>
#include "headers/ler_arquivo.hpp"
#include "headers/salvar_arquivo.hpp"

void adicionar_palavra() {
    cout << "Digite a nova palavra, em letras maiúsculas: " << endl;
    string nova_palavra;
    cin >> nova_palavra;

    vector<string> lista = le_arquivo();
    lista.push_back(nova_palavra);

    salvar_arquivo(lista);
}