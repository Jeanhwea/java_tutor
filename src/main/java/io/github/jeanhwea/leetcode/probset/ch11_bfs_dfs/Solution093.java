package io.github.jeanhwea.leetcode.probset.ch11_bfs_dfs;

import java.util.*;

/**
 * 复原 IP 地址
 *
 * @author Jinghui Hu
 * @since 2021-08-29, JDK1.8
 */
@SuppressWarnings("all")
public class Solution093 {

  public static List<String> restoreIpAddresses(String str) {
    s = str;
    n = str.length();
    choose = new LinkedList<>();
    ans = new LinkedList<>();
    dfs(0);
    return ans;
  }

  private static int n;
  private static String s;
  private static List<String> choose;
  private static List<String> ans;

  private static void dfs(int k) {
    if (k == n && choose.size() == 4) {
      ans.add(String.join(".", choose));
      return;
    }
    if (choose.size() > 3) return;
    for (int len = 1; len <= 3; len++) {
      if (k + len > n) continue;
      String token = s.substring(k, k + len);
      if (len >= 2 && "0".equals(token.substring(0, 1))) continue;
      if (len >= 3 && "00".equals(token.substring(0, 2))) continue;
      if (Integer.parseInt(token) > 255) continue;
      choose.add(token);
      dfs(k + len);
      choose.remove(choose.size() - 1);
    }
  }

  public static void main(String[] args) {
    String str01 = "010010";
    System.out.println(restoreIpAddresses(str01));
    String str02 = "25525511135";
    System.out.println(restoreIpAddresses(str02));
  }
}
