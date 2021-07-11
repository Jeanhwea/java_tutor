package io.github.jeanhwea.leetcode.probset.ch03;

/**
 * 有效数字
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution065 {

  private static int S0 = 0; // 初始
  private static int S1 = 1; // 符号
  private static int S2 = 5; // 整数部分
  private static int S3 = 6; // 小数点（小数点前有数字）
  private static int S4 = 2; // 小数点（小数点前无数字）
  private static int S5 = 7; // 小数部分
  private static int S6 = 3; // 指数标记符 E
  private static int S7 = 4; // 指数符号
  private static int S8 = 8; // 指数数字
  private static int S9 = 9; // 完成匹配

  public static boolean isNumber(String s) {
    int state = S0;
    int i = 0, n = s.length();
    while (i < n) {
      char ch = s.charAt(i++);
      if (state == S0) {
        if (ch == '+' || ch == '-') state = S1;
        else if (ch == '.') state = S4;
        else if (Character.isDigit(ch)) state = S2;
        else return false;
      } else if (state == S1) {
        if (Character.isDigit(ch)) state = S2;
        else if (ch == '.') state = S4;
        else return false;
      } else if (state == S2) {
        if (Character.isDigit(ch)) state = S2;
        else if (ch == '.') state = S3;
        else if (ch == 'e' || ch == 'E') state = S6;
        else return false;
      } else if (state == S3) {
        if (Character.isDigit(ch)) state = S5;
        else if (ch == 'e' || ch == 'E') state = S6;
        else return false;
      } else if (state == S4) {
        if (Character.isDigit(ch)) state = S5;
        else return false;
      } else if (state == S5) {
        if (Character.isDigit(ch)) state = S5;
        else if (ch == 'e' || ch == 'E') state = S6;
        else return false;
      } else if (state == S6) {
        if (ch == '+' || ch == '-') state = S7;
        else if (Character.isDigit(ch)) state = S8;
        else return false;
      } else if (state == S7) {
        if (Character.isDigit(ch)) state = S8;
        else return false;
      } else if (state == S8) {
        if (Character.isDigit(ch)) state = S8;
        else return false;
      } else {
        return false;
      }
    }
    // 结束，最终状态
    state = state > 4 ? S9 : state;
    return state == S9;
  }

  public static void main(String[] args) {
    // System.out.println(isNumber(".e1"));
    System.out.println(isNumber("+.8"));
  }
}
