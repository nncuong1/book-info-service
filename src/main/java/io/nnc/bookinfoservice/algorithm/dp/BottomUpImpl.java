package io.nnc.bookinfoservice.algorithm.dp;

public class BottomUpImpl implements RodCutting {
  @Override
  public int cutRod(int[] prices, int n) {
    int[] mems = new int[n + 1];
    mems[0] = 0;

    for (int j = 1; j <= n; j++) {
      int q = Integer.MIN_VALUE;
      for (int i = 1; i <= j; i++) {
        q = Math.max(q, prices[i] + mems[j - i]);
      }
      mems[j] = q;
    }
    return mems[n];
  }
}
