package mem;

// -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
// -Xms3G -Xmx4G
/**
 * Created by vm on 04.11.17.
 *
 *
 *
 *
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());


        MemMeasure mm = new MemMeasure();
        Thread t = new Thread( mm );
        t.start();

        FastFourierTransform1D fft1 = new FastFourierTransform1D("FFT_WINTER", 1);
        fft1.startTimeTest();
        t.interrupt();

        System.out.println("Max: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }
}
