cmake_minimum_required(VERSION 3.6)
project(MATRIX_MUL)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")
set(SOURCE_FILES main.cpp matrix/Eigen/Cholesky matrix/Eigen/Core matrix/Eigen/LU matrix/Eigen/QR matrix/Eigen/Core matrix/Eigen/SVD matrix/Eigen/Geometry matrix/Eigen/Eigenvalues matrix/Eigen/Dense.h Algorithm.cpp Algorithm.h MatrixMultiplication.cpp MatrixMultiplication.h)
add_executable(MATRIX_MUL ${SOURCE_FILES})