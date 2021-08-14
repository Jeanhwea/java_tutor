package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 不同的二叉搜索树 II
 *
 * @author Jinghui Hu
 * @since 2021-08-14, JDK1.8
 */
@SuppressWarnings("all")
public class Solution095 {

  public static List<TreeNode> generateTrees(int n) {
    if (n == 0) return new LinkedList<>();
    return generateTrees(1, n);
  }

  public static List<TreeNode> generateTrees(int beg, int end) {
    List<TreeNode> ans = new LinkedList<>();
    if (beg > end) {
      ans.add(null);
      return ans;
    }
    for (int i = beg; i <= end; i++) {
      List<TreeNode> leftTrees = generateTrees(beg, i - 1);
      List<TreeNode> rightTrees = generateTrees(i + 1, end);
      for (TreeNode left : leftTrees) {
        for (TreeNode right : rightTrees) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          ans.add(root);
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    // pass
  }
}
