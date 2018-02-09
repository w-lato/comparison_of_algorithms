#include <iostream>
#include <chrono>
#include <fstream>
#include <iomanip>


std::string getTimeAndDate() {
    time_t t = time(0);
    struct tm * now = localtime( &t );

    std::string day;
    if( now->tm_mday < 10 ) {
        day = "0" + std::to_string(now->tm_mday);
    } else {
        day = std::to_string(now->tm_mday);
    }

    return "_" + day + std::to_string(now->tm_mon + 1) + std::to_string(now->tm_year + 1900)
           + "_" + std::to_string(now->tm_hour) + std::to_string(now->tm_min);
}

std::fstream prepareFileWriter(std::string filePath, std::string fileName) {
    std::fstream fs;
    fs.open(filePath + fileName + getTimeAndDate(), std::fstream::out);
    return fs;
}


int main() {
    std::cout << "Hello, World! " << UINT64_MAX <<std::endl; // 4.294.967.295

    std::fstream fs = prepareFileWriter("/home/vm/Desktop/","CPP_ADD_LOOP_");
    std::chrono::duration<double> diff;
    uint64_t x = 0;
    for (int i = 0; i < 15000; ++i) {
        auto start = std::chrono::high_resolution_clock::now();
        for (int j = 0; j < 900000000; ++j) {
            x += 1;
        }
        diff = std::chrono::high_resolution_clock::now() - start;
        fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;

        std::cout << i << " " << diff.count() << " : " << x <<std::endl;
    }
    fs.close();

    return 0;
};