package io.nnc.bookinfoservice.algorithm.sort;


public class BubbleSort implements Sort {

  @Override
  public void sort(int[] arr) {
    int n = arr.length;
    // loop an array
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        // compare with the adjacent element
        if (arr[j] > arr[j + 1]) {
          // move larger element to the right
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
}
