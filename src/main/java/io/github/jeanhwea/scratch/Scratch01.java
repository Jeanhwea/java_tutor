package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 二分查找
 *
 * @author Jinghui Hu
 * @since 2021-06-06, JDK1.8
 */
public class Scratch01 {

  public static int bsearch(int[] a, int key) {
    int i = 0, j = a.length - 1;
    while (i <= j) {
      int k = i + (j - i) / 2;
      if (key > a[k]) i = k + 1;
      else if (key < a[k]) j = k - 1;
      else return k;
    }
    return -1;
  }

  public static void main(String args[]) {
    int[] a = {1, 2, 3, 4, 19, 33};
    System.out.println(bsearch(a, 3));
    System.out.println(bsearch(a, 1));
    System.out.println(bsearch(a, 9));
    System.out.println(bsearch(a, 19));
  }
}
