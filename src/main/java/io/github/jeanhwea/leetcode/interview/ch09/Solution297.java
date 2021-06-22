package io.github.jeanhwea.leetcode.interview.ch09;

import java.util.*;

/**
 * 二叉树的序列化与反序列化
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
public class Solution297 {

  public static class Codec {

    private String serialize(TreeNode root, String ret) {
      if (root == null) {
        ret += "None,";
      } else {
        ret += root.val + ",";
        ret = serialize(root.left, ret);
        ret = serialize(root.right, ret);
      }
      return ret;
    }

    public TreeNode deserialize(List<String> list) {
      if (list.get(0).equals("None")) {
        list.remove(0);
        return null;
      }
      TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
      list.remove(0);
      node.left = deserialize(list);
      node.right = deserialize(list);
      return node;
    }

    public String serialize(TreeNode root) {
      return serialize(root, "");
    }

    public TreeNode deserialize(String data) {
      String[] strings = data.split(",");
      List<String> list = new ArrayList<>(Arrays.asList(strings));
      return deserialize(list);
    }
  }

  public static void main(String[] args) {
    TreeNode tree1 = TreeNode.makeTree(new int[] {1, 2, 3, 4, 5});
    Codec obj = new Codec();
    String res = obj.serialize(tree1);
    System.out.println(res);
    TreeNode tree2 = obj.deserialize(res);
    TreeNode.dispTree(tree2);
  }
}
