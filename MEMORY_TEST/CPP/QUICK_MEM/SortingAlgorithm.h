//
// Created by vm on 02.11.17.
//

#ifndef CPP_PART_SORTINGALGORITHM_H
#define CPP_PART_SORTINGALGORITHM_H

#include <vector>
#include "Algorithm.h"
#include "SortDataType.h"

class SortingAlgorithm : public Algorithm {
protected :
    int size;
    std::vector<int> random;
    std::vector<int> sortedAsc;
    std::vector<int> sortedDesc;
    std::vector<int> same;
    std::string sortDataPath;
public:
    SortingAlgorithm() {};
    SortingAlgorithm(const std::string &fileName, int iterations, const std::string &sortDataPath) :
            Algorithm(fileName,iterations), sortDataPath(sortDataPath) {}
    void readDataFrom(SortDataType  type );

    std::fstream prepareFileWriter(SortDataType type);
    ~SortingAlgorithm() {
        random.shrink_to_fit();
        sortedAsc.shrink_to_fit();
        sortedDesc.shrink_to_fit();
        same.shrink_to_fit();
    }
};

#endif //CPP_PART_SORTINGALGORITHM_H
