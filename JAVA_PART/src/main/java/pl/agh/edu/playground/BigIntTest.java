package pl.agh.edu.playground;

import java.math.BigInteger;

public class BigIntTest {
    public static void main(String[] args) {
        BigInteger bigInt = new BigInteger("1");
        for (int i = 1; i < 50000; i++) {
            bigInt = bigInt.multiply(BigInteger.valueOf(i));
            System.out.println(i + " : " + bigInt);
        }

    }
}
