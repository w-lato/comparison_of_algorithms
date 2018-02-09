//#include <iostream>
#include "MatrixMultiplication.h"

int main() {
    //std::cout << "Hello, World!" << std::endl;
//    for ( int i = 0; i < 7 ; ++i )
//    {
//        alloca( 1048576 );
//    }
    std::string matrixFilePath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/MATRIX/";
    MatrixMultiplication mm = MatrixMultiplication("MatrixMul", 1, matrixFilePath);
    mm.startTimeTest();
    return 0;
}