#include "headers/nao_acertou.hpp"

using namespace std;

bool nao_acertou(string &palavra_secreta, map<char, bool> &chutou) {
    for (char letra : palavra_secreta) {
        if (!chutou[letra]) {
            return true;
        }
    }
    return false;
}
