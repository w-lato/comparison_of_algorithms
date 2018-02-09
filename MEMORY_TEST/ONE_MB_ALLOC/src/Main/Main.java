package Main;

import java.util.Scanner;

/**
 * Created by vm on 04.11.17.
 */
public class Main {
    public static void main(String[] args) {
//        while(true) {
//            byte[] arr = new byte[1000000]; // approx 1MB
//        }
        System.out.println("start");
//        Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od użytkownika
//        odczyt.nextLine();
        System.out.println( Runtime.getRuntime().totalMemory() );
        System.out.println( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() );
        for (int i = 0; i < 700; i++) {
//            try {
//               // Thread.sleep(300);
//            } catch (Exception e) {
//               // e.printStackTrace();
//            }

            byte[] arr = new byte[1000000];
        }
        System.out.println( Runtime.getRuntime().totalMemory() );
        System.out.println( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() );

    }
}
