#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <fstream>
#include <cstdlib>
#include <ctime>

using namespace std;

string palavra_secreta;
map<char, bool> chutou;

bool letra_existe(char chute) {
    for (char letra : palavra_secreta) {
        if (palavra_secreta[letra] == chute) {
            return true;
        }
    }
    return false;
}

bool nao_acertou() {
    for (char letra : palavra_secreta) {
        if (!chutou[letra]) {
            return true;
        }
    }
    return false;
}

bool nao_enforcou() {
    return chutes_errado.size() < 5;
}

void imprime_cabecalho() {
    cout << "*******************************" << endl;
    cout << "* Bem-vindo ao jogo da forca! *" << endl;
    cout << "*******************************" << endl;
    cout << endl;
}

void imprime_erros() {
    cout << "Chutes errados:" << endl;
    for (char letra : chutes_errados) {
        cout << letra << " ";
    }
    cout << endl;
}

void imprime_palavra_secreta() {
    for (char letra : palavra_secreta) {
        if (chutou[letra]) {
            cout << letra << " ";
        } else {
            cout << "_ ";
        }
    }
}

void chutarr() {
    cout <<  "Entre seu chute:" << endl;
    char chute;
    cin >> chute;
    chutou[chute] = true;
    cout <<  "O seu chute foi: " << chute << endl;

    if (letra_existe(chute)) {
        cout <<  "Você acertou!" << endl;
    } else {
        cout <<  "Você errou!" << endl;
        chutes_errados.push_back(chute);
    }
    cout << endl;
}

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

void sortear_palavra() {
    vector<string> palavras = le_arquivo();
    srand(time(NULL));
    int indice_sorteado = rand() % palavras.size();

    palavra_secreta = palavras[indice_sorteado];
}

void adicionar_palavra() {
    cout << "Digite a nova palavra, em letras maiúsculas: " << endl;
    string nova_palavra;
    cin >> nova_palavra;

    vector<string> lista = le_arquivo();
    lista.push_back(nova_palavra);

    salvar_arquivo(lista);
}

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

int main () {
    imprime_cabecalho();

    ler_arquivo();

    sortear_palavra();

    vector<char> chutes_errados;
    bool nao_enforcou = true;
    
    while (nao_acertou() && nao_enforcou()) {
        imprime_erros();

        imprime_palavra_secreta();

        chutarr();
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