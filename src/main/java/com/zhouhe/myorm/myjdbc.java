package com.zhouhe.myorm;

import java.sql.*;
import java.util.Properties;

public class myjdbc {
    private static final String url = "jdbc:mysql://192.168.12.242:3306/carzone_order";

    private static final String user = "carzone_order";

    private static final String password = "XghZKzyLdWwvH2LO";

    public static void main(String[] args) {
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("没有找到驱动");
        }

        Properties connProps = new Properties ();
        connProps.put ("user", user);
        connProps.put ("password", password);
        //2. 获取连接
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, connProps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3. 得到statement
        if (connection == null) {
            return;
        }

        Statement statement = null;
        try {
            statement  = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 4.执行
        ResultSet resultSet = null;
        try {
             resultSet = statement.executeQuery("select * from t_order limit 10");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    String string = resultSet.getString(1);
                    System.out.println(string);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
