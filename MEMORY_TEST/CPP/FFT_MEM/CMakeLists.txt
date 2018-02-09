cmake_minimum_required(VERSION 3.6)
project(FFT_MEM)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")
set(SOURCE_FILES main.cpp NumericFFT.h Algorithm.cpp Algorithm.h FastFourierTransform1D.cpp FastFourierTransform1D.h)
add_executable(FFT_MEM ${SOURCE_FILES})