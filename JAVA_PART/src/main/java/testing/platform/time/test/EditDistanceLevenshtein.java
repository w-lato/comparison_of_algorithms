package testing.platform.time.test;

import info.debatty.java.stringsimilarity.Levenshtein;
import org.apache.commons.io.IOUtils;
import testing.platform.Algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

public class EditDistanceLevenshtein extends Algorithm {


    @Override
    public void prepareTestData() {

    }

    public EditDistanceLevenshtein(String fileName, int iterations) {
        super(fileName, iterations);
    }

    @Override
    public void startTimeTest() {
        PrintWriter pw = this.prepareFileWriter();
        long timeDiff;String s1 = "",s2 = "";
        Levenshtein levenshtein = new Levenshtein();

        try {
            s1 = IOUtils.toString(new FileInputStream(new File("C:\\Users\\wlato\\Desktop\\praca_inzynierska\\levenshtein_bible\\tysiaclecia_utf8.txt")), "UTF-8");
            s2 = IOUtils.toString(new FileInputStream(new File("C:\\Users\\wlato\\Desktop\\praca_inzynierska\\levenshtein_bible\\poznanska_utf8.txt")), "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < this.getIterations(); i++) {
            timeDiff = System.nanoTime();
            levenshtein.distance(s1,s2);
            pw.println( System.nanoTime() - timeDiff );
        }

        pw.close();
    }

    public static void main(String[] args) {
        EditDistanceLevenshtein test = new EditDistanceLevenshtein("editDistance_1",100);
        test.startTimeTest();
    }
}
