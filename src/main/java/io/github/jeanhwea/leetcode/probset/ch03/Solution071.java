package io.github.jeanhwea.leetcode.probset.ch03;

import java.util.*;

/**
 * 简化路径
 *
 * @author Jinghui Hu
 * @since 2021-07-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution071 {

  public static String simplifyPath(String path) {
    Deque<String> stack = new LinkedList<>();
    String[] dirs = path.split("/");
    for (String d : dirs) {
      if (".".equals(d) || "".equals(d)) {
        // do nothing
      } else if ("..".equals(d)) {
        if (!stack.isEmpty()) stack.pop();
      } else {
        stack.push(d);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
      sb.insert(0, '/');
    }
    return sb.length() == 0 ? "/" : sb.toString();
  }

  public static void main(String[] args) {
    // String p = "/home/./foo";
    String p = "/a/./b/../../c/";
    System.out.println(simplifyPath(p));
  }
}
