package io.github.jeanhwea.leetcode.probset.ch13_misc;

import java.util.*;

/**
 * 文本左右对齐
 *
 * @author Jinghui Hu
 * @since 2021-09-04, JDK1.8
 */
@SuppressWarnings("all")
public class Solution068 {

  // 贪心算法
  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> lineWords = new LinkedList<>();
    int i = 0, j = 0, wordsCount = 0, wordsLen = 0;
    while (i < words.length) {
      int lineEnd = wordsCount > 0 ? wordsLen + wordsCount + words[i].length() : words[i].length();
      if (lineEnd > maxWidth) {
        // System.out.printf("wordsLen=%d, wordsCount=%d\n", wordsLen, wordsCount);
        if (wordsCount > 1) {
          int spaceCount = maxWidth - wordsLen;
          int a = spaceCount / (wordsCount - 1);
          int b = spaceCount % (wordsCount - 1);
          StringBuffer line = new StringBuffer();
          StringBuffer blank = new StringBuffer();
          for (int s = 0; s < a; s++) blank.append(' ');
          int k = 0;
          while (j < i) {
            line.append(words[j++]);
            if (j < i) line.append(blank);
            if (k++ < b) line.append(' ');
          }
          lineWords.add(line.toString());
        } else {
          StringBuffer line = new StringBuffer();
          line.append(words[j++]);
          while (line.length() < maxWidth) line.append(' ');
          lineWords.add(line.toString());
        }
        wordsCount = 0;
        wordsLen = 0;
      } else {
        wordsCount++;
        wordsLen += words[i++].length();
      }
    }
    if (j < i) {
      StringBuffer line = new StringBuffer();
      while (j < words.length) {
        line.append(words[j++]);
        if (j < words.length) line.append(' ');
      }
      while (line.length() < maxWidth) line.append(' ');
      lineWords.add(line.toString());
    }
    return lineWords;
  }

  public static void main(String[] args) {
    String[] words = new String[] {"What", "must", "be", "acknowledgment", "shall", "be"};
    // String[] words = new String[] {"Listen", "to", "many,", "speak", "to", "a", "few."};
    for (String line : fullJustify(words, 16)) {
      System.out.println(line);
    }
  }
}
