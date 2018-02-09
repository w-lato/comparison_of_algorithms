package main;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by vm on 18.11.17.
 */
public class Main {

    public static int ctr = 0;
    protected static final String filepath = "/home/vm/Desktop/";

    public static String getTimeAndDate() {
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

    public static  PrintWriter prepareFileWriter() {
        try {
            PrintWriter writer = new PrintWriter(Main.filepath + "ADD_LOOP_" + getTimeAndDate() + ".txt", "UTF-8");
            return writer;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        PrintWriter writer = Main.prepareFileWriter();

        for (int i = 0; i < 15000; i++) {
            long s = System.currentTimeMillis();
            for (int k = 0; k < 900000000; k++) {
                Main.ctr++;
                if (Main.ctr == 100000000) {
                    Main.ctr = 0;
                }
            }
            s = System.currentTimeMillis() - s;
            System.out.println(i);
            writer.println(s);
            writer.flush();
        }
      writer.close();
    }
}
