package io.nnc.bookinfoservice.algorithm.leetcode;

public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] tempM = new int[m];
    for (int i = 0; i < m; i++) {
      tempM[i] = nums1[i];
    }

    int i = 0;
    int j = 0;
    int t = 0;
    while (i < m && j < n) {
      if (tempM[i] <= nums2[j]) {
        nums1[t++] = tempM[i++];
      } else {
        nums1[t++] = nums2[j++];
      }
    }

    while (i < m) {
      nums1[t++] = tempM[i++];
    }

    while (j < n) {
      nums1[t++] = nums2[j++];
    }
  }

  public void mergeFromLeft(int[] nums1, int m, int[] nums2, int n) {
    int index = nums1.length - 1;
    int i = m - 1;
    int j = n - 1;

    while (i >= 0 && j >= 0) {
      if (nums1[i] <= nums2[j]) {
        nums1[index--] = nums2[j--];
      } else {
        nums1[index--] = nums1[i--];
      }
    }
    while (j >= 0) {
      nums1[index--] = nums2[j--];
    }
  }
}
