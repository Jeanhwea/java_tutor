package io.github.jeanhwea.language.jdk.p01_string;

import java.text.MessageFormat;
import java.util.*;

/**
 * 字符串
 *
 * @author Jinghui Hu
 * @since 2021-07-26, JDK1.8
 */
@SuppressWarnings("all")
public class App {

  public static void test01() {
    // 字符串基本操作
    String str1 = "abcdef";
    str1.isEmpty();
    str1.length();
    str1.indexOf("c"); // => 2
    str1.substring(0, 3); // => "abc"

    // 合并字符串
    String str2 = "1,2,3,4";
    String[] res1 = str2.split(","); // => ["1", "2", "3", "4"]
    // 分割字符串
    List<String> res2 = Arrays.asList(res1);
    // res2.add("xxx"); // => throw UnsupportedOperationException
    List<String> res3 = new LinkedList<>(Arrays.asList(res1));
    res3.add("xxx"); // now is OK
    String str3 = String.join(":", res3); // => "1:2:3:4:xxx"

    // 正则表达式替换
    String str6 = "3 +5-4";
    str6 = str6.replaceAll("(\\+|-|\\*|/)", " $1 ").replaceAll("  ", " ").trim(); // => "3 + 5 - 4"
  }

  public static void test02() {
    String.format("Hi, %s", "Jack"); // => "Hi, Jack"
    MessageFormat.format("Hi, {0}, I''m {1} years old.", "Tom", 18);
    // => "Hi, Tom, I'm 18 years old."

    // 单引号表示字面量，MessageFormat 不会替换
    MessageFormat.format("'Hi, {0}, I''m {1} years old.'", "Tom", 18);
    // => "Hi, {0}, I'm {1} years old."

    // 处理数值类型的对象
    MessageFormat.format("{0,number,#}", 1889989898989L); // => "1889989898989"
    MessageFormat.format("{0}", 1889989898989L); // => "1,889,989,898,989"
    MessageFormat.format("{0,number,#000000}", 1889989898989L); // => "1889989898989"
    MessageFormat.format("{0,number,#000000}", 12345L); //  => "012345"
    MessageFormat.format("{0,number,#}", 12345L); // => "12345"
  }

  public static void test03() {
    StringBuilder sb = new StringBuilder(10);
    sb.append("Hello.."); // => "Hello.."
    sb.append("!"); // => "Hello..!"
    sb.insert(8, "Java"); // => "Hello..!Java"
    sb.delete(5, 8); // => "HelloJava"
    sb.reverse(); // => "avaJolleH"
    // System.out.println(sb.toString());
  }

  public static void main(String[] args) {
    test01();
    test02();
    test03();
  }
}
