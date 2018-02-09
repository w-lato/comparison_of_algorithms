#include <iostream>
#include "HashBloomFilter.h"

int main() {
    std::string grammarPath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/urls.txt";
    HashBloomFilter hbf = HashBloomFilter("hash_", 1, grammarPath);
    hbf.startTimeTest();
    return 0;
}