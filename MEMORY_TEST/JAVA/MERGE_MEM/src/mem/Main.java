package mem;

/**
 * Created by vm on 27.11.17.
 */
public class Main {
    public static void main(String[] args) {
        String sortDataPath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/MERGE_SORT/";


        MemMeasure mm = new MemMeasure();
        Thread t = new Thread( mm );
        t.start();

        RegularMergeSort ms = new RegularMergeSort("MergeSort_",1, sortDataPath);
        ms.startTimeTest();
        t.interrupt();
        System.out.println("\t\t Max: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }
}
