package testing.platform.time.test;

import testing.platform.algorithms.implementation.NumericFFT;
import testing.platform.Algorithm;

import java.io.*;
import java.util.ArrayList;

public class FastFourierTransform1D extends Algorithm {

    /**
     * Each array elem with odd index keeps Imaginary value
     * Each array elem with even index keeps real value of Complex number
     *
     * e.g.
     * Complex(1.0, -2.0) -> complexVals[x] == 1.0 , complexVals[x + 1] = -2.0;
     */
    double[] complexVals;
    //String path = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\MATLAB_FFT\\orig_winter.txt";
    //String path = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\MATLAB_FFT\\orig_winter.txt";
    String path = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/orig_winter.txt";

    public FastFourierTransform1D(String fileName, int iterations) {
        super(fileName, iterations);
    }

    public void readDoublesFromFile() {
        BufferedReader br;
        int size = (int)(Math.pow(2,22));
        complexVals = new double[size * 2];

        try {
            ArrayList<Double> arr = new ArrayList<Double>();
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();

            // convert lines of scientific notation double vals txt
            int ctr = 0;
            while (line != null &&  ctr < size) {
                arr.add(new Double(line));
                line = br.readLine();
                ctr++;
            }
            br.close();

            System.out.println(size * 2);
            System.out.println(arr.size() * 2);
            for (int i = 0; i < arr.size(); i++) {
                complexVals[i * 2] = arr.get(i).doubleValue(); // re
                complexVals[1 + i * 2] = 0.0;                  // im
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }


    public void fillWithOriginalData(double[] arr) {
        for (int i = 0; i < complexVals.length; i++) {
            arr[i] = complexVals[i];
        }
    }

    @Override
    public void prepareTestData() {
        // prepare int array
        //
        //
        readDoublesFromFile();
    }

    @Override
    public void startTimeTest() {
        prepareTestData();
        double[] testComplexArr = new double[complexVals.length];
        PrintWriter pw = this.prepareFileWriter();

        for (int i = 0; i < this.getIterations(); i++) {
            fillWithOriginalData(testComplexArr);
//            for (int j = 0; j < testComplexArr.length; j++) {
//                System.out.print(testComplexArr[j] + " ");
//                if(j % 50 == 0)System.out.println("");
//            }
            timeDiff = System.nanoTime();
            // second param: 2 * nn = arr.length
            NumericFFT.four1(testComplexArr, (int)testComplexArr.length / 2);
            long diff = System.nanoTime() - timeDiff;
            pw.println( diff );

//            System.out.println("\r\n\r\n\r\n");
//            for (int j = 0; j < testComplexArr.length; j++) {
//                System.out.print(testComplexArr[j] + " ");
//                if(j % 50 == 0)System.out.println("");
//            }
            System.out.println(i);
        }
        pw.close();
    }

    public static void main(String[] args) {
        FastFourierTransform1D fft1 = new FastFourierTransform1D("FFT_WINTER", 20000);
        fft1.startTimeTest();
    }
}
