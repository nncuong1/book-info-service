package io.nnc.bookinfoservice.algorithm.leetcode;

public class RemoveElement {

  public int removeElement(int[] nums, int val) {
    // pointer of the position where the next non-target element should be placed
    int index = 0;
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      if (nums[i] != val) {
        nums[index] = nums[i];
        index++;
      }
    }

    return index;
  }
}
