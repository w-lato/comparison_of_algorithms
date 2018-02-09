//
// Created by vm on 03.11.17.
//

#include "ShortestPathDijkstra.h"

ShortestPathDijkstra::ShortestPathDijkstra(const std::string &fileName, int iterations) : Algorithm(fileName,
                                                                                                    iterations), g(Graph(v)) {}

void ShortestPathDijkstra::prepareTestData() {
        //Kraków
    g.addEdge(0,1,168);
    g.addEdge(0,5,116);//kielce
    g.addEdge(0,2,81); //katowice

    // Rzeszów
    g.addEdge(1,0,168); //Krkaów
    g.addEdge(1,5,157); // Kielce
    g.addEdge(1,6,175); // Lublin

    // Katowice
    g.addEdge(2,0,81); // Kraków
    g.addEdge(2,4, 75); // Czestochowa
    g.addEdge(2,3, 199); // Wrcoław

    // Wrocław
    g.addEdge(3,2,199); // Katowice
    g.addEdge(3,4,208); // Czestochowa
    g.addEdge(3,9,222); // łódz
    g.addEdge(3,8,186); // Poznań
    g.addEdge(3,7,210); // Zielona Góra

    //Czestochowa
    g.addEdge(4,2,75); // Katowice
    g.addEdge(4,3,208); // Wrocław
    g.addEdge(4,5,128); // Kielce
    g.addEdge(4,9,126); // Lodź

    // Kielce
    g.addEdge(5,4,128); // Częstochowa
    g.addEdge(5,0,116); // Kraków
    g.addEdge(5,1,157); // Rzeszów
    g.addEdge(5,6,184); // Lublin
    g.addEdge(5,10,180); // Warszawa
    g.addEdge(5,9,159); // Lódź

    // Lublin
    g.addEdge(6,1,175); // Rzeszów
    g.addEdge(6,5,184); // Kielce
    g.addEdge(6,10,170); // Warszawa
    g.addEdge(6,11,247); // Białystok

    //Zielona Góra
    g.addEdge(7,3,210); // Wrocław
    g.addEdge(7,8,151); // Poznań
    g.addEdge(7,13,112); // GorzówWlkp

    // Pożnań
    g.addEdge(8,7,151); // Zielona Góra
    g.addEdge(8,3,186); // Wrocław
    g.addEdge(8,9,205); // Lóddz
    g.addEdge(8,13,162); // Gorzów Wlkp
    g.addEdge(8,12,167); // Toruń

    // Lódź
    g.addEdge(9,3,222); // Wrocław
    g.addEdge(9,4,126); // Częstochowa
    g.addEdge(9,5,159); // Kielca
    g.addEdge(9,10,136); // Warszawa
    g.addEdge(9,15,297); // Olsztyn
    g.addEdge(9,12,181); // Toruń

    // Warszawa
    g.addEdge(10,6,170); // Lublin
    g.addEdge(10,5,180); // Kielce
    g.addEdge(10,9,136); // Lodz
    g.addEdge(10,11,203); // Bialystok
    g.addEdge(10,16,295); // Suwałki
    g.addEdge(10,15,216); // Olsztyn

    // Białystok
    g.addEdge(11,6,247); // Lublin
    g.addEdge(11,10,203); // Warszawa
    g.addEdge(11,15,226); // Olsztyn
    g.addEdge(11,16,129); // Suwałki

    // Toruń
    g.addEdge(12,9,181); // łódz
    g.addEdge(12,8,167); //  Poznań
    g.addEdge(12,15,176); // Olsztyn
    g.addEdge(12,19,170); // Gdansk
    g.addEdge(12,14,143); // Pila

    // Gorzów Wlkp
    g.addEdge(13,7,112); // Zielona Góra
    g.addEdge(13,8,162); // Poznan
    g.addEdge(13,17,111); // Szczecin
    g.addEdge(13,14,121); // Pila

    // Piła
    g.addEdge(14,12,143); // Toruń
    g.addEdge(14,13,121); // Gorzów Wlkp
    g.addEdge(14,19,223); // Gdańsk
    g.addEdge(14,18,140); // Koszalin

    // Olsztyn
    g.addEdge(15,16,196); // Suwałki
    g.addEdge(15,11,226); // Białystok
    g.addEdge(15,10,216); // Warszawa
    g.addEdge(15,9,297); // łodz
    g.addEdge(15,12,176); // Torun
    g.addEdge(15,19,168); // Gdansk

    // Suwałki
    g.addEdge(16,11,129); // Białystok
    g.addEdge(16,10,295); // Warszawa
    g.addEdge(16,15,196); // Olsztyn

    // Szczecin
    g.addEdge(17,13,111); // Gorzów Wlkp
    g.addEdge(17,18,161); // Koszalin

    // Koszalin
    g.addEdge(18,17,161); // Szczecin
    g.addEdge(18,14,140); // Pila
    g.addEdge(18,19,193); // Gdansk

    // Gdansk
    g.addEdge(19,15,168); // Olsztyn
    g.addEdge(19,12,170); // Torun
    g.addEdge(19,14,223); // Pila
    g.addEdge(19,18,193); // Koszalin
}
void ShortestPathDijkstra::clearGraph(){
    for (int i = 0; i < 0; ++i) {

    }
}

void ShortestPathDijkstra::startTimeTest() {
    prepareTestData();
    std::fstream fs = prepareFileWriter();
    for (int j = 0; j < iterations; ++j) {
        auto start = std::chrono::high_resolution_clock::now();
        g.shortestPath(0);
        g.shortestPath(1);
        g.shortestPath(2);
        g.shortestPath(3);
        g.shortestPath(4);
        g.shortestPath(5);
        g.shortestPath(6);
        g.shortestPath(7);
        g.shortestPath(8);
        g.shortestPath(9);
        g.shortestPath(10);
        g.shortestPath(11);
        g.shortestPath(12);
        g.shortestPath(13);
        g.shortestPath(14);
        g.shortestPath(15);
        g.shortestPath(16);
        g.shortestPath(17);
        g.shortestPath(18);
        g.shortestPath(19);

        diff = std::chrono::high_resolution_clock::now() - start;
        fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;
        std::cout << j << std::endl;
    }
    fs.close();
}
