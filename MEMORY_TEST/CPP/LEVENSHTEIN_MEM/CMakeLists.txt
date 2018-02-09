cmake_minimum_required(VERSION 3.6)
project(LEVENSHTEIN_MEM)

set(CMAKE_CXX_STANDARD 11)
#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")
set(SOURCE_FILES main.cpp Levenshtein.h EditDistanceLevenshtein.cpp EditDistanceLevenshtein.h Algorithm.cpp Algorithm.h)
add_executable(LEVENSHTEIN_MEM ${SOURCE_FILES})