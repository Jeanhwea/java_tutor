package io.github.jeanhwea.language.jvm.p21_javap;

/**
 * 线程栈
 *
 * @author Jinghui Hu
 * @since 2021-07-03, JDK1.8
 */
@SuppressWarnings("all")
public class App {

  private static final int FINAL_VAR01 = 2;
  private String name = "hello";

  public int method01() {
    int a = 1;
    int b = 2;
    int c = (a + b) / 5;
    return c;
  }

  public static void main(String[] args) {
    App example = new App();
    example.method01();
  }
}

////////////////////////////////////////////////////////////////////////////////
//  $ javac App.java
//  $ javap -c App.class
////////////////////////////////////////////////////////////////////////////////
//
// public class io.github.jeanhwea.language.jvm.p21_javap.App {
//   public io.github.jeanhwea.language.jvm.p21_javap.App();
//     Code:
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: aload_0
//        5: ldc           #2                  // String hello
//        7: putfield      #3                  // Field name:Ljava/lang/String;
//       10: return
//
//   public int method01();
//     Code:
//        0: iconst_1
//        1: istore_1
//        2: iconst_2
//        3: istore_2
//        4: iload_1
//        5: iload_2
//        6: iadd
//        7: iconst_5
//        8: idiv
//        9: istore_3
//       10: iload_3
//       11: ireturn
//
//   public static void main(java.lang.String[]);
//     Code:
//        0: new           #4                  // class io/github/jeanhwea/language/jvm/p21_javap/App
//        3: dup
//        4: invokespecial #5                  // Method "<init>":()V
//        7: astore_1
//        8: aload_1
//        9: invokevirtual #6                  // Method method01:()I
//       12: pop
//       13: return
// }
//
////////////////////////////////////////////////////////////////////////////////
