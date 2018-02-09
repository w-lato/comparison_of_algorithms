#include <iostream>
#include "RegularMergeSort.h"

int main() {
    std::string dataPath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/MERGE_SORT/";
    RegularMergeSort rms = RegularMergeSort("MergeSort", 1, dataPath);
    rms.startTimeTest();
    return 0;
}