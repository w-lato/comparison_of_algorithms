package MAIN;

/**
 * Created by vm on 18.12.17.
 */
public class Main {
    public static void main(String[] args) {
//
//        TestAlgorithm ta = new TestAlgorithm("/home/vm/Desktop/","JIT_TEST",3000);
//        ta.startTimeTest();

//        String sortDataPath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/MERGE_SORT/";
//        RegularMergeSort ms = new RegularMergeSort(args[0],500, sortDataPath);
//        ms.startTimeTest();


        GrammarCYK test = new GrammarCYK("CYK_JIT_TEST",500);
        test.startTimeTest();

    }
}
