package testing.platform.data.source.preparation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class PrepareMatrixes {
    public static void prepare(String varName, int size) {
        Random r = new Random();
        double[][] x = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                x[i][j] = r.nextGaussian();
            }
        }
        System.out.println("double[][]" + varName +" = {");
        for (int i = 0; i < size; i++) {
            System.out.print("\t{");
            for (int j = 0; j < size; j++) {
                if( j == size - 1) {
                    System.out.print(x[i][j]);
                } else {
                    System.out.print(x[i][j] + ", ");
                }
            }
            if(i == size - 1) {
                System.out.print("}\r\n");
            } else {
                System.out.print("},\r\n");
            }
        }
        System.out.println("};");
        System.out.println("");

    }

    public static void preparePlain(int size) {
        Random r = new Random();
        double[][] x = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                x[i][j] = r.nextGaussian();
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if( j == size - 1) {
                    System.out.print(x[i][j]);
                } else {
                    System.out.print(x[i][j] + ", ");
                }
            }
            System.out.println("");
        }
    }


    public static void preparePlain(int[] sizes, String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            Random r = new Random();
            for (int k = 0; k < sizes.length; k++) {
                double[][] x = new double[sizes[k]][sizes[k]];

                for (int i = 0; i < sizes[k]; i++) {
                    for (int j = 0; j < sizes[k]; j++) {
                        x[i][j] = r.nextGaussian();
                    }
                }

                for (int i = 0; i < sizes[k]; i++) {
                    String line = "";
                    for (int j = 0; j < sizes[k]; j++) {
                        if( j == sizes[k] - 1) {
                            line += x[i][j];
                        } else {
                            line += x[i][j] + ", ";
                        }
                    }
                    writer.write(line+ "\r\n");
                }
            }
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }



    public static void main(String[] args) {
//        PrepareMatrixes.preparePlain(10);
//        PrepareMatrixes.preparePlain(20);
//        PrepareMatrixes.preparePlain(30);
//        PrepareMatrixes.preparePlain(40);
//        PrepareMatrixes.preparePlain(50);

        String aPath = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\MATRIX\\set_A.txt";
        String bPath = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\MATRIX\\set_B.txt";
        PrepareMatrixes.preparePlain(new int[] {500,600,700,800,900,1000}, aPath);
        PrepareMatrixes.preparePlain(new int[] {500,600,700,800,900,1000}, aPath);
//        PrepareMatrixes.preparePlain(new int[] {100,200,300,400,500,600}, bPath);
    }
}
