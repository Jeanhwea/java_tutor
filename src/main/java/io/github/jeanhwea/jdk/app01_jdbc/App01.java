package io.github.jeanhwea.jdk.app01_jdbc;

import java.sql.*;

public class App01 {

  private static String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
  private static String username = "user01";
  private static String password = "user01";

  public static void test01() throws Exception {
    // 加载驱动
    Class.forName("com.mysql.jdbc.Driver");

    // 创建连接
    Connection conn = DriverManager.getConnection(url, username, password);

    // 发送 SQL 语句
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT 'Hello'");
    while (rs.next()) {
      // rs.getObject(1);
      String message = rs.getString(1);
      System.out.println(message);
    }

    // 关闭连接
    conn.close();
  }

  public static void main(String[] args) throws Exception {
    test01();
  }
}
