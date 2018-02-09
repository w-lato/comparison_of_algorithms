//
// Created by vm on 03.11.17.
//

#ifndef CPP_PART_PATTERNMATCHINGRABINKARP_H
#define CPP_PART_PATTERNMATCHINGRABINKARP_H


#include "../../Algorithm.h"

class PatternMatchingRabinKarp : public Algorithm{
public:
    char* text;
    std::string textFilePath;
    PatternMatchingRabinKarp(const std::string &fileName, int iterations, const std::string textFilePath);

    void prepareTestData() override;

    void startTimeTest() override;
};


#endif //CPP_PART_PATTERNMATCHINGRABINKARP_H
