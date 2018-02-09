package testing.platform.time.test;

import testing.platform.algorithms.implementation.MergeSort;
import testing.platform.SortDataType;
import testing.platform.SortingAlgorithm;

import java.io.PrintWriter;

public class RegularMergeSort extends SortingAlgorithm {

    public RegularMergeSort(String fileName, int iterations, String path) {
        super(fileName, iterations, path);
    }

    protected void testAndWriteTofile(int[] aux, SortDataType type,
                                      MergeSort gms) {
        PrintWriter pw = this.prepareFileWriter(type);
        for (int i = 0; i < this.getIterations(); i++) {
            if(type == SortDataType.RANDOM)
                for (int j = 0; j < aux.length; j++) aux[j] = random[j];
            if(type == SortDataType.SORTED_ASC)
                for (int j = 0; j < aux.length; j++) aux[j] = sortedAsc[j];
            if(type == SortDataType.SORTED_DESC)
                for (int j = 0; j < aux.length; j++) aux[j] = sortedDesc[j];
            if(type == SortDataType.SAME)
                for (int j = 0; j < aux.length; j++) aux[j] = same[j];

//            System.out.println(type);
//            for (int j = 0; j < aux.length; j++) {
//                System.out.print(aux[j] + " ");
//                if(j % 50 == 0) System.out.println("");
//            }

            timeDiff = System.nanoTime();
            gms.sort(aux, 0, aux.length - 1);
            pw.println( System.nanoTime() - timeDiff );
            pw.flush();
            System.out.println(i);
        }
        pw.close();
    }

    @Override
    public void prepareTestData() {
        readDataFrom(SortDataType.RANDOM);
        readDataFrom(SortDataType.SORTED_ASC);
        readDataFrom(SortDataType.SORTED_DESC);
        readDataFrom(SortDataType.SAME);
    }

    @Override
    public void startTimeTest() {
        prepareTestData();
        int[] aux = new int[same.length];
        MergeSort gms = new MergeSort();

        testAndWriteTofile(aux,SortDataType.RANDOM, gms);
        testAndWriteTofile(aux,SortDataType.SORTED_ASC, gms);
        testAndWriteTofile(aux,SortDataType.SORTED_DESC, gms);
        testAndWriteTofile(aux,SortDataType.SAME, gms);
    }

    public static void main(String[] args) {
        //String sortDataPath = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\MERGE_SORT_DATA\\";
        String sortDataPath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/MERGE_SORT/";
        RegularMergeSort ms = new RegularMergeSort("MergeSort_",10000, sortDataPath);
        ms.startTimeTest();
    }

}
