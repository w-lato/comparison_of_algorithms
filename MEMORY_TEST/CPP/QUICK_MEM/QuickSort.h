//
// Created by vm on 02.11.17.
//

#ifndef CPP_PART_QUICKSORT_H
#define CPP_PART_QUICKSORT_H
#define SWAP(x, y, T) do { T SWAP = x; x = y; y = SWAP; } while (0)

int partition(int *arr, int left, int right){
    int pivot = arr[left];
    while(left < right) {
        while (arr[left] < pivot) {
            left++;
        }
        while(arr[right] > pivot) {
            right--;
        }
        if(left < right) {

            SWAP(arr[left], arr[right], int );
            if(arr[left] == arr[right]) {
                left++;
            }
        }
    }
    return left;
}

void quick_sort(int *arr, int low, int high){
    int pivotIndex = partition(arr, low, high);
    if( low < pivotIndex - 1) {
        quick_sort(arr, low, pivotIndex - 1);
    }
    if(pivotIndex + 1 < high) {
        quick_sort(arr, pivotIndex + 1, high);
    }
}

#endif //CPP_PART_QUICKSORT_H
