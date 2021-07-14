package io.github.jeanhwea.leetcode.probset.ch05;

import java.util.*;

/**
 * 恢复二叉搜索树
 *
 * @author Jinghui Hu
 * @since 2021-07-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution099 {

  // Morris 遍历
  public static void recoverTree(TreeNode root) {
    TreeNode x = null, y = null, pred = null, curr = null;

    while (root != null) {
      if (root.left != null) {
        // curr 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
        curr = root.left;
        while (curr.right != null && curr.right != root) curr = curr.right;

        // 让 curr 的右指针指向 root，继续遍历左子树
        if (curr.right == null) {
          curr.right = root;
          root = root.left;
        } else { // 说明左子树已经访问完了，我们需要断开链接
          if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) x = pred;
          }
          pred = root;

          curr.right = null;
          root = root.right;
        }
      } else { // 如果没有左孩子，则直接访问右孩子
        if (pred != null && root.val < pred.val) {
          y = root;
          if (x == null) x = pred;
        }
        pred = root;

        root = root.right;
      }
    }
    swap(x, y);
  }

  public static void swap(TreeNode x, TreeNode y) {
    int tmp = x.val;
    x.val = y.val;
    y.val = tmp;
  }

  public static void recoverTree0(TreeNode root) {
    if (root == null) return;
    TreeNode x = null, y = null;

    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode p = root;
    while (p != null || !stack.isEmpty()) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      if (x != null && p.val < x.val) break;
      x = p;
      p = p.right;
    }

    stack.clear();
    p = root;
    while (p != null || !stack.isEmpty()) {
      while (p != null) {
        stack.push(p);
        p = p.right;
      }
      p = stack.pop();
      if (y != null && p.val > y.val) break;
      y = p;
      p = p.left;
    }

    swap(x, y);
  }

  public static void main(String[] args) {
    TreeNode tree01 = TreeNode.makeTree(new int[] {1, -1, 3, -1, -1, -1, 2});
    TreeNode.dispTree(tree01);
    recoverTree(tree01);
    TreeNode.dispTree(tree01);
  }
}
