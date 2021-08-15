package io.github.jeanhwea.leetcode.probset.ch05_tree;

import java.util.*;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author Jinghui Hu
 * @since 2021-08-15, JDK1.8
 */
@SuppressWarnings("all")
public class Solution108 {

  public static TreeNode sortedArrayToBST(int[] nums) {
    return createTree(nums, 0, nums.length - 1);
  }

  private static TreeNode createTree(int[] a, int beg, int end) {
    if (beg > end) return null;
    int mid = beg + (end - beg) / 2;
    TreeNode root = new TreeNode(a[mid]);
    root.left = createTree(a, beg, mid - 1);
    root.right = createTree(a, mid + 1, end);
    return root;
  }

  public static void main(String[] args) {
    int[] a = new int[] {-10, -3, 0, 5, 9};
  }
}
