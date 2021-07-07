package io.github.jeanhwea.leetcode.probset.ch01;

import java.util.*;

/**
 * 格雷编码
 *
 * @author Jinghui Hu
 * @since 2021-07-07, JDK1.8
 */
@SuppressWarnings("all")
public class Solution089 {

  public static List<Integer> grayCode(int n) {
    List<Integer> ans = new ArrayList<Integer>() {{add(0);}};

    int head = 1;
    for (int i = 0; i < n; i++) {
      for (int j = ans.size() - 1; j >= 0; j--) {
        ans.add(head + ans.get(j));
      }
      head <<= 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(grayCode(3));
  }
}
