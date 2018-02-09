//
// Created by vm on 04.11.17.
//

#ifndef CPP_PART_EDITDISTANCELEVENSHTEIN_H
#define CPP_PART_EDITDISTANCELEVENSHTEIN_H


#include "../../Algorithm.h"

class EditDistanceLevenshtein : public Algorithm {
    std::string pathA;
    std::string pathB;
public:
    char* A;
    char* B;

    EditDistanceLevenshtein(const std::string &fileName, int iterations);

    EditDistanceLevenshtein(const std::string &fileName, int iterations, const std::string &pathA,
                            const std::string &pathB);

    void prepareTestData() override;

    void startTimeTest() override;
};


#endif //CPP_PART_EDITDISTANCELEVENSHTEIN_H
