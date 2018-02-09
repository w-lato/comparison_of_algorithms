//
// Created by vm on 03.11.17.
//

#include <sstream>
#include <iomanip>
#include <vector>
#include "PatternMatchingRabinKarp.h"
#include "../../algorithms/RabinKarp.h"

PatternMatchingRabinKarp::PatternMatchingRabinKarp(const std::string &fileName, int iterations, const std::string textFilePath) : Algorithm(fileName,
                                                                                                            iterations),textFilePath(textFilePath) {}

void PatternMatchingRabinKarp::prepareTestData() {
    std::cout << textFilePath;

    std::ifstream in_file(textFilePath);
    if (!in_file) {
        std::cerr << "Could not open input file\n";
        return;
    }
    std::stringstream buffer;
    buffer << in_file.rdbuf();

    //std::cout << buffer.str();
    std::string str  = buffer.str();

    text = new char[str.length() + 1];
    strcpy(text, str.c_str());
}


void PatternMatchingRabinKarp::startTimeTest() {
    prepareTestData();
    std::fstream fs = prepareFileWriter();
    char s1[] = "Zagłoba";
    char s2[] = "Kmicic";
    char s3[] = "Radziwiłł";
    char s4[] = "Czarnecki";
    char s5[] = "Kowalski";
    char s6[] = "Wrzeszczowicz";
    char s7[] = "Kazimierz";
    char s8[] = "Lubomirski";
    char s9[] = "Kordecki";
    char s10[] = "Sapieha";

    char s11[] = "Chmielnicki";
    char s12[] = "Wołodyjowski";
    char s13[] = "Oleńka";
    char s14[] = "Babinicz";
    char s15[] = "Kordecki";
    char s16[] = "Zamoyski";
    char s17[] = "Sakowicz";
    char s18[] = "Gustaw";
    char s19[] = "Radziejowski";
    char s20[] = "Miller";


    for (int j = 0; j < iterations; ++j) {

        auto start = std::chrono::high_resolution_clock::now();
        search( s1 ,text, 101);
        search( s2 ,text, 101);
        search( s3 ,text, 101);
        search( s4 ,text, 101);
        search( s5 ,text, 101);
        search( s6 ,text, 101);
        search( s7 ,text, 101);
        search( s8 ,text, 101);
        search( s9 ,text, 101);
        search( s10 ,text, 101);
        search( s11 ,text, 101);
        search( s12 ,text, 101);
        search( s13 ,text, 101);
        search( s14 ,text, 101);
        search( s15 ,text, 101);
        search( s16 ,text, 101);
        search( s17 ,text, 101);
        search( s18 ,text, 101);
        search( s19 ,text, 101);
        search( s20 ,text, 101);


        diff = std::chrono::high_resolution_clock::now() - start;
        fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;
        std::cout << j << std::endl;
    }

    fs.close();

    delete[] text;
}
