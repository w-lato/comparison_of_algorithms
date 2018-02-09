package main;

/**
 * Created by vm on 08.11.17.
 */
public class Main {
    public static void main(String[] args) {


        MemMeasure mm = new MemMeasure();
        Thread t = new Thread( mm );
        t.start();

        ShortestPathDijkstra dijk = new ShortestPathDijkstra("dijkstra_test",1);
        dijk.startTimeTest();
        t.interrupt();
        System.out.println("Max mem: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }
}
