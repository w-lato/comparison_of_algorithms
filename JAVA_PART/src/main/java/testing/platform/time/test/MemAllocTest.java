package testing.platform.time.test;

import pl.agh.edu.playground.TestObject;
import testing.platform.Algorithm;

import java.io.PrintWriter;

/**
 * Created by vm on 17.11.17.
 */
public class MemAllocTest extends Algorithm {


    public MemAllocTest(String fileName, int iter) {
        super(fileName, iter);
    }

    @Override
    public void prepareTestData() {

    }

    @Override
    public void startTimeTest() {

        PrintWriter pw = this.prepareFileWriter();
        TestObject to = new TestObject();
        to.cleanList();

        for (int i = 0; i < this.getIterations(); i++) {
            to.getList().clear();
            to.initList();

            timeDiff = System.nanoTime();

            for (int j = 0; j < 10; j++) {
                to.cleanList();
            }

            pw.println( System.nanoTime() - timeDiff );
            pw.flush();
            System.out.println(i);
        }

        pw.close();

    }

    public static void main(String[] args) {
        MemAllocTest mem = new MemAllocTest("ads", 100000);
        mem.startTimeTest();
    }
}
