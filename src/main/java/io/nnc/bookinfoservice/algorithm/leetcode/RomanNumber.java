package io.nnc.bookinfoservice.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanNumber {
  public static int romanToInt(String s) {
    Map<String, Integer> romanMaps = createRomanMaps();
    int rs = 0;
    int n = s.length();
    boolean isNext = false;
    for (int i = 0; i < n; i++) {
      if (isNext) {
        isNext = false;
        continue;
      }

      String first = s.charAt(i) + "";
      String second = null;

      if (i != n - 1) {
        second = s.charAt(i + 1) + "";
      }
      Integer firstValue = romanMaps.get(first);
      Integer secondValue = romanMaps.get(second);

      if (secondValue != null && firstValue < secondValue) {
        rs += secondValue - firstValue;
        isNext = true;
      } else {
        rs += firstValue;
      }
    }

    return rs;
  }

  public static int romanToIntV2(String s) {
    int answer = 0, number = 0, prev = 0;

    for (int j = s.length() - 1; j >= 0; j--) {
      switch (s.charAt(j)) {
        case 'M' : number = 1000;
        case 'D' : number = 500;
        case 'C' : number = 100;
        case 'L' : number = 50;
        case 'X' : number = 10;
        case 'V' : number = 5;
        case 'I' : number = 1;
      }

      if (number < prev) {
        answer -= number;
      }
      else {
        answer += number;
      }
      prev = number;
    }
    return answer;
  }

  private static Map<String, Integer> createRomanMaps() {
    Map<String, Integer> maps = new HashMap<>();
    maps.put("I", 1);
    maps.put("V", 5);
    maps.put("X", 10);
    maps.put("L", 50);
    maps.put("C", 100);
    maps.put("D", 500);
    maps.put("M", 1000);
    return maps;
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("MCMXCIV"));
  }
}
