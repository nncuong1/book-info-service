package io.nnc.bookinfoservice.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> results = new ArrayList<>();
    results.add(List.of(1));
    if (numRows == 1) return results;

    results.add(List.of(1, 1));
    if (numRows == 2) return results;

    while (numRows > 2) {
      int n = results.size();
      List<Integer> last = results.get(n - 1);

      List<Integer> news = new ArrayList<>();
      news.add(1);
      for (int i = 0; i < last.size() - 1; i++) {
        news.add(last.get(i) + last.get(i + 1));
      }

      news.add(1);

      results.add(news);

      numRows--;
    }

    return results;
  }

  public List<List<Integer>> generateByTwoPointer(int numRows) {
    List<List<Integer>> results = new ArrayList<>();
    results.add(List.of(1));

    for (int i = 0; i < numRows - 1; i++) {
      List<Integer> last = results.get(results.size() - 1);

      List<Integer> temps = new ArrayList<>();
      temps.add(0);
      temps.addAll(last);
      temps.add(0);

      int lengthOfLast = last.size();
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < lengthOfLast + 1; j++) {
        row.add(temps.get(j) + temps.get(j + 1));
      }

      results.add(row);
    }

    return results;
  }
}
