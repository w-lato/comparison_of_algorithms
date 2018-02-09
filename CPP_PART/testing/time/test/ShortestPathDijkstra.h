//
// Created by vm on 03.11.17.
//

#ifndef CPP_PART_SHORTESTPATHDIJKSTRA_H
#define CPP_PART_SHORTESTPATHDIJKSTRA_H


#include "../../Algorithm.h"
#include "../../algorithms/dijkstra/Graph.h"

class ShortestPathDijkstra : public Algorithm {
public:
    int v = 20; //num of verticles
    Graph g;

    ShortestPathDijkstra(const std::string &fileName, int iterations);

    void clearGraph();

    void prepareTestData() override;

    void startTimeTest() override;

};


#endif //CPP_PART_SHORTESTPATHDIJKSTRA_H
