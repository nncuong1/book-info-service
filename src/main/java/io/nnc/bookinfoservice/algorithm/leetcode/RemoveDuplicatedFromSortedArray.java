package io.nnc.bookinfoservice.algorithm.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RemoveDuplicatedFromSortedArray {

  public int removeDuplicates(int[] nums) {
    Set<Integer> setNums = new HashSet<>();
    Queue<Integer> integerQueue = new LinkedList<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      boolean successAdd = setNums.add(nums[i]);
      if (successAdd) {
        integerQueue.add(nums[i]);
      }
      nums[i] = -101;
    }

    int i = 0;
    while (!integerQueue.isEmpty()) {
      nums[i] = integerQueue.poll();
      i++;
    }

    return setNums.size();
  }

  public int removeDuplicatesV2(int [] nums) {
    int j = 1;
    int n = nums.length;
    for (int i = 1 ; i < n ;i++) {
      if(nums[i] != nums[i-1]) {
        nums[j] = nums[i];
        j++;
      }
    }
    return j;
  }
}
