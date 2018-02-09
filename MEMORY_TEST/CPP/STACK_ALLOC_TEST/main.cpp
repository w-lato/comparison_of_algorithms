#include <iostream>


/**
 *  The alloca() function allocates size bytes of space in the stack
 *     frame of the caller.  This temporary space is automatically freed
 *     when the function that called alloca() returns to its caller.
 *
 *
 * @param nDataSize - size in bytes whic will be allocated on Stack
 * @param iterations
 * @return
 */
int foo( int nDataSize, int iterations )
{
   for ( int i = 0; i < iterations ; ++i )
   {
//      char *bytes = alloca( nDataSize );
       alloca( nDataSize );
       std::cout << i << " : Allocated " << nDataSize << " bytes on stack." << std::endl;
      // char x = std::cin.get();
      // if(x == 'x') return 1;
      // the memory above IS NOT FREED when we pass the brace below!
   }
   return 0;
}  // alloca() memory only gets freed here

int main() {
    std::cout << "Hello, World!" << std::endl;
    foo(1048576, 10); // 1 Megabyte
    return 0;
}