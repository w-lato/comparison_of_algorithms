package mem;


public class NumericFFT {

//    private static void swap(double d1, double d2) {
//        double aux = d1;
//        d1 = d2;
//        d2 = d1;
//    }

    public static void four1(double[] data, long nn)
    {
        long n, mmax, m, j, istep, i;
        double wtemp, wr, wpr, wpi, wi, theta;
        double tempr, tempi , aux;

        // reverse-binary reindexing
        n = nn<<1;
        j=1;
        for (i=1; i<n; i+=2) {
            if (j>i) {
                //swap(data[(int)(j-1)], data[(int)(i-1)]);
                aux = data[(int)(j-1)];
                data[(int)(j-1)] = data[(int)(i-1)];
                data[(int)(i-1)] = aux;

                //swap(data[(int)j], data[(int)i]);
                aux = data[(int)j];
                data[(int)j] = data[(int)i];
                data[(int)i] = aux;
            }
            m = nn;
            while (m>=2 && j>m) {
                j -= m;
                m >>= 1;
            }
            j += m;
        };

        // here begins the Danielson-Lanczos section
        mmax=2;
        while (n>mmax) {
            istep = mmax<<1;
            theta = -(2* Math.PI/mmax);
            wtemp = Math.sin(0.5*theta);
            wpr = -2.0*wtemp*wtemp;
            wpi = Math.sin(theta);
            wr = 1.0;
            wi = 0.0;
            for (m=1; m < mmax; m += 2) {
                for (i=m; i <= n; i += istep) {
                    j=i+mmax;
                    tempr = wr*data[(int)j-1] - wi*data[(int)j];
                    tempi = wr * data[(int)j] + wi*data[(int)j-1];

                    data[(int)j-1] = data[(int)i-1] - tempr;
                    data[(int)j] = data[(int)i] - tempi;
                    data[(int)i-1] += tempr;
                    data[(int)i] += tempi;
                }
                wtemp=wr;
                wr += wr*wpr - wi*wpi;
                wi += wi*wpr + wtemp*wpi;
            }
            mmax=istep;
        }
    }

//    public static void main(String[] args) {
//
//        double d[] = DoubleTest.getDoubleValsForNumerciImpl();
//
////
//        System.out.println(d.length);
//        int size = (int)Math.pow(2,23);//8.388.608
//        double [] arr = d;
//        long l = System.currentTimeMillis();
//        four1(arr, size);
//        System.out.println("\tTIME: "+  (System.currentTimeMillis() - l));
//
//    }
}
