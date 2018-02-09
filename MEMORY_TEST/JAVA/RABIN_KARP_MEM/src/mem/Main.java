package mem;

/**
 * Created by vm on 27.11.17.
 */
public class Main {
    public static void main(String[] args) {

        MemMeasure mm = new MemMeasure();
        Thread t = new Thread( mm );
        t.start();

        PatternMatchingRabinKarp pmr = new PatternMatchingRabinKarp("RabinKArp",1);
        pmr.startTimeTest();
        t.interrupt();
        System.out.println("\t\t Max: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }
}
