package io.github.jeanhwea.leetcode.interview.ch02_warmup;

import java.util.*;

/**
 * 鸡蛋掉落
 *
 * @author Jinghui Hu
 * @since 2021-06-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution877 {

  public static int superEggDrop(int k, int n) {
    // Right now, dp[i] represents dp(1, i)
    int[] dp = new int[n + 1];
    for (int i = 0; i <= n; ++i) {
      dp[i] = i;
    }

    for (int j = 2; j <= k; ++j) {
      // Now, we will develop dp2[i] = dp(j, i)
      int[] dp2 = new int[n + 1];
      int x = 1;
      for (int m = 1; m <= n; ++m) {
        // Let's find dp2[m] = dp(j, m)
        // Increase our optimal x while we can make our answer better.
        // Notice max(dp[x-1], dp2[m-x]) > max(dp[x], dp2[m-x-1])
        // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
        while (x < m && Math.max(dp[x - 1], dp2[m - x]) > Math.max(dp[x], dp2[m - x - 1])) {
          x++;
        }

        // The final answer happens at this x.
        dp2[m] = 1 + Math.max(dp[x - 1], dp2[m - x]);
      }

      dp = dp2;
    }

    return dp[n];
  }

  public static int superEggDrop1(int k, int n) {
    // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少实验的次数
    // 注意：
    // 1、i 表示的是楼层的大小，不是第几层的意思，例如楼层区间 [8, 9, 10] 的大小为 3，这一点是在状态转移的过程中调整的定义
    // 2、j 表示可以使用的鸡蛋的个数，它是约束条件，我个人习惯放在后面的维度，表示消除后效性的意思

    // 0 个楼层和 0 个鸡蛋的情况都需要算上去，虽然没有实际的意义，但是作为递推的起点，被其它状态值所参考
    int[][] dp = new int[n + 1][k + 1];

    // 由于求的是最小值，因此初始化的时候赋值为一个较大的数，9999 或者 i 都可以
    for (int i = 0; i <= n; i++) Arrays.fill(dp[i], i);

    // 初始化：填写下标为 0、1 的行和下标为 0、1 的列
    // 第 0 行：楼层为 0 的时候，不管鸡蛋个数多少，都测试不出鸡蛋的 F 值，故全为 0
    for (int j = 0; j <= k; j++) dp[0][j] = 0;

    // 第 1 行：楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次，1 个以及 1 个鸡蛋以上只需要扔 1 次
    dp[1][0] = 0;
    for (int j = 1; j <= k; j++) dp[1][j] = 1;

    // 第 0 列：鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0
    // 第 1 列：鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，最少次数就等于楼层高度（想想复杂度的定义）
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 0;
      dp[i][1] = i;
    }

    // 从第 2 行，第 2 列开始填表
    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= k; j++) {
        for (int s = 1; s <= i; s++) {
          // 碎了，就需要往低层继续扔：层数少 1 ，鸡蛋也少 1
          // 不碎，就需要往高层继续扔：层数是当前层到最高层的距离差，鸡蛋数量不少
          // 两种情况都做了一次尝试，所以加 1
          dp[i][j] = Math.min(dp[i][j], Math.max(dp[s - 1][j - 1], dp[i - s][j]) + 1);
        }
      }
    }
    return dp[n][k];
  }

  public static void main(String[] args) {
    System.out.println(superEggDrop(3, 8));
  }
}
