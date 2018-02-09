//
// Created by vm on 04.11.17.
//

#ifndef CPP_PART_HASHBLOOMFILTER_H
#define CPP_PART_HASHBLOOMFILTER_H


#include "Algorithm.h"
#include "BloomFilter.h"

class HashBloomFilter : public Algorithm {
    std::string urlFilePAth;
    std::vector<std::string> str_list;
    bloom_filter bf;

public:
    HashBloomFilter(const std::string &fileName, int iterations, const std::string &urlFilePAth);

    void prepareTestData() override;

    void startTimeTest() override;
};


#endif //CPP_PART_HASHBLOOMFILTER_H
