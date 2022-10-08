package com.dao;

import com.dto.DiaryInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiaryDao {

    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/diarydb";
    private String user = "dev02";
    private String pass = "0524";

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public DiaryDao() {
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

    public int insertDiary(DiaryInfo dInfo) {
        int result = 0;

        String query = "INSERT INTO diarytbl VALUES (null, ?, now(), ?, ?)";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, dInfo.getD_name());
            pstmt.setString(2, dInfo.getD_title());
            pstmt.setString(3, dInfo.getD_content());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            result = 0;
        } finally {
            close();
        }
        return result;
    }


    public List<DiaryInfo> selectList() {
        List<DiaryInfo> dList = null;

        String query = "SELECT * FROM diarytbl";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (dList == null) {
                    dList = new ArrayList<>();
                }

                DiaryInfo dInfo = new DiaryInfo();

                dInfo.setD_no(rs.getInt(1));
                dInfo.setD_name(rs.getString(2));
                dInfo.setD_date(rs.getString(3));
                dInfo.setD_title(rs.getString(4));
                dInfo.setD_content(rs.getString(5));

                dList.add(dInfo);
            }

        } catch (SQLException e) {
            dList = null;
        } finally {
            close();
        }
        return dList;
    }
}
