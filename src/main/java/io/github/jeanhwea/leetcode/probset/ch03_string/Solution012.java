package io.github.jeanhwea.leetcode.probset.ch03_string;

import java.util.*;

/**
 * 整数转罗马数字
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution012 {

  private static Map<Integer, String> map =
      new HashMap<Integer, String>() {
        {
          put(1, "I");
          put(5, "V");
          put(10, "X");
          put(50, "L");
          put(100, "C");
          put(500, "D");
          put(1000, "M");
          put(4, "IV");
          put(9, "IX");
          put(40, "XL");
          put(90, "XC");
          put(400, "CD");
          put(900, "CM");
        }
      };

  public static String intToRoman(int num) {
    List<Integer> bases = new ArrayList<>(map.keySet());
    Collections.sort(bases);
    System.out.println(bases);

    StringBuilder sb = new StringBuilder();
    int i = bases.size() - 1;
    while (num > 0) {
      int base = bases.get(i--);
      int count = num / base;
      for (int j = 0; j < count; j++) {
        sb.append(map.get(base));
      }
      num -= base * count;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(intToRoman(58));
  }
}
