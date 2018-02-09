//
// Created by vm on 04.11.17.
//

#include <sstream>
#include <cstring>
#include <iomanip>
#include "EditDistanceLevenshtein.h"
#include "../../algorithms/Levenshtein.h"

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
//
//    std::cout << A << std::endl;
//    std::cout << B << std::endl;

std::string a1 = getFileString(pathA);
std::string b1 = getFileString(pathB);
    std::cout << std::endl;
    std::cout << std::endl;
    std::cout << a1.length() << std::endl;
    std::cout << b1.length() << std::endl;
//    for (int i = 0; i < b1.length(); ++i) {
//        std::cout << b1[i] << "|";
//        if(i % 100 == 0) std::cout << std::endl;
//    }

    std::fstream fs = prepareFileWriter();
    for (int j = 0; j < iterations; ++j) {
        auto start = std::chrono::high_resolution_clock::now();
//        unsigned int d = distance(A,B);
        unsigned int d = distance(a1,b1);
        diff = std::chrono::high_resolution_clock::now() - start;
        fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;
        std::cout << j << " " << d << std::endl;
    }

    fs.close();
    delete [] A;
    delete [] B;

}
