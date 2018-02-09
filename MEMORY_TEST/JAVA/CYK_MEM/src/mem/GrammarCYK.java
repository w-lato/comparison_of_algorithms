package mem;


import mem.CYK.Grammar;
import mem.CYK.cyk;

import java.io.PrintWriter;

public class GrammarCYK extends Algorithm {

//    String grammarFilePath = "C:\\Users\\wlato\\IdeaProjects\\engineers_thesis\\JAVA_PART\\src\\main\\java\\test\\algorithms\\CYK\\anotherCYK\\old_cyk\\other\\grammars\\grammar5.txt";
//    String grammarFilePath = "C:\\Users\\wlato\\IdeaProjects\\engineers_thesis\\JAVA_PART\\src\\main\\java\\testing\\platform\\data\\source\\grammar5.txt";
    String grammarFilePath = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/grammar.txt";
    public GrammarCYK(String fileName, int iterations) {
        super(fileName, iterations);
    }

    @Override
    public void prepareTestData() {

    }

    /**
     * Text to its binary reprezentation
     *
     */
    @Override
    public void startTimeTest() {
        prepareTestData();
//        PrintWriter pw = this.prepareFileWriter();
        String[] args = new String[2];
        Grammar Grammar = new Grammar(grammarFilePath);
        //String input = "00010010000001110001010000010000"; //14 07 1410
//        String input = "00010010000001110001010000010000" +
//                "0001001000000111000101000001000000010010000001110001010000010000" +
//                "0001001000000111000101000001000000010010000001110001010000010000" +
//                "0001001000000111000101000001000000010010000001110001010000010000";//14 07 1410 x 7

            String input =   // Bitwa pod Grunwaldem: 14.07.1410
                    "0100001001101001011101000111011101100001001000000111000001101111011001000010000001000111011100100111010101101110011101110110000101101100011001000110010101101101001110100010000000110001001101000010111000110000001101110010111000110001001101000011000100110000";
//            byte[] arr = input.getBytes(StandardCharsets.UTF_8);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Integer.toBinaryString(arr[i]));
//        }

        System.out.println("\tData: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        for (int i = 0; i < this.getIterations(); i++) {

            long l = System.currentTimeMillis();
            timeDiff = System.nanoTime();
            boolean x = cyk.cyk(input, Grammar);

            System.out.println( System.currentTimeMillis() - l  + " " + x);
        }
    }

}
