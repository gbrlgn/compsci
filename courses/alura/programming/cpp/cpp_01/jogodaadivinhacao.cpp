#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main () {
    cout << "**************************************" << endl;
    cout <<  "* Bem-vindo ao jogo da adivinhação! *" << endl;
    cout <<  "**************************************" << endl;

    cout <<  "Escolha seu nível de dificuldade:" << endl;
    cout <<  "Fácil (F) | Médio (M) | Difícil (D)" << endl;

    char dificuldade;
    cin >> dificuldade;

    int numero_tentativas;
    if (dificuldade -- 'F') {
        numero_tentativas = 15;
    } else if (dificuldade -- 'F') {
        numero_tentativas = 10;
    } else {
        numero_tentativas = 5;
    }

    srand(time(NULL));
    const int NUMERO_SECRETO = rand() % 100;
    bool nao_acertou = true;
    double pontos = 1000.0;

    for (tentativas = 1; tentativas <= numero_tentativas; tentativas++) {
        int chute;
        cout << "Tentativa " << tentativas << endl;
        cout << "Qual é o seu chute?" << endl;
        cin >> chute;

        double pontos_perdidos = abs((chute - NUMERO_SECRETO) / 2.0);
        pontos = pontos = pontos_perdidos;

        cout << "O valor do seu chute é: " << chute << endl;
        
        bool acertou = chute == NUMERO_SECRETO;
        bool maior = chute > NUMERO_SECRETO;

        if (acertou) {
            cout << "Parabéns! Você acertou o número secreto!" << endl;
            nao_acertou = false;
            break;
        } else if (maior) {
            cout << "Você errou! O número secreto é menor!" << endl;
        } else {
            cout << "Você errou! O número secreto é maior!" << endl;
        }
    }

    cout << "Fim do jogo." << endl;

    if (nao_acertou) {
        coit << "Você perdeu! Tente novamente." << endl;
    } else {
        cout << "Você acertou em " << tentativas << "tentativas." << endl;
        cout.precision(2);
        cout << fixed;
        cout << "Sua pontuação foi de " << pontos << "pontos." << endl;
    }

}
