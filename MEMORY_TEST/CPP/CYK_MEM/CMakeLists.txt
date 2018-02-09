cmake_minimum_required(VERSION 3.6)
project(CYK_MEM)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")
set(SOURCE_FILES main.cpp Algorithm.h Algorithm.cpp cyk/CYK.h cyk/GRAMMAR.h GrammarCYK.h GrammarCYK.cpp)
add_executable(CYK_MEM ${SOURCE_FILES})