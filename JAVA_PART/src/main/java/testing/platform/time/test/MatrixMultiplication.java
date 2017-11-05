package testing.platform.time.test;

import org.ejml.simple.SimpleMatrix;
import testing.platform.Algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

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
        A = new ArrayList<>();
        B = new ArrayList<>();
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

    private ArrayList<SimpleMatrix> readMatrixesFromFile(String fileName) {
        ArrayList<SimpleMatrix> matArr = new ArrayList<SimpleMatrix>();

        int a = 500;
        int b = 600;
        int c = 700;
        int d = 800;
        int e = 900;
        int f = 1000;
        double[][] m10 = new double[a][a];
        double[][] m30 = new double[b][b];
        double[][] m50 = new double[c][c];
        double[][] m100 = new double[d][d];
        double[][] m200 = new double[e][e];
        double[][] m500 = new double[f][f];
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(path + fileName ));
            String[] strDoubles;
            int row = 0;
            int currentLength = 500;
            String line = br.readLine();
            while (line != null) {
                strDoubles = line.split(",");
                if(currentLength == row) {
                    if(currentLength == a) currentLength = b;
                    if(currentLength == b) currentLength = c;
                    if(currentLength == c) currentLength = d;
                    if(currentLength == d) currentLength = e;
                    if(currentLength == e) currentLength = f;
                    row = 0;
                }
                if(currentLength == a) loadValues(row, m10, strDoubles );
                if(currentLength == b) loadValues(row, m30, strDoubles );
                if(currentLength == c) loadValues(row, m50, strDoubles );
                if(currentLength == d) loadValues(row, m100, strDoubles );
                if(currentLength == e) loadValues(row, m200, strDoubles );
                if(currentLength == f) loadValues(row, m500, strDoubles );
                row++;
                line = br.readLine();
            }
            br.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        matArr.add(new SimpleMatrix(m10));
        matArr.add(new SimpleMatrix(m30));
        matArr.add(new SimpleMatrix(m50));
        matArr.add(new SimpleMatrix(m100));
        matArr.add(new SimpleMatrix(m200));
        matArr.add(new SimpleMatrix(m500));
        return matArr;
    }

    private void loadValues(int row, double[][] arr, String[] doubleVals) {
        for (int i = 0; i < doubleVals.length; i++) {
            arr[row][i] = Double.valueOf(doubleVals[i]);
        }
    }

    // -XX:+PrintCompilation
    // -XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation
    @Override
    public void startTimeTest() {
        prepareTestData();
        SimpleMatrix C;


        // WARMUP
        System.out.println("WARMUP");
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < A.size(); j++) {
                C = A.get(j).mult(B.get(j));
            }
            if(i % 100 == 0)
                System.out.println(i/100 + "%");
        }

        PrintWriter pw = this.prepareFileWriter();
        for (int i = 0; i < this.getIterations(); i++) {
            long xd = System.currentTimeMillis();
            timeDiff = System.nanoTime();
            for (int j = 0; j < A.size(); j++) {
                C = A.get(j).mult(B.get(j));
            }
//            C = A.get(9).mult(B.get(9));
//            C.print();
//            A.get(0).mult(B.get(0)); // 10
//            A.get(1).mult(B.get(1)); // 30
//            A.get(2).mult(B.get(2)); // 50
//            A.get(3).mult(B.get(3)); // 100
//            A.get(4).mult(B.get(4)); // 200
//            A.get(5).mult(B.get(5)); // 500
            pw.println( System.nanoTime() - timeDiff );
            System.out.println(System.currentTimeMillis() - xd);
            System.out.println(i);
        }
        pw.close();
    }

    public static void main(String[] args) {
        MatrixMultiplication test = new MatrixMultiplication("MatrixMul",1000);
        test.startTimeTest();
        //  test.startTimeTest();


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
