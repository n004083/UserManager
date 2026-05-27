package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbconn {
    // MySQL 8.0+ 驱动
    private static String driver = "com.mysql.cj.jdbc.Driver";
    // 数据库路径（必须加时区）
    private static String url = "jdbc:mysql://localhost:3306/userdb?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    // 你的MySQL账号密码
    private static String user = "root";
    private static String pwd = "Nhd20040803"; // 改成你自己的密码

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 补上Model.java需要的closeAll方法
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}