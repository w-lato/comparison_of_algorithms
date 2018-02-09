//
// Created by vm on 03.11.17.
//

#ifndef CPP_PART_FASTFOURIERTRANSFORM1D_H
#define CPP_PART_FASTFOURIERTRANSFORM1D_H


#include <vector>
#include "../../Algorithm.h"

class FastFourierTransform1D : public Algorithm{
public:
    std::string fftDataPAth = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/orig_winter.txt";
    std::vector<double> origData;
    FastFourierTransform1D(const std::string &fileName, int iterations);

    void prepareTestData() override;
    void startTimeTest() override;
    void loadOrigData(std::vector<double> src,double dst[]);
};


#endif //CPP_PART_FASTFOURIERTRANSFORM1D_H
