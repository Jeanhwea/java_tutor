package io.github.jeanhwea.leetcode.probset.ch01_array;

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
      int sumGas = 0, sumCost = 0, j = 0;
      while (j <= n) {
        int k = (i + j) % n;
        sumCost += cost[k];
        sumGas += gas[k];
        if (sumCost > sumGas) {
          break;
        }
        if (j == n) return i;
        j++;
      }
      i += j + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
    System.out.println(canCompleteCircuit(gas, cost));
  }
}
