package io.nnc.bookinfoservice.algorithm.sort;

public class QuickSort implements Sort {
  @Override
  public void sort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);

      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];

    //the position of last element that is less than pivot
    int i = low - 1;

    for (int j = low; j <= high-1 ; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, high);
    return i + 1;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private void quickSortV2(int[] arr, int low, int high) {
    // Select the pivot.
    // Partition the subarray.
  }
}
