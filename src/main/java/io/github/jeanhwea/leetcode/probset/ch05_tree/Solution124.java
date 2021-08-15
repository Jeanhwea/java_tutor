package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 二叉树中的最大路径和
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution124 {

  // 后序遍历, 计算左右子树的贡献值
  public static int maxPathSum(TreeNode root) {
    int ans = Integer.MIN_VALUE;
    if (root == null) return ans;
    Map<TreeNode, Integer> maxSum = new HashMap<>();
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode prev = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.peek();
      if (root.right == prev || root.right == null) {
        // 左子树贡献值
        int leftGain = Math.max(maxSum.getOrDefault(root.left, 0), 0);
        // 右子树贡献值
        int rightGain = Math.max(maxSum.getOrDefault(root.right, 0), 0);
        // 缓存中只能记单侧子树
        maxSum.put(root, Math.max(leftGain, rightGain) + root.val);
        // 选取最大路径可以选用双侧子树
        ans = Math.max(ans, leftGain + rightGain + root.val);
        prev = stack.pop();
        root = null;
      } else {
        root = root.right;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    //
  }
}
