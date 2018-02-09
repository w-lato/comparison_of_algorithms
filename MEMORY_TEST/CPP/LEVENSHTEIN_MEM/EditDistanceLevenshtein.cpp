//
// Created by vm on 04.11.17.
//

#include <sstream>
#include <cstring>
#include <iomanip>
#include "EditDistanceLevenshtein.h"
#include "Levenshtein.h"

EditDistanceLevenshtein::EditDistanceLevenshtein(const std::string &fileName, int iterations) : Algorithm(fileName,
                                                                                                          iterations) {}
char* getFileContent(std::string path) {
    std::cout << path;

    std::ifstream in_file(path);
    if (!in_file) {
        std::cerr << "Could not open input file\n";
        return "";
    }
    std::stringstream buffer;
    buffer << in_file.rdbuf();

    //std::cout << buffer.str();
    std::string str  = buffer.str();
    //std::cout << str;
    char* s = new char[str.length() + 1];
    strcpy(s, str.c_str());
    //std::cout << s;
    return s;
}


string getFileString(std::string path) {
    std::cout << path;

    std::ifstream in_file(path);
    if (!in_file) {
        std::cerr << "Could not open input file\n";
        return "";
    }
    std::stringstream buffer;
    buffer << in_file.rdbuf();

    //std::cout << buffer.str();
    return buffer.str();
}

void EditDistanceLevenshtein::prepareTestData() {
    A = getFileContent(pathA);
    B = getFileContent(pathB);
}

EditDistanceLevenshtein::EditDistanceLevenshtein(const std::string &fileName, int iterations, const std::string &pathA,
                                                 const std::string &pathB) : Algorithm(fileName, iterations),
                                                                             pathA(pathA), pathB(pathB) {}

void EditDistanceLevenshtein::startTimeTest() {
    prepareTestData();

std::string a1 = getFileString(pathA);
std::string b1 = getFileString(pathB);

    for (int j = 0; j < iterations; ++j) {
        auto start = std::chrono::high_resolution_clock::now();
//        unsigned int d = distance(A,B);
        unsigned int d = distance(a1,b1);
        diff = std::chrono::high_resolution_clock::now() - start;
//        fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;
        std::cout << j << " " << d << std::endl;
    }

//    fs.close();
    delete [] A;
    delete [] B;

}
