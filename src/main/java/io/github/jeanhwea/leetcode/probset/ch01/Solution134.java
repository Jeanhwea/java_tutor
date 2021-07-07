package io.github.jeanhwea.leetcode.probset.ch01;

import java.util.*;

/**
 * 加油站
 *
 * @author Jinghui Hu
 * @since 2021-07-07, JDK1.8
 */
@SuppressWarnings("all")
public class Solution134 {

  public static int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;

    int i = 0;
    while (i < n) {
      int sumGas = 0, sumCost = 0;
      for (int j = 0; j < n; j++) {
        int k = (i + j) % n;
        sumGas += gas[k];
        sumCost += cost[k];
        if (sumGas >= sumCost) continue;

      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
    System.out.println(canCompleteCircuit(gas, cost));
  }
}
