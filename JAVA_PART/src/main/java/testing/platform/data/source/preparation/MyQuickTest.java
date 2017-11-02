package testing.platform.data.source.preparation;

import testing.platform.SortDataType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

import static testing.platform.SortDataType.*;

public class MyQuickTest {

    static double x = Math.pow(2, 14) + 1;


    public static void anotherWorst(int[] arr) {
        int pivot =  + (arr.length)/2;

        int max = 214748364;

        int j = 0;
        for (int i = pivot; i >= 0; i--) {
            arr[i] = max - j;
            j++;
        }

        j = 1;
        for (int i = arr.length - 1; i > pivot ; i--) {
            arr[i] = max - j;
            j++;
        }
    }


    private static void splitAndSetMax(int[] arr, int low, int high, int max) {
        if(Math.abs(high - low) == 1) {
            if(max > (2147483647 / 2)) {
                arr[low] = max;
                arr[high] = max + 1;
            } else {
                arr[low] = max - 2;
                arr[high] = max - 1;
            }
            return;
        }
        int pivot = low + (high-low)/2;
        arr[pivot] = max;

        if((pivot - 1) >= 0)
            splitAndSetMax(arr,low,pivot - 1,max - 1);
        if((pivot + 1 <= high))
            splitAndSetMax(arr,pivot + 1,high,max + 1);
    }

    public static void prepareWorst(int[] arr) {


        int max = 2147483647 / 2; // int max
        int low = 0;
        int high = arr.length - 1;
        // Get the pivot element from the middle of the list
        int pivot = low + (high-low)/2;
        arr[pivot] = max;

        splitAndSetMax(arr,0,high, max);
    }

    public static int[] prepareArr(int len, String type) {


        int[] arr = new int[len];
        if(type.equals("same") || type.equals("same start with biggest")) {
            Arrays.fill(arr, 1);
            if(type.equals("same start with biggest")) {
                arr[0] = 99999;
            }
            return arr;
        }

        if(type.equals("worst")) {
            //prepareWorst(arr);
            anotherWorst(arr);
            return arr;
        }

        Random gen = new Random();

        for (int i = 0; i < len; i++) {
            arr[i] = gen.nextInt();
        }
        if(type.equals("random") ) {
            return arr;
        } else {
            Integer[] a2 = new Integer[len];
            for (int i = 0; i < len; i++) {
                a2[i] = arr[i];
            }

            if(type.equals("reversed")) {
                Arrays.sort(a2, Collections.reverseOrder()); // OR
            } else {
                Arrays.sort(a2); // OR
            }
            for (int i = 0; i < len; i++) {
                arr[i] = a2[i];
            }
            return arr;
        }
    }

//    public static int[] testWorst(String type) {
//        int[] arr = prepareArr( (int) x, type);
//        QuickSort qs = new QuickSort();
//
//        long s= System.currentTimeMillis();
//        qs.sort(arr);
//        System.out.println("WorstSorted " + type + ": " + (System.currentTimeMillis() - s));
//        return arr;
//    }


    public static void prepareSortDataFiles(String path, int size, SortDataType type) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            if(type == SAME) {
                for (int k = 0; k < size; k++) {
                    writer.write(1 + "\r\n");
                }
                writer.close();
                return;
            }

            Random r = new Random();
            if(type == RANDOM) {
                for (int k = 0; k < size; k++) {
                    writer.write(r.nextInt() + "\r\n");
                }
                writer.close();
                return;
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    arr.add(r.nextInt());
                }
                arr.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                });
                if(type == SORTED_ASC) {
                    for (int i = 0; i < arr.size(); i++) {
                        writer.write(arr.get(i) + "\r\n");
                    }
                } else { // SORTED_DESC
                    for (int i = arr.size() - 1; i >= 0; i--) {
                        writer.write(arr.get(i) + "\r\n");
                    }
                }
                writer.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\SORT_DATA\\";
        int n = (int)Math.pow(2,13);

//        MyQuickTest.prepareSortDataFiles(path + "random.txt", n, RANDOM);
//        MyQuickTest.prepareSortDataFiles(path + "same.txt", n, SAME);
//        MyQuickTest.prepareSortDataFiles(path + "sortedAsc.txt", n, SORTED_ASC);
//        MyQuickTest.prepareSortDataFiles(path + "sortedDesc.txt", n, SORTED_DESC);
//

        path = "C:\\Users\\wlato\\Desktop\\praca_inzynierska\\MERGE_SORT_DATA\\";
        n = (int)Math.pow(2,23);
        MyQuickTest.prepareSortDataFiles(path + "random.txt", n, RANDOM);
        MyQuickTest.prepareSortDataFiles(path + "same.txt", n, SAME);
        MyQuickTest.prepareSortDataFiles(path + "sortedAsc.txt", n, SORTED_ASC);
        MyQuickTest.prepareSortDataFiles(path + "sortedDesc.txt", n, SORTED_DESC);


//        System.out.println(Math.pow(2,14));
//        System.out.println((int)(9/2));
//
//        int[] xd = new int[9];
//        MyQuickTest.prepareWorst(xd);
//
//        for (int i = 0; i < xd.length; i++) {
//            System.out.println(i + " :  " + xd[i]);
//        }
//        int [] arr = MyQuickTest.testWorst("worst");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//        MyQuickTest.testWorst("sorted");
//        MyQuickTest.testWorst("same");
//        MyQuickTest.testWorst("same maxPivot");
//        MyQuickTest.testWorst("same start with biggest");
//        MyQuickTest.testWorst("reversed");
//        MyQuickTest.testWorst("random");
    }

}
