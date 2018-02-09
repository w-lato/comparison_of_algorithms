package main;

import main.dijkstra.Dijkstra;
import main.dijkstra.Graph;
import main.dijkstra.Node;


import java.io.PrintWriter;

public class ShortestPathDijkstra extends Algorithm {

    Graph graph;
    Node Krakow = new Node("Kraków");
    Node Rzeszów = new Node("Rzeszów");
    Node Katowice = new Node("Katowice");

    Node Wroclaw = new Node("Wrocław");
    Node Czestochowa = new Node("Czestochowa");
    Node Kielce = new Node("Kielce");
    Node Lublin = new Node("Lublin");

    Node ZielonaGora = new Node("Zielona Góra");
    Node Poznan = new Node("Poznań");
    Node Lodz = new Node("Lódź");
    Node Warszawa = new Node("Warszawa");

    Node Bialystok = new Node("Białystok");
    Node Torun = new Node("Toruń");
    Node GorzowWlkp = new Node("Gorzów Wielkopolski");
    Node Pila = new Node("Piła");

    Node Olsztyn = new Node("Olsztyn");
    Node Suwalki = new Node("Suwałki");
    Node Szczecin = new Node("Szczecin");
    Node Koszalin = new Node("Koszalin");
    Node Gdansk = new Node("Gdańsk");


    @Override
    public void prepareTestData() {
        graph = getClearGraph();
    }

    public Graph getClearGraph() {
        Graph g = new Graph();
//        Node Krakow = new Node("Kraków");
//        Node Rzeszów = new Node("Rzeszów");
//        Node Katowice = new Node("Katowice");
//
//        Node Wroclaw = new Node("Wrocław");
//        Node Czestochowa = new Node("Czestochowa");
//        Node Kielce = new Node("Kielce");
//        Node Lublin = new Node("Lublin");
//
//        Node ZielonaGora = new Node("Zielona Góra");
//        Node Poznan = new Node("Poznań");
//        Node Lodz = new Node("Lódź");
//        Node Warszawa = new Node("Warszawa");
//
//        Node Bialystok = new Node("Białystok");
//        Node Torun = new Node("Toruń");
//        Node GorzowWlkp = new Node("Gorzów Wielkopolski");
//        Node Pila = new Node("Piła");
//
//        Node Olsztyn = new Node("Olsztyn");
//        Node Suwalki = new Node("Suwałki");
//        Node Szczecin = new Node("Szczecin");
//        Node Koszalin = new Node("Koszalin");
//        Node Gdansk = new Node("Gdańsk");

        //Kraków
        Krakow.addDestination(Rzeszów,168);
        Krakow.addDestination(Kielce,116);
        Krakow.addDestination(Katowice,81);

        // Rzeszów
        Rzeszów.addDestination(Krakow,168);
        Rzeszów.addDestination(Kielce,157);
        Rzeszów.addDestination(Lublin,175);

        //Katowice
        Katowice.addDestination(Krakow,81);
        Katowice.addDestination(Czestochowa,75);
        Katowice.addDestination(Wroclaw,199);

        //Wrocław
        Wroclaw.addDestination(Katowice,199);
        Wroclaw.addDestination(Czestochowa,208);
        Wroclaw.addDestination(Lodz,222);
        Wroclaw.addDestination(Poznan,186);
        Wroclaw.addDestination(ZielonaGora,210);

        //Czestochowa
        Czestochowa.addDestination(Katowice,75);
        Czestochowa.addDestination(Wroclaw,208);
        Czestochowa.addDestination(Kielce,128);
        Czestochowa.addDestination(Lodz,126);

        //Kielce
        Kielce.addDestination(Czestochowa,128);
        Kielce.addDestination(Krakow,116);
        Kielce.addDestination(Rzeszów,157);
        Kielce.addDestination(Lublin,184);
        Kielce.addDestination(Warszawa,180);
        Kielce.addDestination(Lodz,159);

        //Lublin
        Lublin.addDestination(Rzeszów,175);
        Lublin.addDestination(Kielce,184);
        Lublin.addDestination(Warszawa,170);
        Lublin.addDestination(Bialystok,247);

        // Zielona Góra
        ZielonaGora.addDestination(Wroclaw, 210);
        ZielonaGora.addDestination(Poznan, 151);
        ZielonaGora.addDestination(GorzowWlkp, 112);

        //Poznan
        Poznan.addDestination(ZielonaGora,151);
        Poznan.addDestination(Wroclaw,186);
        Poznan.addDestination(Lodz,205);
        Poznan.addDestination(GorzowWlkp, 162);
        Poznan.addDestination(Torun, 167);

        //Lódź
        Lodz.addDestination(Wroclaw, 222);
        Lodz.addDestination(Czestochowa, 126);
        Lodz.addDestination(Kielce, 159);
        Lodz.addDestination(Warszawa, 136);
        Lodz.addDestination(Olsztyn, 297);
        Lodz.addDestination(Torun, 181);

        //Warszawa
        Warszawa.addDestination(Lublin,170);
        Warszawa.addDestination(Kielce,180);
        Warszawa.addDestination(Lodz,136);
        Warszawa.addDestination(Bialystok,203);
        Warszawa.addDestination(Suwalki,295);
        Warszawa.addDestination(Olsztyn,216);

        //Białystok
        Bialystok.addDestination(Lublin,247);
        Bialystok.addDestination(Warszawa,203);
        Bialystok.addDestination(Olsztyn,226);
        Bialystok.addDestination(Suwalki,129);

        //Toruń
        Torun.addDestination(Lodz,181);
        Torun.addDestination(Poznan,167);
        Torun.addDestination(Olsztyn, 176);
        Torun.addDestination(Gdansk, 170);
        Torun.addDestination(Pila, 143);

        //Gorzów Wlkp
        GorzowWlkp.addDestination(ZielonaGora,112);
        GorzowWlkp.addDestination(Poznan,162);
        GorzowWlkp.addDestination(Szczecin,111);
        GorzowWlkp.addDestination(Pila,121);

        //Piła
        Pila.addDestination(Torun,143);
        Pila.addDestination(GorzowWlkp,121);
        Pila.addDestination(Gdansk,223);
        Pila.addDestination(Koszalin,140);

        //Olsztyn
        Olsztyn.addDestination(Suwalki,196);
        Olsztyn.addDestination(Bialystok,226);
        Olsztyn.addDestination(Warszawa,216);
        Olsztyn.addDestination(Lodz,297);
        Olsztyn.addDestination(Torun,176);
        Olsztyn.addDestination(Gdansk,168);

        //Suwałki
        Suwalki.addDestination(Bialystok,129);
        Suwalki.addDestination(Warszawa,295);
        Suwalki.addDestination(Olsztyn,196);

        //Szczecin
        Szczecin.addDestination(GorzowWlkp,111);
        Szczecin.addDestination(Koszalin, 161);

        //Koszalin
        Koszalin.addDestination(Szczecin,161);
        Koszalin.addDestination(Pila,140);
        Koszalin.addDestination(Gdansk,193);

        //Gdańsk
        Gdansk.addDestination(Olsztyn,168);
        Gdansk.addDestination(Torun,170);
        Gdansk.addDestination(Pila,223);
        Gdansk.addDestination(Koszalin,193);

        g.addNode(Rzeszów);
        g.addNode(Krakow);
        g.addNode(Katowice);
        g.addNode(Wroclaw);
        g.addNode(Czestochowa);
        g.addNode(Kielce);
        g.addNode(Lublin);
        g.addNode(ZielonaGora);
        g.addNode(Poznan);
        g.addNode(Lodz);
        g.addNode(Warszawa);
        g.addNode(Bialystok);
        g.addNode(Torun);
        g.addNode(GorzowWlkp);
        g.addNode(Pila);
        g.addNode(Olsztyn);
        g.addNode(Suwalki);
        g.addNode(Szczecin);
        g.addNode(Koszalin);
        g.addNode(Gdansk);

        return g;
    }

