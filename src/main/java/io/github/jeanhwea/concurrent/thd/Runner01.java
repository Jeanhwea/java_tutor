package io.github.jeanhwea.concurrent.thd;

/**
 * ThreadLocal 类的方法
 *
 * @author Jinghui Hu
 * @since 2021-06-30, JDK1.8
 */
public class Runner01 {

  public static class Person01 {

    private static String name;

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  public static class Person02 {

    private static ThreadLocal<String> name = new ThreadLocal<>();

    public String getName() {
      return this.name.get();
    }

    public void setName(String name) {
      this.name.set(name);
    }

    // ThreadLocal 变量使用时需要注意的是需要显示的释放内存
    public void eraseName() {
      this.name.remove();
    }
  }

  public static void test01() {
    for (int i = 0; i < 5; i++) {
      Thread t =
          new Thread(
              () -> {
                try {
                  String threadName = Thread.currentThread().getName();
                  Person01 person01 = new Person01();
                  person01.setName(threadName);
                  Thread.sleep(500L);
                  System.out.printf(
                      "hash=%s,name=%s\n", person01.getName().hashCode(), person01.getName());
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              });
      t.start();
    }
  }

  public static void test02() {
    for (int i = 0; i < 5; i++) {
      Thread t =
          new Thread(
              () -> {
                try {
                  String threadName = Thread.currentThread().getName();
                  Person02 person02 = new Person02();
                  person02.setName(threadName);
                  Thread.sleep(500L);
                  System.out.printf(
                      "hash=%s,name=%s\n", person02.getName().hashCode(), person02.getName());
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              });
      t.start();
    }
  }

  public static void main(String[] args) {
    test01();
    test02();
  }
}
