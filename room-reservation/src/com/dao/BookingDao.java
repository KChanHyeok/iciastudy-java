package com.dao;

import com.dto.BookingDto;

import java.net.ConnectException;
import java.sql.*;

public class BookingDao {
    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/testdb";
    private String user = "dev01";
    private String pass = "12341234";

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public BookingDao() {
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
    public BookingDto getBooking(String userId) {
        BookingDto bDto = null;

        String query = "SELECT * FROM booking WHERE m_id=?";

        try {
            conn = DriverManager.getConnection(url, user, pass);

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                bDto = new BookingDto();
                bDto.setB_no(rs.getInt(1));
                bDto.setM_id(rs.getString(2));
                bDto.setR_no(rs.getInt(3));
                bDto.setT_name(rs.getString(4));
                bDto.setB_start(rs.getString(5));
                bDto.setB_end(rs.getString(6));
            }
        } catch (SQLException e) {
            bDto = null;
        }finally {
            close();
        }
        return bDto;
    }


    public int updateBooking(BookingDto bDto) {
        int result = 0;

        String query = "UPDATE booking SET r_no = ?, t_name = ?, b_start = ?, b_end = ? "
                + "WHERE b_no=?";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, bDto.getR_no());
            pstmt.setString(2, bDto.getT_name());
            pstmt.setDate(3, Date.valueOf(bDto.getB_start()));
            pstmt.setDate(4, Date.valueOf(bDto.getB_end()));
            pstmt.setInt(5, bDto.getB_no());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            result = 0;
        }finally {
            close();
        }

        return result;
    }
}
