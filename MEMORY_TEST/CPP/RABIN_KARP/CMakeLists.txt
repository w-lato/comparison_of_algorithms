cmake_minimum_required(VERSION 3.6)
project(RABIN_KARP)

set(CMAKE_CXX_STANDARD 11)
#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")
set(SOURCE_FILES main.cpp Algorithm.cpp Algorithm.h RabinKarp.h PatternMatchingRabinKarp.cpp PatternMatchingRabinKarp.h)
add_executable(RABIN_KARP ${SOURCE_FILES})