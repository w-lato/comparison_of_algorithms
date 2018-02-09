cmake_minimum_required(VERSION 3.6)
project(MERGE_MEM)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")
set(SOURCE_FILES main.cpp Algorithm.h Algorithm.cpp MergeSort.h RegularMergeSort.cpp RegularMergeSort.h SortDataType.h SortingAlgorithm.cpp SortingAlgorithm.h)
add_executable(MERGE_MEM ${SOURCE_FILES})