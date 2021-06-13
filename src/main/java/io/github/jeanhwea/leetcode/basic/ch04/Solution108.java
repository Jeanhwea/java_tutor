package io.github.jeanhwea.leetcode.basic.ch04;

import java.util.*;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution108 {

  public static TreeNode sortedArrayToBST(int[] a) {
    int n = a.length;
    if (n <= 0) return null;
    if (n <= 1) return new TreeNode(a[0]);

    int p = n / 2;
    TreeNode root = new TreeNode(a[p]);
    root.left = sortedArrayToBST(Arrays.copyOfRange(a, 0, p));
    root.right = sortedArrayToBST(Arrays.copyOfRange(a, p + 1, n));

    return root;
  }

  public static void main(String args[]) {
    int[] nums = {1, 2, 3, 4, 5};
    TreeNode tree1 = sortedArrayToBST(nums);
    TreeNode.display(tree1);
  }
}
