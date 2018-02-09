#include <iostream>
#include "FastFourierTransform1D.h"

int main() {
    FastFourierTransform1D fft = FastFourierTransform1D("FFT_",1);
    fft.startTimeTest();
    //std::cout << "Hello, World!" << std::endl;
    return 0;
}