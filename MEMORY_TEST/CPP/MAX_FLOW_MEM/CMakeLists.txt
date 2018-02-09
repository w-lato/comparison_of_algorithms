cmake_minimum_required(VERSION 3.6)
project(MAX_FLOW_MEM)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")

set(SOURCE_FILES main.cpp Algorithm.h Algorithm.cpp FordFulkersonMaxFlow.h FordFulkersonMaxFlow.cpp MaxFlow.h)
add_executable(MAX_FLOW_MEM ${SOURCE_FILES})