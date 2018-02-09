package mem;

/**
 * Created by vm on 27.11.17.
 */
public class Main {
    public static void main(String[] args) {


        MemMeasure mm = new MemMeasure();
        Thread t = new Thread( mm );
        t.start();

        String path = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/QUICK_SORT/";
        CormenQuickSort cqs = new CormenQuickSort("QuickSort",1, path);

        cqs.startTimeTest();
        t.interrupt();
        System.out.println("\t\t Max:" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }
}
