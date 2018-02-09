package mem;

import org.ejml.simple.SimpleMatrix;
import mem.Algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MatrixMultiplication extends Algorithm {

    ArrayList<SimpleMatrix> A;
    ArrayList<SimpleMatrix> B;
//    String path ="C:\\Users\\wlato\\Desktop\\praca_inzynierska\\MATRIX\\";
    String path ="/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/MATRIX/";

    public MatrixMultiplication(String fileName, int iterations) {
        super(fileName, iterations);
    }

    @Override
    public void prepareTestData() {
        A = new ArrayList<SimpleMatrix>();
        B = new ArrayList<SimpleMatrix>();
        for (int i = 1; i < 11; i++) {
            A.add(readMatrixFromFile("A"+i,400));
            B.add(readMatrixFromFile("B"+i,400));
        }
//        A = readMatrixesFromFile("set_A.txt");
//        B = readMatrixesFromFile("set_B.txt");
    }

    public void printM() {
        for (int i = 0; i < A.size(); i++) {
            A.get(i).print();
        }
    }

    private SimpleMatrix readMatrixFromFile(String fileName, int size) {
        try {
            double[][] arr = new double[size][size];
            BufferedReader br = new BufferedReader(new FileReader(path + fileName ));
            String[] strDoubles;
            int row = 0;
            String line = br.readLine();
            while (line != null && row < size) {
//                System.out.println(line);
//                System.out.println(row);
                strDoubles = line.split(",");
                loadValues(row, arr, strDoubles);
                row++;
                line = br.readLine();
            }
            br.close();
            return new SimpleMatrix(arr);
            //return new SimpleMatrix(arr);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    private void loadValues(int row, double[][] arr, String[] doubleVals) {
        for (int i = 0; i < doubleVals.length; i++) {
            arr[row][i] = Double.valueOf(doubleVals[i]);
        }
    }

    // -XX:+PrintCompilation
    // -XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation
    // -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -Xmx4G -Xms2G
    @Override
    public void startTimeTest() {
        prepareTestData();
        SimpleMatrix C;


        System.out.println("\t Dataa" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));


        for (int i = 0; i < this.getIterations(); i++) {
            long xd = System.currentTimeMillis();
            timeDiff = System.nanoTime();
            for (int j = 0; j < A.size(); j++) {
                C = A.get(j).mult(B.get(j));
            }

            System.out.println(System.currentTimeMillis() - xd);
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
//        System.out.println("\t\t" + Runtime.getRuntime().totalMemory());
        System.out.println( (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

        MemMeasure mm = new MemMeasure();

        Thread t = new Thread( mm );
      //  System.out.println("\t\t" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        t.start();

        MatrixMultiplication test = new MatrixMultiplication("MatrixMul",1);
        test.startTimeTest();
        t.interrupt();

//        System.out.println("\t\t" + Runtime.getRuntime().totalMemory());
        System.out.println("Max: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));


//        int[][] x =  {
//                {1,1,1},
//                {2,2,2},
//                {3,3,3}
//        };
//        for (int i = 0; i < 3; i++) {
//            System.out.println(x[1][i]);
//        }
    }
}
