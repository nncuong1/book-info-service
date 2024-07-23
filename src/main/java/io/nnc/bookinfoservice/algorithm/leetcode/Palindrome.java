package io.nnc.bookinfoservice.algorithm.leetcode;

public class Palindrome {
  public static boolean isPalindrome(int x) {
    String order = String.valueOf(x);
    String reverse = reverseString(order);
    return order.equals(reverse);
  }

  public static boolean isPalindromeV2(int x) {
    if (x < 0) {
      return false;
    }

    long revertedNumber = 0;
    long temp = x;

    while (temp != 0) {
      revertedNumber = revertedNumber*10 + temp % 10;
      temp /= 10;
    }

    return x == revertedNumber;
  }

  public static boolean isPalindromeV3(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }

    return x == revertedNumber || x == revertedNumber / 10;
  }

  private static String reverseString(String order) {
    char ch;
    StringBuilder str = new StringBuilder();
    for(int i = 0; i< order.length();i++) {
      ch=order.charAt(i);
      str.insert(0, ch);
    }
    return str.toString();
  }

  public static void main(String[] args) {
    System.out.println(isPalindromeV2(12321));
  }
}
