package MAIN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class SortingAlgorithm extends Algorithm {

    String sortDataPath;

    protected int[] random;
    protected int[] sortedAsc;
    protected int[] sortedDesc;
    protected int[] same;

    public SortingAlgorithm(String fileName, int iterations, String sortDataPath) {
        super(fileName, iterations);
        this.sortDataPath = sortDataPath;
    }

//    public SortingAlgorithm(String fileName, int iterations) {
//        super(fileName, iterations);
//    }

    protected PrintWriter prepareFileWriter(SortDataType type) {
        System.out.println(sortDataPath);
        try {
            String dataType = "";
            PrintWriter writer;
            switch ( type ) {
                case SAME: dataType += "SAME"; break;
                case RANDOM: dataType += "JIT_TEST"; break;
                case SORTED_ASC: dataType += "SORTED_ASC"; break;
                default: dataType += "SORTED_DESC"; break;
            }
            return new PrintWriter(filepath + fileName + dataType + getTimeAndDate() + ".txt", "UTF-8");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    protected void readDataFrom(SortDataType type) {

        BufferedReader br;
        try {
            String filename;
            switch(type) {
                case SAME: filename = "same.txt"; break;
                case RANDOM: filename = "random.txt"; break;
                case SORTED_ASC: filename = "sortedAsc.txt"; break;
                default: filename = "sortedDesc.txt"; break;
            }

            br = new BufferedReader(new FileReader(sortDataPath + filename));

            ArrayList<Integer> arr = new ArrayList<>();
            String line = br.readLine();

//            while (line != null && ctr <= Math.pow(2.0, 22)) {
            int ctr = 0;
            while ( line != null ) {
                arr.add(Integer.valueOf(line));
                line = br.readLine();
                ctr++;
            }
            br.close();

//            System.out.println(fileName);
//            for (int j = 0; j < arr.size(); j++) {
//                System.out.print(arr.get(j) + " ");
//                if(j % 50 == 0) System.out.println("");
//            }

            switch (type) {
                case RANDOM:
                    random = new int[arr.size()];
                    for (int i = 0; i < arr.size(); i++)
                        random[i] = arr.get(i);
                    return;
                case SAME:
                    same = new int[arr.size()];
                    for (int i = 0; i < arr.size(); i++)
                        same[i] = arr.get(i);
                    return;
                case SORTED_ASC:
                    sortedAsc = new int[arr.size()];
                    for (int i = 0; i < arr.size(); i++)
                        sortedAsc[i] = arr.get(i);
                    return;
                default: //sortedDesc
                    sortedDesc = new int[arr.size()];
                    for (int i = 0; i < arr.size(); i++)
                        sortedDesc[i] = arr.get(i);
                    return;
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }




}
