//package pl.agh.edu.playground;
//
//import jedi.example.QuickSort;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Random;
//
//public class TimeMeasurementTest {
//
//    private static long startTime;
//    private static long duration;
//
//    public long getDuration() {
//        return duration / 1000000;
////        return TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
//    }
//
//    public List<MyInteger> quickSortTest(List<MyInteger> unsortedList) {
//        QuickSort qs = new QuickSort();
//        Comparator<MyInteger> comp = new MyInteger();
//
//        startTime = System.nanoTime();
//        List<MyInteger> sortedList = qs.sort(unsortedList, comp);
//        duration = System.nanoTime() - startTime;
//
//        return sortedList;
//    }
//
//    public static void main(String[] args) {
//        List<MyInteger> testList = new ArrayList<MyInteger>();
//        Random gen = new Random();
//
//        System.out.println("UNSORTED LIST: ");
//        for (int i = 0; i < 10000000 ; i++) {
//            testList.add(new MyInteger(gen.nextInt()));
//          //  System.out.println(i + " : " + testList.get(i).getVal());
//        }
//
//        System.out.println("Sorting started at: " + System.currentTimeMillis());
//
//        TimeMeasurementTest testPlatform = new TimeMeasurementTest();
//
//        testList = testPlatform.quickSortTest(testList);
//
////        System.out.println("SORTED LIST: ");
////        for (int i = 0; i < 10000000 ; i++) {
////            System.out.println(i + " : " + testList.get(i).getVal());
////        }
//
//        long s = testPlatform.getDuration();
//        System.out.println("Duration: " + s / 1000 + " s " + s % 1000 + " ms");
// //       System.out.println("Duration: " + s);
////        System.out.println("solution Time : " + new DecimalFormat("#.##########").format(seconds) + " Seconds");
////        System.out.println(DurationFormatUtils.formatDuration(s, "**H:mm:ss**", true));
//////        long s = testPlatform.getDuration();
//        //System.out.println(String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60)));
//
//    }
//}
