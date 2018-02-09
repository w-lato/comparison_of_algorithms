package mem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HashBloomFilter extends Algorithm {

//    String path = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\list_of_urls.txt";
   // String path = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\merged_urls.txt";
    String path = "/home/vm/Desktop/ENGINEERS_REPO/engineers_thesis/DATA/urls.txt";
    ArrayList<String> urls;
    ArrayList<String> str_list;


    public HashBloomFilter(String fileName, int iterations) {
        super(fileName, iterations);
    }


    @Override
    public void prepareTestData() {
        BufferedReader br;
        try {
            str_list = new ArrayList<>();
            urls = new ArrayList<>();
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            int ctr = 1;
            while (line != null) {
                urls.add(line);
                line = br.readLine();
                if(ctr % 100 == 0)
                    str_list.add(line);
                ctr++;
            }
            br.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void startTimeTest() {
        prepareTestData();
//        PrintWriter pw = this.prepareFileWriter();
        BloomFilter<String> bf = new BloomFilter(000.1, urls.size());
        for (int i = 0; i < urls.size(); i++) {
            bf.add(urls.get(i));
        }
        System.out.println(urls.size());

        System.out.println("\t\t Data: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        for (int i = 0; i < this.getIterations(); i++) {

            long l = System.currentTimeMillis();
            timeDiff = System.nanoTime();
            for (int j = 0; j < str_list.size(); j++) {
                boolean x = bf.contains(str_list.get(j));
//                if(x)
//                    System.out.println(str_list.get(j));
                //System.out.println( );
            }
//            pw.println( System.nanoTime() - timeDiff );
//            pw.flush();
            System.out.println(i + " " + (System.currentTimeMillis() - l) );
        }
//        pw.close();
    }

    public static void main(String[] args) {
        HashBloomFilter hsb = new HashBloomFilter("BLOOM",10000);
        hsb.startTimeTest();
    }
}
