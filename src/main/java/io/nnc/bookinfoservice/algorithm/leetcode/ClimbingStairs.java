package io.nnc.bookinfoservice.algorithm.leetcode;

public class ClimbingStairs {
  public int climbStairs(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return climbStairs(n - 1) + climbStairs(n - 2);
  }
}
