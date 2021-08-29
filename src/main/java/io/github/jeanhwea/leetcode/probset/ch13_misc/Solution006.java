package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * Z 字形变换
 *
 * @author Jinghui Hu
 * @since 2021-08-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution006 {

  // 按行模拟
  public static String convert(String s, int numRows) {
    if (numRows < 2) return s;
    List<StringBuffer> rows = new ArrayList<>();
    for (int i = 0; i < numRows; i++) rows.add(new StringBuffer());
    // Step 1: 模拟填充
    int n = s.length(), down = 1;
    for (int i = 0; i < n; i++) {
      int x = i % (numRows - 1);
      int y = down > 0 ? x : numRows - x - 1;
      rows.get(y).append(s.charAt(i));
      if (x == numRows - 2) down = -down;
    }
    // Step 2: 收集结果
    StringBuffer sb = new StringBuffer();
    for (StringBuffer row : rows) sb.append(row.toString());
    return sb.toString();
  }

  public static void main(String[] args) {
    String str = "PAYPALISHIRING";
    System.out.println(convert(str, 3));
  }
}
