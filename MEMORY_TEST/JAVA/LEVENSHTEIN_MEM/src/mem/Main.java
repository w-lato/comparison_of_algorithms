package mem;

/**
 * Created by vm on 27.11.17.
 */
public class Main {

    public static void main(String[] args) {

        MemMeasure mm = new MemMeasure();
        Thread t = new Thread( mm );
        t.start();
        EditDistanceLevenshtein edl = new EditDistanceLevenshtein("LEVENSHTEIN_MEM",1);
        edl.startTimeTest();
        t.interrupt();
        System.out.println("\t\t max size: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

}
