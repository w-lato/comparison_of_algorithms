package main;

/**
 * Created by vm on 18.11.17.
 */
public class Main {

    public void memAlloc(int ctr) {
        if(ctr % 1000 == 0) {
            System.out.println(ctr + " : " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
            try {
                System.in.read();
            }catch( Exception ex) {
                ex.printStackTrace();
            }
        }
        byte x = 1;
        ctr++;
        memAlloc(ctr);
    }


    public static void main(String[] args) {
        Main m = new Main();
        m.memAlloc(0);

    }
}
