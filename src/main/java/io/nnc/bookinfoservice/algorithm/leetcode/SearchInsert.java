package io.nnc.bookinfoservice.algorithm.leetcode;

public class SearchInsert {
  public int searchInsert(int[] nums, int target) {
    int n = nums.length;
    return binarySearchInsert(nums, target, 0, n - 1);
  }

  private int binarySearchInsert(int[] nums, int target, int l, int r) {
    if (l <= r) {
      int m = (l + r) / 2;
      if (nums[m] == target) return m;

      if (target > nums[m]) {
        return binarySearchInsert(nums, target, m + 1, r);
      } else {
        return binarySearchInsert(nums, target, l, m - 1);
      }
    }

    return l;
  }
}
