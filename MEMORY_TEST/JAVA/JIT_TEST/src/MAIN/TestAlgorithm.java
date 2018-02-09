package MAIN;

import java.io.PrintWriter;

/**
 * Created by vm on 18.12.17.
 */
public class TestAlgorithm extends Algorithm {


    public TestAlgorithm(String filePath, String fileName, int iterations) {
        super(filePath, fileName, iterations);
    }

    @Override
    public void prepareTestData() {

    }

    @Override
    public void startTimeTest() {
        PrintWriter pw = this.prepareFileWriter();
        String s1 = "", s2 = "";


        int ctr = 1;

        for (int i = 0; i < this.getIterations(); i++) {
            timeDiff = System.nanoTime();

            long s = System.currentTimeMillis();
            //for (int k = 0; k < 1100000000; k++) {
            for (int k = 0; k < 25000000; k++) {
                ctr *= 2;
                if(ctr == 0) {
                    ctr = 1;
                }
            }
            s = System.currentTimeMillis() - s;

            pw.println( System.nanoTime() - timeDiff );
            pw.flush();
            System.out.println(i + " : ");
        }
        pw.close();
    }
}
