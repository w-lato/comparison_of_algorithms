package testing.platform.time.test;

import org.apache.commons.io.IOUtils;
import testing.platform.algorithms.implementation.RabinKarp;
import testing.platform.Algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

public class PatternMatchingRabinKarp extends Algorithm {

    String filePath = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\potop.txt";
    String text;

    public PatternMatchingRabinKarp(String fileName, int iterations) {
        super(fileName, iterations);
    }

    @Override
    public void prepareTestData() {
        try {
            text = IOUtils.toString(new FileInputStream(new File(filePath)), "UTF-8");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void startTimeTest() {
        prepareTestData();
        PrintWriter pw = this.prepareFileWriter();

        for (int i = 0; i < this.getIterations(); i++) {

            timeDiff = System.nanoTime();

            RabinKarp.search("Zagłoba",text, 101);
            RabinKarp.search("Kmicic",text,107);
            RabinKarp.search("Radziwiłł", text,113);
            RabinKarp.search( "Czarniecki", text,117);
            RabinKarp.search( "Kowalski", text, 119);
            RabinKarp.search( "Bóg", text, 123);
            RabinKarp.search( "Kazimierz", text, 127);
            RabinKarp.search( "Lubomirski" , text, 131);
            RabinKarp.search( "Kordecki" , text, 137);
            RabinKarp.search( "Sapieha" , text, 139);

            RabinKarp.search("Chmielnicki",text, 201);
            RabinKarp.search("Wolodyjowski",text,207);
            RabinKarp.search("Oleńka", text,213);
            RabinKarp.search( "Babinicz", text,217);
            RabinKarp.search( "Kordecki", text, 219);
            RabinKarp.search( "Zamojski", text, 223);
            RabinKarp.search( "Sakowicz", text, 227);
            RabinKarp.search( "Gustaw" , text, 231);
            RabinKarp.search( "Radziejowski" , text, 237);
            RabinKarp.search( "Zamoyski" , text, 239);

            pw.println( System.nanoTime() - timeDiff );
        }
        pw.close();
    }

    public static void main(String[] args) {
        PatternMatchingRabinKarp pmr = new PatternMatchingRabinKarp("RabinKarp", 100);
        pmr.startTimeTest();
    }
}
