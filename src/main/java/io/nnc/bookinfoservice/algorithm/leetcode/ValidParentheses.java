package io.nnc.bookinfoservice.algorithm.leetcode;

import java.util.*;

public class ValidParentheses {
  public static boolean isValid(String s) {
    int n = s.length();

    Set<String> openBrackets = createSetOpenBrackets();
    Map<String, String> openCloseBracketPair = createMap();

    Stack<String> stacks = new Stack<>();
    for (int i = 0; i < n; i++) {
      String bracket = s.charAt(i)+"";

      if(openBrackets.contains(bracket)){
        stacks.push(bracket);
      } else {
        if(stacks.isEmpty()) return false;

        String openBracketInStack = stacks.pop();
        String openBracketInMap = openCloseBracketPair.get(bracket);
        if(!Objects.equals(openBracketInMap, openBracketInStack)) {
          return false;
        }
      }
    }

    return stacks.isEmpty();
  }

  private static Set<String> createSetOpenBrackets() {
    Set<String> openSets = new HashSet<>();
    openSets.add("(");
    openSets.add("{");
    openSets.add("[");
    return openSets;
  }

  private static Map<String, String> createMap() {
    Map<String, String> parenthesesMaps = new HashMap<>();
    parenthesesMaps.put(")","(");
    parenthesesMaps.put("}","{");
    parenthesesMaps.put("]","[");
    return parenthesesMaps;
  }
}
