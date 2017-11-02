package testing.platform.algorithms.implementation;

import testing.platform.data.source.preparation.MyQuickTest;

public class CormenQuickSort {
    public void sort( int[] inputArray, int lo, int high){
        int pivotIndex = partition(inputArray,lo,high);
       // System. out .println("Got PivotIndex as " + pivotIndex);
        if (lo < pivotIndex -1)
            sort(inputArray,lo,pivotIndex - 1);
        if (pivotIndex+1 < high)
            sort(inputArray,pivotIndex+1,high);
        return ;
    }

    private int partition( int[] inputArray, int leftPtr,int rightPtr)
    {
        int pivot = inputArray[leftPtr];
        while (leftPtr<rightPtr){
            while (inputArray[leftPtr]<pivot)
                leftPtr++;
            while (inputArray[rightPtr]>pivot)
                rightPtr--;
            if (leftPtr<rightPtr)
            {
                exchange(inputArray,leftPtr,rightPtr);

                //Cases which have repeated numbers...
                if (inputArray[leftPtr] == inputArray[rightPtr])
                    leftPtr++;
            }
        }
        return leftPtr;//return any one
    }

    private void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //int[] x = MyQuickTest.prepareArr((int)Math.pow(2,14),"sorted");
        //int[] x = MyQuickTest.prepareArr((int)Math.pow(2,14),"reversed");
//        int[] x = MyQuickTest.prepareArr((int)Math.pow(2,14),"same");

        CormenQuickSort cqs = new CormenQuickSort();

        int[] x = MyQuickTest.prepareArr((int)Math.pow(2,13),"random");

        long s = System.nanoTime();
        cqs.sort(x,0,x.length - 1);
        System.out.println(System.nanoTime() - s);

        x = MyQuickTest.prepareArr((int)Math.pow(2,13),"sorted");
        s = System.nanoTime();
        cqs.sort(x,0,x.length - 1);
        System.out.println(System.nanoTime() - s);


//        CormenQuickSort.quickSort(x,0,x.length - 1);
//        for (int i = 0; i < x.length; i++) {
//            System.out.println(x[i]);
//        }
    }
}
