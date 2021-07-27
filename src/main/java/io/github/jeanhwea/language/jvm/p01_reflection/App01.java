package io.github.jeanhwea.language.jvm.p01_reflection;

import java.lang.reflect.*;
import java.util.*;

/**
 * 反射
 *
 * @author Jinghui Hu
 * @since 2021-07-27, JDK1.8
 */
@SuppressWarnings("all")
public class App01 {

  public static void main(String[] args) throws Exception {
    // 获取 Class 类
    Class<?> clz = Class.forName("io.github.jeanhwea.language.jvm.p01_reflection.beans.Person");

    // 获取类的构造器
    Constructor<?> ctor = clz.getConstructor();
    // 新建对象
    Object obj = ctor.newInstance();

    // 获取定义的字段
    Field field = clz.getDeclaredField("name");
    field.setAccessible(true); // private 修饰的字段需要配置可见性
    // 设置字段值
    field.set(obj, "Injected Person Name");

    // 获取类的方法
    Method method = clz.getMethod("getName");
    // 调用方法
    String name = (String) method.invoke(obj);
    System.out.println(name);
  }
}