    private void clearGraph() {
        for (Node it : graph.getNodes()
                ) {
            //System.out.println(it.getName() + " : " + it.getDistance());
            it.setDistance(2147483647);
        }
    }

//    private void clearGraph(Graph g) {
//        for (Node it : g.getNodes()
//                ) {
//            System.out.println(it.getName() + " : " + it.getDistance());
//            it.setDistance(2147483647);
//        }
//    }

//    public void clearAllGraphs() {
//        for (int i = 0; i < graphs.length; i++) {
//            clearGraph(graphs[i]);
//        }
//    }

    public ShortestPathDijkstra(String fileName, int iterations) {
        super(fileName, iterations);
    }

    @Override
    public void startTimeTest() {
        //PrintWriter pw = this.prepareFileWriter();
        prepareTestData();
        System.out.println("\t Data mem: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        for (int i = 0; i < this.getIterations(); i++) {
            timeDiff = System.nanoTime();

            Dijkstra.calculateShortestPathFromSource(graph, Krakow);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Rzeszów);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Katowice);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Wroclaw);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Czestochowa);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Kielce);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Lublin);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, ZielonaGora);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Poznan);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Lodz);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Warszawa);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Bialystok);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Torun);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, GorzowWlkp);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Pila);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Olsztyn);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Suwalki);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Szczecin);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Koszalin);
            clearGraph();
            Dijkstra.calculateShortestPathFromSource(graph, Gdansk);
            clearGraph();

            //pw.println( System.nanoTime() - timeDiff );
            //System.out.println(i);
        }

        //pw.close();
    }

    public static void main(String[] args) {
        ShortestPathDijkstra spd = new ShortestPathDijkstra("dijkstra_test",200000);
        spd.startTimeTest();
    }

}
