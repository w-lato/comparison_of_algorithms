package mem;


import java.io.PrintWriter;

public class CormenQuickSort extends SortingAlgorithm {

    public CormenQuickSort(String fileName, int iterations, String sortDataPath) {
        super(fileName, iterations, sortDataPath);
    }

    protected void testAndWriteTofile(int[] aux, SortDataType type,
                                     mem.implementation.CormenQuickSort qs) {
        //PrintWriter pw = this.prepareFileWriter(type);
        System.out.println("\t\t Data:" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        for (int i = 0; i < this.getIterations(); i++) {
            if(type == SortDataType.RANDOM)
                for (int j = 0; j < aux.length; j++) aux[j] = random[j];
//            if(type == SortDataType.SORTED_ASC)
//                for (int j = 0; j < aux.length; j++) aux[j] = sortedAsc[j];
//            if(type == SortDataType.SORTED_DESC)
//                for (int j = 0; j < aux.length; j++) aux[j] = sortedDesc[j];
//            if(type == SortDataType.SAME)
//                for (int j = 0; j < aux.length; j++) aux[j] = same[j];

//            System.out.println(type);
//            for (int j = 0; j < aux.length; j++) {
//                System.out.print(aux[j] + " ");
//                if(j % 50 == 0) System.out.println("");
//            }

            timeDiff = System.nanoTime();
            qs.sort(aux, 0, aux.length - 1);
//            pw.println( System.nanoTime() - timeDiff );
//            pw.flush();
            System.out.println(i);
        }
//        pw.close();
    }

    @Override
    public void prepareTestData() {
        readDataFrom(SortDataType.RANDOM);
//        System.out.println("size: " + random.length);
//        readDataFrom(SortDataType.SORTED_ASC);
//        readDataFrom(SortDataType.SORTED_DESC);
//        readDataFrom(SortDataType.SAME);
    }

    @Override
    public void startTimeTest() {
        prepareTestData();

        int[] aux = new int[8192];
        mem.implementation.CormenQuickSort qs = new mem.implementation.CormenQuickSort();

        testAndWriteTofile(aux, SortDataType.RANDOM, qs);
//        testAndWriteTofile(aux, SortDataType.SORTED_ASC, qs);
//        testAndWriteTofile(aux, SortDataType.SORTED_DESC, qs);
//        testAndWriteTofile(aux, SortDataType.SAME, qs);
    }

//    public static void main(String[] args) {
//        //String path = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\SORT_DATA\\";
//        String path = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/QUICK_SORT/";
//        CormenQuickSort cqs = new CormenQuickSort("QuickSort",1, path);
//        cqs.startTimeTest();
//    }
}
