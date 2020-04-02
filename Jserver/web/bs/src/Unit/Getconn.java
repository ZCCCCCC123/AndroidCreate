package Unit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Getconn {
    private static Connection conn = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(conn == null){
            // 第一步加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 第二步生成链接URL
            String url = "jdbc:mysql://localhost:3306/test1?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8";

            // 第三步获得链接
            conn = DriverManager.getConnection(url, "root", "123456");
        }
        return conn;
    }
    public static void closeConnection() throws SQLException{
        if(conn != null){
            conn.close();
            conn = null;
        }
    }
}
