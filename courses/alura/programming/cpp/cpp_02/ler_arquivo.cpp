#include <iostream>
#include <fstream>
#include <cstdlib>
#include "headers/ler_arquivo.hpp"

vector<string> ler_arquivo(){
    ifstream arquivo;
    arquivo.open("palavras.txt");

    if (arquivo.is_open()) {
        int quantidade_palavras;
        arquivo >> quantidade_palavras;

        cout << "O arquivo possui " << quantidade_palavras << " palavras." << endl;

        vector<string> palavras_do_arquivo;
        for (int i = 0; i < quantidade_palavras; i++) {
            string palavra_lida;
            arquivo >> palavra_lida;
            palavras_do_arquivo.push_back(palavra_lida);
        }
        arquivo.close();
    } else {
        cout << "Não foi possível acessar o banco de palavras." << endl;
        exit(0);
    }
    
    return palavras_do_arquivo;
}