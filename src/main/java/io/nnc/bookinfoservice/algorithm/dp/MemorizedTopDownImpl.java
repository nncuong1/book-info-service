package io.nnc.bookinfoservice.algorithm.dp;

public class MemorizedTopDownImpl implements RodCutting {

  @Override
  public int cutRod(int[] prices, int n) {
    int[] mems = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      mems[i] = Integer.MIN_VALUE;
    }
    return memorizedCutRod(prices, mems, n);
  }

  private int memorizedCutRod(int[] prices, int[] mems, int n) {
    if (mems[n] >= 0) return mems[n];
    int q;
    if (n == 0) {
      q = 0;
    } else {
      q = Integer.MIN_VALUE;
      for (int i = 1; i <= n; i++) {
        q = Math.max(q, prices[i] + memorizedCutRod(prices, mems, n - i));
      }
    }
    mems[n] = q;
    return q;
  }
}
