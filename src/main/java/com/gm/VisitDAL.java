package com.gm;

import java.sql.*;

public class VisitDAL {

    private static Connection getConn() {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://10.10.10.101:1433;databaseName=safehelper";
        String username = "sa";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn =  DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public int getVisitCount()
    {
        Connection conn = getConn();
        int i = 0;
        String sql = "select top 1 visit_count from sf_count ";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);

            ResultSet result= pstmt.executeQuery();
            result.next();
            i=result.getInt(1);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;

    }

    public  static int insertDayRecord(int count) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into sf_day_count (day,count) values(?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            java.sql.Date date1 = new java.sql.Date(new java.util.Date().getTime());
            pstmt.setDate(1,date1);
            pstmt.setInt(2, count);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
