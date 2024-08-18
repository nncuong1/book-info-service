package io.nnc.bookinfoservice.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

  public List<Integer> generate(int rowIndex) {
    List<Integer> row = new ArrayList<>();

    // Start with the first row [1]
    row.add(1);

    // Build each row until reaching rowIndex
    for (int i = 1; i <= rowIndex; i++) {
      // Add a new element at the end
      row.add(0);
      // Update the elements from the back to the front
      for (int j = i; j > 0; j--) {
        row.set(j, row.get(j) + row.get(j - 1));
      }
    }

    return row;
  }
}
