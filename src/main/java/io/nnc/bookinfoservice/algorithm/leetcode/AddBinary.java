package io.nnc.bookinfoservice.algorithm.leetcode;


public class AddBinary {

  /**
   1+1=0 with carry 1
   0+1=1 with carry 0
   0+0=0 with carry 0
   1+0=1 with carry 0
  Imp:1+1=1 with carry 1 if previous carry was 1.
  The carry gets added in next step(scanning from right to left).**/
  public String addBinary(String a, String b) {

    int i = a.length() - 1;
    int j = a.length() - 1;
    int carry = 0;

    StringBuilder rs = new StringBuilder();
    while (i >= 0 || j >= 0 || carry == 1) {
      if (i >= 0) {
        carry += a.charAt(i--) - '0';
      }
      if (j >= 0) {
        carry += b.charAt(j--) - '0';
      }
      rs.append(carry % 2);
      carry /= 2;
    }

    return rs.reverse().toString();
  }
}
