package pl.agh.edu.playground;

import java.util.Comparator;

public class MyInteger implements Comparator<MyInteger> {

    Integer val;

    public MyInteger() {}

    public MyInteger(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public int compare(MyInteger o1, MyInteger o2) {
        if(o1.getVal() < o2.getVal())
            return -1;
        else if(o1.getVal() == o2.getVal())
            return 0;
        else
            return 1;
    }
}