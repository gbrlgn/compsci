#include <string>

using namespace std;

extern string palavra_secreta;

bool letra_existe(char chute) {
    for (char letra : palavra_secreta) {
        if (palavra_secreta[letra] == chute) {
            return true;
        }
    }
    return false;
}