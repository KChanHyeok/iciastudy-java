package com.dao;

import com.dto.BoardInfo;

import java.sql.*;

public class BoardDao {

    private String drv = "com.mysql.cj.jdbc.Driver";

    private String url = "jdbc:mysql://localhost:3306/board";

    private String user = "dev02";

    private String pass = "0524";

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public BoardDao() {
        try {
            Class.forName(drv);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
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

    public int insertBoard(BoardInfo bInfo) {
        int result = 0;

        String query = "INSERT INTO boardtbl VALUES (null, ?, now(), ?, ?)";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, bInfo.getB_title());
            pstmt.setString(2, bInfo.getB_name());
            pstmt.setString(3, bInfo.getB_content());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }
}
