package io.github.jeanhwea.leetcode.interview.ch14_endup;

/**
 * 加油站
 *
 * @author Jinghui Hu
 * @since 2021-06-27, JDK1.8
 */
@SuppressWarnings("all")
public class Solution134 {

  public static int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length, i = 0;
    while (i < n) {
      // 一次性统计可以跳过的区间段
      int sumGas = 0, sumCost = 0, count = 0;
      while (count < n) {
        int j = (i + count) % n;
        sumGas += gas[j];
        sumCost += cost[j];
        if (sumGas < sumCost) break;
        count++;
      }

      if (count == n) return i;
      else i += count + 1;
    }
    return -1;
  }

  public static int canCompleteCircuit0(int[] gas, int[] cost) {
    int n = gas.length;
    for (int i = 0; i < n; i++) {
      int s = 0;
      for (int j = 0; j < n; j++) {
        s += gas[(i + j) % n] - cost[(i + j) % n];
        if (s < 0) break;
      }
      if (s >= 0) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
    System.out.println(canCompleteCircuit(gas, cost));
  }
}
