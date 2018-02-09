package mem;

/**
 * Created by vm on 26.11.17.
 */
public class Main {

    public static void main(String[] args) {

        MemMeasure mm = new MemMeasure();
        Thread t = new Thread( mm );
        t.start();

        GrammarCYK gc = new GrammarCYK("cYK",1);
        gc.startTimeTest();
        t.interrupt();
        System.out.println("Max: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }
}
