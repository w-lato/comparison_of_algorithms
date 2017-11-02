package testing.platform;

import com.sun.istack.internal.NotNull;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

public abstract class Algorithm {

    public long timeDiff;
    protected final String filepath = "C:\\Users\\wlato\\Desktop\\TIME_TEST\\";
    protected String fileName;
    private int iterations;


    public String getFilepath() {
        return filepath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }


    public Algorithm() {
    }

    public Algorithm(String fileName, int iterations) {
        this.fileName = fileName;
        this.iterations = iterations;
    }

    public String getTimeAndDate() {
        Date now = Calendar.getInstance().getTime();
        return "_" + String.valueOf(now.getDay()) + String.valueOf(now.getMonth() +
                String.valueOf(now.getYear() % 2000) + "_" +
                String.valueOf(now.getHours()) + String.valueOf(now.getMinutes())
        );
    }

    public PrintWriter prepareFileWriter() {
        try {
            PrintWriter writer = new PrintWriter(filepath + fileName + getTimeAndDate() + ".txt", "UTF-8");
            return writer;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Every algorithm needs its own implementation to prepare input data
     */
    public abstract void prepareTestData();


    public abstract void startTimeTest();

}
