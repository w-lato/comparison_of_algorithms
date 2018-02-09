//
// Created by vm on 03.11.17.
//

#include <iomanip>
#include "MatrixMultiplication.h"

using namespace Eigen;

MatrixMultiplication::MatrixMultiplication(const std::string &fileName, int iterations) : Algorithm(fileName,
                                                                                                    iterations) {}

MatrixMultiplication::MatrixMultiplication(const std::string &fileName, int iterations, const std::string &dataFilePath)
        : Algorithm(fileName, iterations), dataFilePath(dataFilePath) {}

void MatrixMultiplication::prepareTestData() {
    for (int i = 1; i < 11; ++i) {
        A.push_back(readMatrixFromFile("A"+std::to_string(i), 400));
        B.push_back(readMatrixFromFile("B"+std::to_string(i), 400));
    }


//    readMatrixesFromFile("set_A.txt");
//    readMatrixesFromFile("set_B.txt");
}
//
void MatrixMultiplication::readMatrixesFromFile(std::string setName) {

    int a = 500;
    int b = 600;
    int c = 700;
    int d = 800;
    int e = 900;
    int f = 1000;

    MatrixXd AA(a,a);
    MatrixXd BB(b,b);
    MatrixXd C(c,c);
    MatrixXd D(d,d);
    MatrixXd E(e,e);
    MatrixXd F(f,f);
//    double **m10 = new double*[a];
//    double **m30 = new double*[b];
//    double **m50 = new double*[c];
//    double **m100 = new double*[d];
//    double **m200 = new double*[e];
//    double **m500 = new double*[f];
//
//    for (int i = 0; i < f; ++i) {
//        if(i < a) m10[i] = new double[a];
//        if(i < b) m30[i] = new double[b];
//        if(i < c) m50[i] = new double[c];
//        if(i < d) m100[i] = new double[d];
//        if(i < e) m200[i] = new double[e];
//        if(i < f) m500[i] = new double[f];
//    }

    std::ifstream reader;
    std::cout << dataFilePath << std::endl;
    reader.open(dataFilePath + setName);
    if (!reader.is_open()) {
        std::cerr << "Could not open input file\n";
        return;
    }

    int row = 0; // how many rows of matrix has been processed
    int currentLength = 500; // which size of matrix are beeing read
    for( std::string line; getline(reader, line);)
    {
        if(row == currentLength) {
            row = 0;
            if(currentLength == a) currentLength = b;
            if(currentLength == b) currentLength = c;
            if(currentLength == c) currentLength = d;
            if(currentLength == d) currentLength = e;
            if(currentLength == e) currentLength = f;
        }
//        if(currentLength == a && row < 1)
//            std::cout << line << std::endl;

        std::string token;
        std::istringstream ss(line);
        int col = 0;
        while(std::getline(ss, token,',')) {
//            if(currentLength == a && row < 1)
//                std::cout <<  std::stod(token) <<std::endl;
            if(currentLength == a) AA(row, col) = std::stod(token);
            if(currentLength == b) BB(row, col) = std::stod(token);
            if(currentLength == c) C(row, col) = std::stod(token);
            if(currentLength == d) D(row, col) = std::stod(token);
            if(currentLength == e) E(row, col) = std::stod(token);
            if(currentLength == f) F(row, col) = std::stod(token);
            col++;
        }
        row++;
    }
//    while(!reader.eof()) {
//        if(row == currentLength) {
//            row = 0;
//            if(currentLength == a) currentLength = b;
//            if(currentLength == b) currentLength = c;
//            if(currentLength == c) currentLength = d;
//            if(currentLength == d) currentLength = e;
//            if(currentLength == e) currentLength = f;
//        }
//
//
//        reader >> line;
//        std::string s;
//        strDoubleVals = std::strtok(s,",");
//        // load line of doubles into matrix
//        int col = 0;
//        while(strDoubleVals != NULL) {
//            if(currentLength == a) A(row, col) = std::stod(strDoubleVals);
//            if(currentLength == b) B(row, col) = std::stod(strDoubleVals);
//            if(currentLength == c) C(row, col) = std::stod(strDoubleVals);
//            if(currentLength == d) D(row, col) = std::stod(strDoubleVals);
//            if(currentLength == e) E(row, col) = std::stod(strDoubleVals);
//            if(currentLength == f) F(row, col) = std::stod(strDoubleVals);
//            col++;
//            strDoubleVals = std::strtok(line,","); // next double
//        }
//        row++;
//    }
    reader.close();
    if(setName == "set_A.txt") {
        A.push_back(AA);
        A.push_back(BB);
        A.push_back(C);
        A.push_back(D);
        A.push_back(E);
        A.push_back(F);
    } else {
        B.push_back(AA);
        B.push_back(BB);
        B.push_back(C);
        B.push_back(D);
        B.push_back(E);
        B.push_back(F);
    }

//    for (int i = 0; i < f; ++i) {
//        if(i < a) delete[] m10[i];
//        if(i < b) delete[] m30[i];
//        if(i < c) delete[] m50[i];
//        if(i < d) delete[] m100[i];
//        if(i < e) delete[] m200[i];
//        if(i < f) delete[] m500[i];
//    }
//
//    delete[] m10;
//    delete[] m30;
//    delete[] m50;
//    delete[] m100;
//    delete[] m200;
//    delete[] m500;

}

MatrixXd MatrixMultiplication::readMatrixFromFile(std::string name, int size) {
    std::ifstream reader;
    std::cout << dataFilePath << std::endl;
    reader.open(dataFilePath + name);
    if (!reader.is_open()) {
        std::cerr << "Could not open input file\n";
        //return NULL;
    }

    MatrixXd X(size,size);
    int row = 0;
    for( std::string line; getline(reader, line);)
    {
        std::string token;
        std::istringstream ss(line);
        int col = 0;
        while(std::getline(ss, token,',')) {
            X(row, col) = std::stod(token);
            col++;
        }
        row++;
    }
    reader.close();
    return X;
}

void MatrixMultiplication::startTimeTest() {
    prepareTestData();
    MatrixXd C(400,400);
    //std::fstream fs = prepareFileWriter();
    for (int j = 0; j < iterations; ++j) {

        //auto start = std::chrono::high_resolution_clock::now();
        for (int i = 0; i < A.size(); ++i) {
            C = A[i] * B[i];
            //std::cout << C << std::endl;
        }

        //diff = std::chrono::high_resolution_clock::now() - start;
        //fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;
        //std::cout << j << std::endl;
    }
    //std::cout << A[9];

    //fs.close();
    A.shrink_to_fit();
    B.shrink_to_fit();
   // std::cout << matrixes[0] << std::endl;
}
