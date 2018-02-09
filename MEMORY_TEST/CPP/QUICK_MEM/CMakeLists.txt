cmake_minimum_required(VERSION 3.6)
project(QUICK_MEM)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")
set(SOURCE_FILES main.cpp Algorithm.cpp Algorithm.h CormenQuickSort.cpp CormenQuickSort.h QuickSort.h SortDataType.h SortingAlgorithm.cpp SortingAlgorithm.h)
add_executable(QUICK_MEM ${SOURCE_FILES})