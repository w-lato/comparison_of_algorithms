//
// Created by vm on 03.11.17.
//

#ifndef CPP_PART_CORMENQUICKSORT_H
#define CPP_PART_CORMENQUICKSORT_H


#include <vector>
#include <fstream>
#include "SortingAlgorithm.h"

class CormenQuickSort : public SortingAlgorithm {
public:
    CormenQuickSort(const std::string &fileName, int iterations, const std::string &sortDataPath);
    void prepareTestData();
    void loadSortData(std::vector<int> src, int dest[]);
    void performTest(std::fstream fs, int arr[],std::vector<int> vec);
    void startTimeTest();
};


#endif //CPP_PART_CORMENQUICKSORT_H
