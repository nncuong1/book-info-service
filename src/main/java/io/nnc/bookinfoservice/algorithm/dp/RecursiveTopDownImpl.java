package io.nnc.bookinfoservice.algorithm.dp;

public class RecursiveTopDownImpl implements RodCutting {
  @Override
  public int cutRod(int[] prices, int n) {
    if (n == 0) return 0;
    int q = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      q = Math.max(q, prices[i] + cutRod(prices, n - i));
    }
    return q;
  }

}
