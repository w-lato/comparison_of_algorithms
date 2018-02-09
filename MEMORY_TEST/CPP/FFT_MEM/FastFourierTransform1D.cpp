//
// Created by vm on 03.11.17.
//

#include <iomanip>
#include "FastFourierTransform1D.h"
#include "NumericFFT.h"

FastFourierTransform1D::FastFourierTransform1D(const std::string &fileName, int iterations) : Algorithm(fileName,
                                                                                                        iterations) {}

void FastFourierTransform1D::loadOrigData(std::vector<double> src,double dst[]) {
    std::copy(src.begin(), src.end(), dst);
}

void FastFourierTransform1D::prepareTestData() {
    int limit = (int)pow(2.0,22.0);
    std::ifstream reader;
    reader.open(fftDataPAth);
    int ctr = 0;
    char line[100];
    if(reader.is_open()) {
        while(!reader.eof() && ctr < limit) {
            reader >> line;
            //std::cout << std::stoi(line) << std::endl;
            origData.push_back( std::stod(line) ); // Re
            origData.push_back( 0.0 ); // Im
            ctr++;
        }
    }
    reader.close();
}

void FastFourierTransform1D::startTimeTest() {
    prepareTestData();
    //std::fstream fs = prepareFileWriter();
    double* arr = new double[origData.size()];
    std::cout << "\r\n Size: " << origData.size() << std::endl;
    for (int j = 0; j < iterations; ++j) {
        loadOrigData(origData, arr);
//        for (int i = 0; i < origData.size(); ++i) {
//            std::cout << arr[i] << " ";
//            if(i % 50 == 0) std::cout << std::endl;
//        }
        //auto start = std::chrono::high_resolution_clock::now();
        four1(arr, origData.size() / 2);
       // diff = std::chrono::high_resolution_clock::now() - start;
        //fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;


//        std::cout << "\r\n\r\n\r\n" << std::endl;
//        for (int i = 0; i < origData.size(); ++i) {
//            std::cout << arr[i] << " ";
//            if(i % 50 == 0) std::cout << std::endl;
//        }
//            fs << std::setprecision(10) << std::fixed << diff.count() << std::endl;
        std::cout << j << std::endl;
    }

   // fs.close();
    origData.shrink_to_fit();
    delete [] arr;

}
