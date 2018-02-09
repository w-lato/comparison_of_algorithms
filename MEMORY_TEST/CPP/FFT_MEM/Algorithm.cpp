//
// Created by vm on 02.11.17.
//

#include "Algorithm.h"

std::string Algorithm :: getTimeAndDate() {
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

std::fstream Algorithm::prepareFileWriter() {
    std::fstream fs;
    fs.open(filePath + fileName + getTimeAndDate(), std::fstream::out);
    return fs;
}