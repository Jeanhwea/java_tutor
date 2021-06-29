package io.github.jeanhwea.leetcode.interview.ch08;

import java.util.*;

/**
 * 常数时间插入、删除和获取随机元素
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
@SuppressWarnings("all")
public class Solution380 {

  // 思路：通过一个哈希表和变长数组来处理
  public static class RandomizedSet {

    Map<Integer, Integer> dict;
    List<Integer> data;
    Random rand;

    public RandomizedSet() {
      dict = new HashMap<>();
      data = new ArrayList<>();
      rand = new Random();
    }

    public boolean insert(int val) {
      if (dict.containsKey(val)) return false;
      dict.put(val, data.size());
      data.add(data.size(), val);
      return true;
    }

    public boolean remove(int val) {
      if (!dict.containsKey(val)) return false;

      int idx = dict.get(val);
      int lastVal = data.get(data.size() - 1);
      data.set(idx, lastVal);
      dict.put(lastVal, idx);
      data.remove(data.size() - 1);
      dict.remove(val);
      return true;
    }

    public int getRandom() {
      return data.get(rand.nextInt(data.size()));
    }
  }

  public static void main(String[] args) {
    RandomizedSet randomSet = new RandomizedSet();
    randomSet.insert(1);
    randomSet.remove(2);
    randomSet.insert(2);
    randomSet.getRandom();
    randomSet.remove(1);
    randomSet.insert(2);
    randomSet.getRandom();
  }
}
