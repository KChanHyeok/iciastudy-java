package com.dao;

import java.sql.*;

public class MemberDao {
    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/testdb";
    private String user = "dev01";
    private String pass = "12341234";

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public MemberDao() {
        try {
            Class.forName(drv);
        } catch (ClassNotFoundException e) {

        }
    }

    private void close() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {

        }
    }


    public String selectMemberId(String name, String phone) {
        String userid = null;

        String query = "SELECT * FROM member WHERE m_name= ? AND m_phone= ? ";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, phone);

            rs = pstmt.executeQuery();
            if(rs.next()) {
                userid = rs.getString(1);
            }

        } catch (SQLException e) {
            userid = null;
        } finally {
            close();
        }
        return userid;
    }
}
