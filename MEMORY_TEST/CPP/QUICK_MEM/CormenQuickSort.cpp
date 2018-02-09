//
// Created by vm on 03.11.17.
//

#include <iomanip>
#include "CormenQuickSort.h"
#include "QuickSort.h"

void CormenQuickSort :: prepareTestData() {

//    readDataFrom(SORTED_ASC);
//    readDataFrom(SORTED_DESC);
//    readDataFrom(SAME);
}

void CormenQuickSort::loadSortData(std::vector<int> src, int dest[]) {
    std::copy(src.begin(), src.end(), dest);
}

void CormenQuickSort::performTest(std::fstream fs, int arr[],std::vector<int> vec) {
    for (int j = 0; j < iterations; ++j) {
        auto start = std::chrono::high_resolution_clock::now();
        loadSortData(vec, arr);
      diff = std::chrono::high_resolution_clock::now() - start;
        //std::cout << diff.count() << std::endl;
        quick_sort(arr, 0, random.size() - 1);
        //std::cout << diff.count() << std::endl;
        //fs << std::setprecision(10) << diff.count() << std::endl;
        fs << std::setprecision(10) << std::fixed << diff.count() << std::endl;

        for (int i = 0; i < random.size(); ++i) {
            std::cout <<  arr[i] << " ";
            if( i % 50 == 0 ) std::cout << std::endl;
        }
    }
    fs.close();
}

void CormenQuickSort :: startTimeTest() {
//    readDataFrom(RANDOM);
//    int *arr = new int[random.size()];
//    for (int j = 0; j < iterations; ++j) {
//        loadSortData(random, arr);
//        auto start = std::chrono::high_resolution_clock::now();
//        quick_sort(arr, 0, random.size() - 1);
//        diff = std::chrono::high_resolution_clock::now() - start;
//
//        std::cout << j << std::endl;
//    }
//    random.shrink_to_fit();

//    readDataFrom(SORTED_ASC);
//    int *arr = new int[sortedAsc.size()];
//    for (int j = 0; j < iterations; ++j) {
//        loadSortData(sortedAsc, arr);
//        auto start = std::chrono::high_resolution_clock::now();
//        quick_sort(arr, 0, sortedAsc.size() - 1);
//        diff = std::chrono::high_resolution_clock::now() - start;
//         std::cout << j << std::endl;
//    }
//    sortedAsc.shrink_to_fit();
//
//    readDataFrom(SORTED_DESC);
//    int *arr = new int[sortedDesc.size()];
//    for (int j = 0; j < iterations; ++j) {
//        loadSortData(sortedDesc, arr);
//        auto start = std::chrono::high_resolution_clock::now();
//        quick_sort(arr, 0, sortedDesc.size() - 1);
//        diff = std::chrono::high_resolution_clock::now() - start;
//          std::cout << j << std::endl;
//    }
//    sortedDesc.shrink_to_fit();
//
    readDataFrom(SAME);
    int *arr = new int[same.size()];
    for (int j = 0; j < iterations; ++j) {
        loadSortData(same, arr);
        auto start = std::chrono::high_resolution_clock::now();
        quick_sort(arr, 0, same.size() - 1);
        diff = std::chrono::high_resolution_clock::now() - start;
         std::cout << j << std::endl;
    }
    same.shrink_to_fit();

//    delete[] arr;
}

CormenQuickSort::CormenQuickSort(const std::string &fileName, int iterations, const std::string &sortDataPath)
        : SortingAlgorithm(fileName, iterations, sortDataPath) {}
