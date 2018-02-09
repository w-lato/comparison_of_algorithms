#include <iostream>
#include "CormenQuickSort.h"

int main() {
    std::string dataPath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/QUICK_SORT/";
    CormenQuickSort cqs = CormenQuickSort("QuickSort", 1, dataPath);
    cqs.startTimeTest();
    return 0;
}