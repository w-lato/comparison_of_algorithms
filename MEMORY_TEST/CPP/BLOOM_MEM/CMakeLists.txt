cmake_minimum_required(VERSION 3.6)
project(BLOOM_MEM)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")
set(SOURCE_FILES main.cpp Algorithm.h Algorithm.cpp BloomFilter.h HashBloomFilter.cpp HashBloomFilter.h)
add_executable(BLOOM_MEM ${SOURCE_FILES})