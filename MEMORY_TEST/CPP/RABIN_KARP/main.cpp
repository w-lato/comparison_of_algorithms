#include <iostream>
#include "PatternMatchingRabinKarp.h"

int main() {
    std::string trylogia = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/henryk_sienkiewicz_trylogia.txt";
    PatternMatchingRabinKarp pmrk = PatternMatchingRabinKarp("pattern", 1, trylogia);
    pmrk.startTimeTest();
    return 0;
}