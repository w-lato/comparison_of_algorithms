//
// Created by vm on 03.11.17.
//

#ifndef CPP_PART_MATRIXMULTIPLICATION_H
#define CPP_PART_MATRIXMULTIPLICATION_H


#include "matrix/Eigen/Dense.h"
#include "Algorithm.h"


class MatrixMultiplication : public Algorithm {
public:
    std::vector<Eigen::MatrixXd> A;
    std::vector<Eigen::MatrixXd> B;
    std::string dataFilePath;

    MatrixMultiplication(const std::string &fileName, int iterations, const std::string &dataFilePath);
    MatrixMultiplication(const std::string &fileName, int iterations);

    void readMatrixesFromFile(std::string setName);
    Eigen::MatrixXd readMatrixFromFile(std::string name, int size);
    void prepareTestData() override;

    void startTimeTest() override;
};


#endif //CPP_PART_MATRIXMULTIPLICATION_H
