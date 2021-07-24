package io.github.jeanhwea.leetcode.interview.ch11_dp;

/**
 * 至少有 K 个重复字符的最长子串
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution395 {

  public static int longestSubstring(String s, int k) {
    return dfs(s, 0, s.length() - 1, k);
  }

  public static int dfs(String str, int beg, int end, int k) {
    char[] count = new char[26];
    for (int i = beg; i <= end; i++) {
      count[str.charAt(i) - 'a'] += 1;
    }

    char split = 0;
    for (int i = 0; i < 26; i++) {
      if (count[i] > 0 && count[i] < k) {
        split = (char) (i + 'a');
      }
    }
    if (split == 0) return end - beg + 1;

    int ans = 0, j = beg;
    while (j <= end) {
      while (j <= end && str.charAt(j) == split) j++;
      if (j > end) break;
      int start = j;
      while (j <= end && str.charAt(j) != split) j++;
      int len = dfs(str, start, j - 1, k);
      ans = Math.max(ans, len);
    }

    return ans;
  }

  public static void main(String[] args) {
    String s = "ababbc";
    int k = 2;
    System.out.println(longestSubstring(s, k));
  }
}
