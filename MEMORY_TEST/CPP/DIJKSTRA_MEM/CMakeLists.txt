cmake_minimum_required(VERSION 3.6)
project(DIJKSTRA_MEM)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O3")
set(SOURCE_FILES main.cpp dijkstra/Graph.cpp dijkstra/Graph.h Algorithm.h Algorithm.cpp ShortestPathDijkstra.h ShortestPathDijkstra.cpp)
add_executable(DIJKSTRA_MEM ${SOURCE_FILES})