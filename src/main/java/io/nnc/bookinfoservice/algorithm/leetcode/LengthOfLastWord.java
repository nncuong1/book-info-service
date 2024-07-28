package io.nnc.bookinfoservice.algorithm.leetcode;

public class LengthOfLastWord {

  public int lengthOfLastWord(String s) {
    int n = s.length();
    int j = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) != ' ' && j == 0) {
        j = i;
      }
      if (s.charAt(i) == ' ' && j != 0) {
        return j-i;
      }
    }

    return j+1;
  }
}
