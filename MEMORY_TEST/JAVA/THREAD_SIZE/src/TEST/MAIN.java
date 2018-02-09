package TEST;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

/**
 * Created by vm on 26.11.17.
 *
 *-XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
 *
 */
public class MAIN {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

//        // FastFourierTransform1D fft1 = new FastFourierTransform1D("FFT_WINTER", 1);
        MemMeasure mm = new MemMeasure();

        System.out.println("SIZE of MM: " + ObjectSizeCalculator.getObjectSize( new MemMeasure()));
        System.out.println("SIZE of thread: " + ObjectSizeCalculator.getObjectSize( new Thread( mm )));
        //System.out.println("SIZE of thread: " + ObjectSizeCalculator.getObjectSize( ));

//        Thread t = new Thread( mm );
//
//        System.out.println("BEFORE START: "  + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
//
//        t.start();
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//
//        }
//        t.interrupt();
//
//        System.out.println("end" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

}
