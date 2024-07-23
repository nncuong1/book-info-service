package io.nnc.bookinfoservice.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[] {};
  }

  public static int[] twoSumV2(int[] nums, int target) {
    int n = nums.length;

    Map<Integer, Integer> numMaps = new HashMap<>();
    for (int i = 0; i < n; i++) {
      numMaps.put(nums[i], i);
    }

    for (int i = 0; i < n; i++) {
      int x = target - nums[i];
      if (numMaps.containsKey(x) && numMaps.get(x) != i) {
        return new int[] {i, numMaps.get(x)};
      }
    }
    return new int[] {};
  }

  public static void main(String[] args) {
    int[] t1 = new int[] {1, 1, 1, 1};
    System.out.println(Arrays.toString(twoSumV2(t1, 2)));
  }
}
