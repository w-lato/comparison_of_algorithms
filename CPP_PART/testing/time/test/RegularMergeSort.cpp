//
// Created by vm on 03.11.17.
//


#include "RegularMergeSort.h"
#include "../../algorithms/MergeSort.h"

RegularMergeSort::RegularMergeSort(const std::string &fileName, int iterations, const std::string &sortDataPath)
        : SortingAlgorithm(fileName, iterations, sortDataPath) {}

void RegularMergeSort::prepareTestData() {
    readDataFrom(RANDOM);
    readDataFrom(SORTED_ASC);
    readDataFrom(SORTED_DESC);
    readDataFrom(SAME);
}

void RegularMergeSort::loadSortData(std::vector<int> src, int dest[]) {
    for (int i = 0; i < src.size(); ++i) {
        dest[i] = src[i];
    }
    //std::copy(src.begin(), src.end(), dest);
}


void RegularMergeSort::startTimeTest() {
    //prepareTestData();
    std::cout << "\r\nSize: " << random.size() << std::endl;



    std::cout << "\r\nbefore loading data: " << std::endl;


//    readDataFrom(RANDOM);
//    int *arr = new int[random.size()];
//    std::fstream fs = prepareFileWriter(RANDOM);
//    for (int j = 0; j < iterations; ++j) {
//        loadSortData(random, arr);
//        auto start = std::chrono::high_resolution_clock::now();
//        mergeSort(arr, 0, random.size() - 1);
//        diff = std::chrono::high_resolution_clock::now() - start;
//        fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;
//        fs.flush();
//        std::cout << j << std::endl;
//    }
//    fs.close();
//    random.shrink_to_fit();

//    std::cout << "SORTED ASC" << std::endl;
//    int *arr = new int[random.size()];
//    readDataFrom(SORTED_ASC);
//    std::fstream fs = prepareFileWriter(SORTED_ASC);
//    for (int j = 0; j < iterations; ++j) {
//        loadSortData(sortedAsc, arr);
//        auto start = std::chrono::high_resolution_clock::now();
//        mergeSort(arr, 0, sortedAsc.size() - 1);
//        diff = std::chrono::high_resolution_clock::now() - start;
//        fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;
//        fs.flush();
//        std::cout << j << std::endl;
//    }
//    fs.close();
//    sortedAsc.shrink_to_fit();
//
//    std::cout << "SORTED desc" << std::endl;
//    readDataFrom(SORTED_DESC);
//    fs = prepareFileWriter(SORTED_DESC);
//    for (int j = 0; j < iterations; ++j) {
//        loadSortData(sortedDesc, arr);
//        auto start = std::chrono::high_resolution_clock::now();
//        mergeSort(arr, 0, sortedDesc.size() - 1);
//        diff = std::chrono::high_resolution_clock::now() - start;
//        fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;
//        fs.flush();
//        std::cout << j << std::endl;
//    }
//    fs.close();
//    sortedDesc.shrink_to_fit();
//
//

    std::cout << "SORTED same" << std::endl;
    readDataFrom(SAME);
    int *arr = new int[same.size()];
    std::fstream fs = prepareFileWriter(SAME);
    for (int j = 0; j < iterations; ++j) {
        loadSortData(same, arr);
        auto start = std::chrono::high_resolution_clock::now();
        mergeSort(arr, 0, same.size() - 1);
        diff = std::chrono::high_resolution_clock::now() - start;
        fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;
        fs.flush();
        std::cout << j << std::endl;
    }
    fs.close();
    same.shrink_to_fit();

    delete[] arr;
}