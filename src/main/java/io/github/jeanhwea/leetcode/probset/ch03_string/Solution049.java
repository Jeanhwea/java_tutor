package io.github.jeanhwea.leetcode.probset.ch03_string;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author Jinghui Hu
 * @since 2021-09-05, JDK1.8
 */
@SuppressWarnings("all")
public class Solution049 {

  // 使用哈希表, 对异位词的键进行排序
  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      String key = String.valueOf(arr);
      if (!map.containsKey(key)) {
        List<String> res = new LinkedList<>();
        res.add(str);
        map.put(key, res);
      } else {
        map.get(key).add(str);
      }
    }
    return new LinkedList<>(map.values());
  }

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> ans = groupAnagrams(strs);
    System.out.println(ans);
  }
}
