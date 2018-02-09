package mem;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by vm on 18.11.17.
 *
 * HOW TO FIND MEMORY ALLOCATED BY ADDITIONAL THREAD ?
 *
 * 1. CHECK MEM OF PROCESS
 * 2. CHECK MEM OF PROCESS + THREAD
 * 3. CHECK MEM OF PROCESS + THREAD + ALGORITHM
 *
 */

//        MemMeasure mm = new MemMeasure();
//        Thread t = new Thread( mm );
//        t.start();
//
//        t.interrupt();
//        System.out.println("\t\t" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
public class MemMeasure implements Runnable {

    String filepath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/MEMORY_TEST/JAVA/";
    String fileName = "J_MEM_LEVENSHTEIN";

    public PrintWriter prepareFileWriter() {
        try {
            PrintWriter writer = new PrintWriter(filepath + fileName + getTimeAndDate() + ".txt", "UTF-8");
            return writer;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String getTimeAndDate() {
        Date now = Calendar.getInstance().getTime();
        String day;
        if(now.getDay() < 10) {
            day = "0" + String.valueOf(now.getDay());
        } else {
            day = String.valueOf(now.getDay());
        }

        return "_" + day + String.valueOf(now.getMonth() +
                String.valueOf(now.getYear() % 2000) + "_" +
                String.valueOf(now.getHours()) + String.valueOf(now.getMinutes())
        );
    }

    public static long timeArr[] = new long[5000];

    public void run() {
        try {
            for (int i = 0; i < 5000; i++) {
                TimeUnit.MILLISECONDS.sleep(1);
                //System.out.println(i +  " " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
                //System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
                timeArr[i] = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            }
        } catch (Exception ex) {
            System.out.println("\t\t From thread:   " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

            System.out.println("@@@@@@@@@@@@@@@@ thread has been interrupted!!");
            PrintWriter pw = prepareFileWriter();
            System.out.println();
            for (int i = 0; i < 5000; i++) {
                if( timeArr[i] == 0 ) {
                    pw.close();
                    return;
                } else {
                    pw.println(timeArr[i]);
                    pw.flush();
                }
                //System.out.println(i + " " + timeArr[i]);
            }
            pw.close();
        }
    }

}
