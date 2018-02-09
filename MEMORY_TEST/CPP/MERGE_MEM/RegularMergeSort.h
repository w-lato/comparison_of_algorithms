//
// Created by vm on 03.11.17.
//

#ifndef CPP_PART_REGULARMERGESORT_H
#define CPP_PART_REGULARMERGESORT_H

#include <iomanip>
#include "SortingAlgorithm.h"

class RegularMergeSort : public SortingAlgorithm {
public:
    RegularMergeSort(const std::string &fileName, int iterations, const std::string &sortDataPath);
    //void prepareTestData();
    void loadSortData(std::vector<int> src, int dest[]);
    void startTimeTest();
};


#endif //CPP_PART_REGULARMERGESORT_H
