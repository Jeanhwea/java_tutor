package io.github.jeanhwea.scratch;

import java.util.*;

public class Scratch05 {

  public static void main(String args[]) {
    TreeNode tree1 = TreeNode.makeTree(new int[] {1, 2, 3, 4, 5});
    TreeNode.display(tree1);
    TreeNode tree2 = TreeNode.makeTree(new int[] {1, 2, 3, -1, 4, 5, 6});
    TreeNode.display(tree2);
  }
}
