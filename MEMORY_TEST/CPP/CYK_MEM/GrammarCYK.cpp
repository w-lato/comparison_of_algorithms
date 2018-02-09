//
// Created by vm on 04.11.17.
//

#include <iomanip>
#include "GrammarCYK.h"
#include "cyk/GRAMMAR.h"
#include "cyk/CYK.h"

GrammarCYK::GrammarCYK(const std::string &fileName, int iterations, const std::string &grammarPath) : Algorithm(
        fileName, iterations), grammarPath(grammarPath) {}

void GrammarCYK::startTimeTest() {
    prepareTestData();
//    std::fstream fs = prepareFileWriter();
    std::ifstream ifs(grammarPath);
    MB::grammar grammar(ifs);

    const size_t len = sizeof(sentence) / sizeof(sentence[0]);
    for (int j = 0; j < iterations; ++j) {
        auto start = std::chrono::high_resolution_clock::now();

        bool success = MB::cyk_parser(grammar).parse(sentence, sentence + len, std::cout);

        diff = std::chrono::high_resolution_clock::now() - start;
//        fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;
//        fs.flush();
        std::cout << j <<" " << success <<std::endl;
    }
//    fs.close();
}

void GrammarCYK::prepareTestData() {
    std::string sentence1[] =   // Bitwa pod Grunwaldem: 14.07.1410
            { "0","1","0","0","0","0","1","0",
                    "0","1","1","0","1","0","0","1",
                    "0","1","1","1","0","1","0","0",
                    "0","1","1","1","0","1","1","1",
                    "0","1","1","0","0","0","0","1",
                    "0","0","1","0","0","0","0","0",
                    "0","1","1","1","0","0","0","0",
                    "0","1","1","0","1","1","1","1",
                    "0","1","1","0","0","1","0","0",
                    "0","0","1","0","0","0","0","0",
                    "0","1","0","0","0","1","1","1",
                    "0","1","1","1","0","0","1","0",
                    "0","1","1","1","0","1","0","1",
                    "0","1","1","0","1","1","1","0",
                    "0","1","1","1","0","1","1","1",
                    "0","1","1","0","0","0","0","1",
                    "0","1","1","0","1","1","0","0",
                    "0","1","1","0","0","1","0","0",
                    "0","1","1","0","0","1","0","1",
                    "0","1","1","0","1","1","0","1",
                    "0","0","1","1","1","0","1","0",
                    "0","0","1","0","0","0","0","0",
                    "0","0","1","1","0","0","0","1",
                    "0","0","1","1","0","1","0","0",
                    "0","0","1","0","1","1","1","0",
                    "0","0","1","1","0","0","0","0",
                    "0","0","1","1","0","1","1","1",
                    "0","0","1","0","1","1","1","0",
                    "0","0","1","1","0","0","0","1",
                    "0","0","1","1","0","1","0","0",
                    "0","0","1","1","0","0","0","1",
                    "0","0","1","1","0","0","0","0"}; // 32 x 8


    for (int i = 0; i < 32 * 8; ++i) {
        sentence[i] = sentence1[i];
    }

}
