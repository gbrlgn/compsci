#include "headers/nao_acertou.hpp"

using namespace std;

bool nao_acertou(string &palavra_secreta, const map<char, bool> &chutou) {
    for (char letra : palavra_secreta) {
        if (chutou.find(letra) == chutout.end() || !chutou.at(letra)) {
            return true;
        }
    }
    return false;
}
