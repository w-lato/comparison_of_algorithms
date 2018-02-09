#include <iostream>
#include "EditDistanceLevenshtein.h"

int main() {
    std::string pathA = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/EDIT_DIST/tysiaclecia_utf8.txt";
    std::string pathB = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/EDIT_DIST/poznanska_utf8.txt";
    EditDistanceLevenshtein edl = EditDistanceLevenshtein("Levenshtein_", 1, pathA, pathB);
    edl.startTimeTest();
    return 0;
}