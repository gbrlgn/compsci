#include <iostream>
#include <fstream>
#include "headers/salvar_arquivo.hpp"

salvar_arquivo(vector<string> lista) {
    ofstream arquivo;
    arquivo.open("palavras.txt");
    if (arquivo.is_open()) {
        arquivo << lista.size();
        for (string palavra : lista) {
            arquivo << palavra << endl;
        }
        arquivo.close();
    } else {
        cout << "Não foi possível acessar o banco de palavras." << endl;
        exit(0);
    }
}