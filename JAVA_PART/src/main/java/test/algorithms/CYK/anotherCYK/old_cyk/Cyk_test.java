package test.algorithms.CYK.anotherCYK.old_cyk;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class Cyk_test {


    /**
     *
     * 0:1,10
     * 1:a
     * 10:b
     *
     */
    public static void main(String[] args) {
        Long duration;
        String[] arr = new String[2];
//        arr[0] = "C:\\Users\\wlato\\IdeaProjects\\engineers_thesis\\JAVA_PART\\src\\main\\java\\test\\algorithms\\CYK\\anotherCYK\\old_cyk\\grammar.txt";
//       arr[0] = "C:\\Users\\wlato\\IdeaProjects\\engineers_thesis\\JAVA_PART\\src\\main\\java\\test\\algorithms\\CYK\\anotherCYK\\old_cyk\\grammar1.txt"; // aba
        arr[0] = "C:\\Users\\wlato\\IdeaProjects\\engineers_thesis\\JAVA_PART\\src\\main\\java\\test\\algorithms\\CYK\\anotherCYK\\old_cyk\\grammar2.txt"; // baaba
        arr[1] = "baaba";

        BigInteger bigInteger = new BigInteger("0");



        for (int i = 0; i < 100000000; i++) {
            //GcUtils.disableGc();
            //System.out.println(i + ": Mem used before: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
            duration = System.nanoTime();
           //BigInteger X = new BigInteger("1000000000000000000000000000000000000000000000000");
            Cyk.main(arr);
            duration = System.nanoTime() - duration;
           // GcUtils.enableGc();
          //  System.out.println("solution Time : " + new DecimalFormat("#.##########").format(duration / 1000000000.0) + " Seconds");
            //System.out.println("Mem used: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
            // System.out.println(duration);
            //System.out.println(TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS));
//            System.out.println("Duration: " + duration / 1000000000.0 + " s " + duration % 1000000000.0 + " ms");
            bigInteger = bigInteger.add(BigInteger.valueOf(duration.intValue()));
        }

        bigInteger = bigInteger.divide(BigInteger.valueOf(200000));
        System.out.println("solution Time : " + new DecimalFormat("#.##########").format(bigInteger) + " Seconds");

        System.out.println("AVG: " + bigInteger.toString());
//        System.out.println("\n\r AVG: " + bigInteger.divide(BigInteger.valueOf(1000000000)).toString()
//                + "s " + bigInteger.mod(BigInteger.valueOf(1000000000)).toString() + " ms");
    }
}
