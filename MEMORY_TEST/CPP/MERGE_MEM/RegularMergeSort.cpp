//
// Created by vm on 03.11.17.
//


#include "RegularMergeSort.h"
#include "MergeSort.h"

RegularMergeSort::RegularMergeSort(const std::string &fileName, int iterations, const std::string &sortDataPath)
        : SortingAlgorithm(fileName, iterations, sortDataPath) {}

//void RegularMergeSort::prepareTestData() {
//    readDataFrom(RANDOM);
//    readDataFrom(SORTED_ASC);
//    readDataFrom(SORTED_DESC);
//    readDataFrom(SAME);
//}

void RegularMergeSort::loadSortData(std::vector<int> src, int dest[]) {
    for (int i = 0; i < src.size(); ++i) {
        dest[i] = src[i];
    }
    //std::copy(src.begin(), src.end(), dest);
}


void RegularMergeSort::startTimeTest() {

//    readDataFrom(RANDOM);
//    int *arr = new int[random.size()];
//    for (int j = 0; j < iterations; ++j) {
//        loadSortData(random, arr);
//        auto start = std::chrono::high_resolution_clock::now();
//        mergeSort(arr, 0, random.size() - 1);
//        diff = std::chrono::high_resolution_clock::now() - start;
//            std::cout << j << std::endl;
//    }
//    random.shrink_to_fit();

//    readDataFrom(SORTED_ASC);
//    int *arr = new int[sortedAsc.size()];
//    for (int j = 0; j < iterations; ++j) {
//        loadSortData(sortedAsc, arr);
//        //auto start = std::chrono::high_resolution_clock::now();
//        mergeSort(arr, 0, sortedAsc.size() - 1);
//        //diff = std::chrono::high_resolution_clock::now() - start;
//        std::cout << j << std::endl;
//    }
//    sortedAsc.shrink_to_fit();
//
    readDataFrom(SORTED_DESC);
    int *arr = new int[sortedDesc.size()];
//    for (int j = 0; j < iterations; ++j) {
//        loadSortData(sortedDesc, arr);
//        auto start = std::chrono::high_resolution_clock::now();
//        mergeSort(arr, 0, sortedDesc.size() - 1);
//        diff = std::chrono::high_resolution_clock::now() - start;
//       std::cout << j << std::endl;
//    }
//    sortedDesc.shrink_to_fit();
//
//    readDataFrom(SAME);
//    int *arr = new int[same.size()];
//    for (int j = 0; j < iterations; ++j) {
//        loadSortData(same, arr);
//        auto start = std::chrono::high_resolution_clock::now();
//        mergeSort(arr, 0, same.size() - 1);
//        diff = std::chrono::high_resolution_clock::now() - start;
//         std::cout << j << std::endl;
//    }
//    same.shrink_to_fit();

//    delete[] arr;
}