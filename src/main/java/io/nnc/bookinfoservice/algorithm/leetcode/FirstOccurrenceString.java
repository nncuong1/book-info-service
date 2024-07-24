package io.nnc.bookinfoservice.algorithm.leetcode;

public class FirstOccurrenceString {
  public int strStrUsingSubstring(String haystack, String needle) {
    int m = haystack.length();
    int n = needle.length();

    if (m < n || n == 0) return -1;
    for (int i = 0; i < m - n + 1; i++) {
      String sb = haystack.substring(i, i + n);
      if (sb.equals(needle)) {
        return i;
      }
    }

    return -1;
  }

  public int strStrV2(String haystack, String needle) {
    int m = haystack.length();
    int n = needle.length();

    if (m < n || n == 0) return -1;
    for (int i = 0; i < m - n + 1; i++) {
      boolean match = true;

      for (int j = 0; j < n; j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          match = false;
          break;
        }
      }

      if (match) return i;
    }

    return -1;
  }

  public int strStrV3(String haystack, String needle) {
    int haylength = haystack.length();
    int needlelength = needle.length();
    if (haylength < needlelength) return -1;
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      int j = 0;
      while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) j++;
      if (j == needle.length()) {
        return i;
      }
    }
    return -1;
  }
}
