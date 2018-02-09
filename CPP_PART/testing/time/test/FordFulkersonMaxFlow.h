//
// Created by vm on 04.11.17.
//

#ifndef CPP_PART_FORDFULKERSONMAXFLOW_H
#define CPP_PART_FORDFULKERSONMAXFLOW_H


#include "../../Algorithm.h"

class FordFulkersonMaxFlow : public Algorithm {
    int graph[44][44];
public:
    FordFulkersonMaxFlow(const std::string &fileName, int iterations);

    void prepareTestData() override;

    void startTimeTest() override;
};


#endif //CPP_PART_FORDFULKERSONMAXFLOW_H
