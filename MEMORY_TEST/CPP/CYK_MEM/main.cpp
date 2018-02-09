#include <iostream>
#include "GrammarCYK.h"

int main() {

    std::string grammarPath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/grammar_cpp.txt";
    GrammarCYK cyk = GrammarCYK("CYK_", 1, grammarPath);
    cyk.startTimeTest();

    return 0;
}