//
// Created by vm on 02.11.17.
//

#ifndef CPP_PART_ALGORITHM_H
#define CPP_PART_ALGORITHM_H

#include <iostream>
#include <chrono>
#include <fstream>

class Algorithm {
    //using namespace std::chrono;
public:
    //std::chrono::high_resolution_clock::time_point timeDiff;
    std::chrono::duration<double> diff;
    // to save output files
    int iterations;
    std::string filePath= "/home/vm/Desktop/ENGINEERS_REPO/TIME_RESULTS/CPP/";
protected:
    std::string fileName;
public:
    Algorithm();
    Algorithm(const std::string &fileName, int iterations) : fileName(fileName), iterations(iterations) {}
    std::string getTimeAndDate();
    std::fstream prepareFileWriter();
    virtual void prepareTestData() {};
    virtual void startTimeTest() {};

    ~Algorithm()
    {
        std::cout << "~Algorithm" << std::endl;
    }

};


#endif //CPP_PART_ALGORITHM_H
