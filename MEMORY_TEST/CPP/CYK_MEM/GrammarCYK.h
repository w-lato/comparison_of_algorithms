//
// Created by vm on 04.11.17.
//

#ifndef CPP_PART_GRAMMARCYK_H
#define CPP_PART_GRAMMARCYK_H


#include "Algorithm.h"

class GrammarCYK : public Algorithm{
std::string grammarPath;
std::string sentence[32 * 8];
public:
    GrammarCYK(const std::string &fileName, int iterations, const std::string &grammarPath);

    void prepareTestData() override;

    void startTimeTest() override;
};


#endif //CPP_PART_GRAMMARCYK_H
