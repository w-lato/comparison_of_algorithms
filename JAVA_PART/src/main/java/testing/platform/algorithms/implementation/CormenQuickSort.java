package testing.platform.algorithms.implementation;

import testing.platform.data.source.preparation.MyQuickTest;

import static java.lang.Thread.sleep;

public class CormenQuickSort {
    public void sort( int[] arr, int low, int high){
        int pivotIndex = partition(arr,low,high);

        if (low < pivotIndex - 1)
            sort(arr,low,pivotIndex - 1);
        if (pivotIndex + 1 < high)
            sort(arr,pivotIndex + 1,high);
        return ;
    }

    private int partition( int[] arr, int left,int right)
    {
        int pivot = arr[left];
        while (left<right){
            while (arr[left]<pivot)
                left++;
            while (arr[right]>pivot)
                right--;
            if (left<right)
            {
                swap(arr,left,right);

                if (arr[left] == arr[right])
                    left++;
            }
        }
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //int[] x = MyQuickTest.prepareArr((int)Math.pow(2,14),"sorted");
        //int[] x = MyQuickTest.prepareArr((int)Math.pow(2,14),"reversed");
//        int[] x = MyQuickTest.prepareArr((int)Math.pow(2,14),"same");

        CormenQuickSort cqs = new CormenQuickSort();

//        int[] x = MyQuickTest.prepareArr((int)Math.pow(2,13),"random");
//
//        long s = System.nanoTime();
//        cqs.sort(x,0,x.length - 1);
//        System.out.println(System.nanoTime() - s);
//
//        x = MyQuickTest.prepareArr((int)Math.pow(2,13),"sorted");
//        s = System.nanoTime();
//        cqs.sort(x,0,x.length - 1);
//        System.out.println(System.nanoTime() - s);

        int arr[] = {111,2,3,4,5,6,7,3,4};
        cqs.sort(arr,0,8);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        try {
            long s = System.nanoTime();
            sleep(1000);
            System.out.println(System.nanoTime() - s);
        }catch(Exception ex) {

        }


//        CormenQuickSort.quickSort(x,0,x.length - 1);
//        for (int i = 0; i < x.length; i++) {
//            System.out.println(x[i]);
//        }
    }
}
