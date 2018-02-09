#include <iostream>
#include "testing/Algorithm.h"
#include "testing/SortingAlgorithm.h"
#include "testing/time/test/CormenQuickSort.h"
#include "testing/time/test/RegularMergeSort.h"
#include "testing/time/test/FastFourierTransform1D.h"
#include "testing/time/test/ShortestPathDijkstra.h"
#include "testing/time/test/PatternMatchingRabinKarp.h"
#include "testing/time/test/MatrixMultiplication.h"
#include "testing/time/test/EditDistanceLevenshtein.h"
#include "testing/time/test/FordFulkersonMaxFlow.h"
#include "testing/time/test/GrammarCYK.h"
#include "testing/algorithms/cyk/GRAMMAR.h"
#include "testing/algorithms/cyk/CYK.h"
#include "testing/time/test/HashBloomFilter.h"


int main() {

//    std::cout << std::chrono::high_resolution_clock::period::den << std::endl;
//    std::cout << std::chrono::high_resolution_clock::period::num << std::endl;


//    Algorithm a = Algorithm("algo",0);
//    std::cout << a.getTimeAndDate();
//
//    SortingAlgorithm sa = SortingAlgorithm("asds",0,"fsdfd");


//    std::string dataPath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/MERGE_SORT/";
//    RegularMergeSort rms = RegularMergeSort("MergeSort", 10000, dataPath);
//    rms.startTimeTest();

//    FastFourierTransform1D fft = FastFourierTransform1D("FFT_",10000);
//    fft.startTimeTest();

//    ShortestPathDijkstra spd = ShortestPathDijkstra("Dijkstra_", 10000);
//    spd.startTimeTest();

//    std::string potop = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/potop.txt";
//    std::string trylogia = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/henryk_sienkiewicz_trylogia.txt";
//    PatternMatchingRabinKarp pmrk = PatternMatchingRabinKarp("pattern", 10000, trylogia);
//    pmrk.startTimeTest();
//
//    std::string matrixFilePath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/MATRIX/";
//    MatrixMultiplication mm = MatrixMultiplication("MatrixMult", 10000, matrixFilePath);
//    mm.startTimeTest();

//    std::string grammarPath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/grammar_cpp.txt";
//    GrammarCYK cyk = GrammarCYK("CYK_",10000, grammarPath);
//    cyk.startTimeTest();

//    std::string pathA = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/EDIT_DIST/tysiaclecia_utf8.txt";
//    std::string pathB = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/EDIT_DIST/poznanska_utf8.txt";
//    EditDistanceLevenshtein edl = EditDistanceLevenshtein("Levenshtein_", 10000, pathA, pathB);
//    edl.startTimeTest();

//    FordFulkersonMaxFlow ff = FordFulkersonMaxFlow("Maxflow", 10000);
//    ff.startTimeTest();


//    std::string dataPath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/MERGE_SORT/";
    std::string dataPath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/QUICK_SORT/";
    CormenQuickSort cqs = CormenQuickSort("QuickSort", 10000, dataPath);
    cqs.startTimeTest();



//    GrammarCYK cyk = GrammarCYK("CTK_",1, grammarPath);
//    cyk.startTimeTest();
//    std::string filename = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/grammar_cpp.txt";
//    std::ifstream ifs(filename);
//    if (ifs) {
//        MB::grammar grammar(ifs);
//        //std::string sentence[] = {"b", "a", "a", "b", "a"};
////        std::string sentence[] = {"a", "a", "a", "b",
////                                  "a", "b", "a", "a",
////                                  "a", "a", "a", "a",
////                                  "a", "b", "b", "b",
////                                  "a", "a", "a", "b",
////                                  "a", "b", "a", "a",
////                                  "a", "a", "a", "b",
////                                  "a", "a", "a", "a"};
////        std::string sentence[] = {"0", "0", "0", "1",
////                                  "0", "1", "0", "0",
////                                  "0", "0", "0", "0",
////                                  "0", "1", "1", "1",
////                                  "0", "0", "0", "1",
////                                  "0", "1", "0", "0",
////                                  "0", "0", "0", "1",
////                                  "0", "0", "0", "0"};
//        std::string sentence[] = {"0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "0",
//                                  "0", "1", "1", "1",
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "1",
//                                  "0", "0", "0", "0",
//
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "0",
//                                  "0", "1", "1", "1",
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "1",
//                                  "0", "0", "0", "0",
//
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "0",
//                                  "0", "1", "1", "1",
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "1",
//                                  "0", "0", "0", "0",
//
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "0",
//                                  "0", "1", "1", "1",
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "1",
//                                  "0", "0", "0", "0",
//
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "0",
//                                  "0", "1", "1", "1",
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "1",
//                                  "0", "0", "0", "0",
//
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "0",
//                                  "0", "1", "1", "1",
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "1",
//                                  "0", "0", "0", "0",
//
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "0",
//                                  "0", "1", "1", "1",
//                                  "0", "0", "0", "1",
//                                  "0", "1", "0", "0",
//                                  "0", "0", "0", "1",
//                                  "0", "0", "0", "0",
//        };
//
//
//        const size_t len = sizeof(sentence) / sizeof(sentence[0]);
//        bool success = MB::cyk_parser(grammar).parse(sentence, sentence + len, std::cout);
//        std::cout << "Success: " << std::boolalpha << success << '\n';
//    }
//    else {
//        std::cerr << "Couldn't open " << filename << " for reading\n";
//    }
//
//    return 0;
    return 0;
}