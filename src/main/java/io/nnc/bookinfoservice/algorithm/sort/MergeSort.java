package io.nnc.bookinfoservice.algorithm.sort;

public class MergeSort implements Sort {

  @Override
  public void sort(int[] arr) {
    int l = arr.length;
    splitAndMerge(arr, 0, l - 1);
  }

  private void splitAndMerge(int[] arr, int l, int r) {
    // Split the selected array (as evenly as possible)
    if (l < r) {
      int m = (l + r) / 2;
      splitAndMerge(arr, l, m);
      splitAndMerge(arr, m + 1, r);
      // An array of length 1 cannot be split, ready for merge
      merge(arr, l, m, r);
    }
  }

  private void merge(int[] arr, int l, int m, int r) {
    // 1 Create two array L-R
      // 1.1 Calc array size
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] L = new int[n1];
    int[] R = new int[n2];
      // 1.2 copy data to L-R array
    for (int i = 0; i < n1; i++) {
      L[i] = arr[l+i];
    }
    for (int j = 0; j < n2; j++) {
      R[j] = arr[m+1+j];
    }

    // 2 Merge selected arrays back together, in sorted order
    int i = 0, j = 0;
    // first index of new sorted array
    int k = l;
      //2.1 Select the minimum of the two values
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        // 2.2 Add the selected value to the sorted array
        arr[k] = L[i];
        i++;
      } else {
        // 2.2 Add the selected value to the sorted array
        arr[k] = R[j];
        j++;
      }
      k++;
    }
      //2.3 When one list becomes empty, copy all values from the remaining array into the sorted array
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }
}
