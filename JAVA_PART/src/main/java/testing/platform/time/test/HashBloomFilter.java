package testing.platform.time.test;

import testing.platform.algorithms.implementation.BloomFilter;
import testing.platform.Algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HashBloomFilter extends Algorithm {

//    String path = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\list_of_urls.txt";
    String path = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\merged_urls.txt";
    ArrayList<String> urls;

    public HashBloomFilter(String fileName, int iterations) {
        super(fileName, iterations);
    }


    @Override
    public void prepareTestData() {
        BufferedReader br;
        try {
            urls = new ArrayList<>();
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (line != null) {
                urls.add(line);
                line = br.readLine();
            }
            br.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void startTimeTest() {
        prepareTestData();
        PrintWriter pw = this.prepareFileWriter();
        long timeDiff;
        BloomFilter<String> bf = new BloomFilter(000.1, urls.size());
        System.out.println(urls.size());
        for (int i = 0; i < urls.size(); i++) {
            bf.add(urls.get(i));
        }
        String[] args = {
                "http://www.agh.edu.pl/",
                "http://upel.agh.edu.pl/",
                "http://ai.ia.agh.edu.pl/wiki/pl:dydaktyka:unix:start#wyklady",
                "http://www.bg.agh.edu.pl/",
                "http://www.onet.pl/",
                "http://www.wp.pl/",
                "http://www.interia.pl/",
                "http://www.rp.pl/",
                "http://www.tvp.pl/",
                "http://www.tvn24.pl/",
                "http://www.pcworld.pl/",
                "http://www.otomoto.pl/",
                "http://www.otodom.pl/",
                "http://www.librus.pl/"
        };

        for (int i = 0; i < this.getIterations(); i++) {

            long l = System.currentTimeMillis();
            timeDiff = System.nanoTime();
            for (int j = 0; j < args.length; j++) {
                System.out.println( bf.contains(args[j]) );
            }
            pw.println( System.nanoTime() - timeDiff );
            System.out.println( System.currentTimeMillis() - l );
        }
        pw.close();
    }

    public static void main(String[] args) {
        HashBloomFilter hsb = new HashBloomFilter("BLOOM",1);
        hsb.startTimeTest();
    }
}
