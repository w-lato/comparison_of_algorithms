//
// Created by vm on 02.11.17.
//

#include <vector>
#include <algorithm>
#include "SortingAlgorithm.h"


std::fstream SortingAlgorithm :: prepareFileWriter(SortDataType type) {
    std::string dataType;
    switch(type) {
        case SAME : dataType = "SAME"; break;
        case RANDOM : dataType = "RANDOM"; break;
        case SORTED_ASC : dataType = "SORTED_ASC"; break;
        default: dataType = "SORTED_DESC"; break;
    }
    std::fstream fs;
    fs.open(filePath + fileName + dataType + getTimeAndDate(), std::fstream::out);
    //std::cout << fs.is_open() << std::endl;
    return fs;
}

void SortingAlgorithm :: readDataFrom(SortDataType  type ) {
    std::string filename;
    switch(type) {
        case SAME: filename = "same.txt"; break;
        case RANDOM: filename = "random.txt"; break;
        case SORTED_ASC: filename = "sortedAsc.txt"; break;
        default: filename = "sortedDesc.txt"; break;
    }
    std::ifstream reader;
    reader.open(sortDataPath + filename);
    std::vector<int> arr;// = std::vector<int>();
    char line[100];
    if(reader.is_open()) {
        while(!reader.eof()) {
            reader >> line;
            //std::cout << std::stoi(line) << std::endl;
            arr.push_back( std::stoi(line) ); // string to int conversion
        }
    }
    reader.close();
    switch(type) {
        case RANDOM:
            random.swap(arr);
            arr.shrink_to_fit();
            return;
        case SAME:
            same.swap(arr);
            arr.shrink_to_fit();
            return;
        case SORTED_ASC:
            sortedAsc.swap(arr);
            arr.shrink_to_fit();
            return;
        default: //sortedDesc
            sortedDesc.swap(arr);
            arr.shrink_to_fit();
            return;
    }
}


//    int vals[size];
//    std::copy(arr.begin(), arr.end(), vals);
//    switch (type) {
//        case RANDOM:
//            random = vals;
//            arr.shrink_to_fit();
//            return;
//        case SAME:
//            same = vals;
//            arr.shrink_to_fit();
//            return;
//        case SORTED_ASC:
//            sortedAsc = vals;
//            arr.shrink_to_fit();
//            return;
//        default: //sortedDesc
//            sortedDesc = vals;
//            arr.shrink_to_fit();
//            return;
//    }





