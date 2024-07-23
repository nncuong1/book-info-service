package io.nnc.bookinfoservice.algorithm.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
  public static String longestCommonPrefix(String[] v) {
    StringBuilder ans = new StringBuilder();
    Arrays.sort(v);
    String first = v[0];
    String last = v[v.length - 1];
    for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
      if (first.charAt(i) != last.charAt(i)) {
        return ans.toString();
      }
      ans.append(first.charAt(i));
    }
    return ans.toString();
  }

  public static String longestCommonPrefixV2(String[] strs) {
    String prefix = strs[0];
    for (int index = 1; index < strs.length; index++) {
      while (strs[index].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
      }
    }
    return prefix;
  }

  public static void main(String[] args) {
    String[] str = new String[] {"cook", "book", "look"};
    System.out.println(longestCommonPrefix(str));
  }
}
