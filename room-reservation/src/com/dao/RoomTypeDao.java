package com.dao;

import com.dto.RoomType;

import java.sql.*;

public class RoomTypeDao {
    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/testdb";
    private String user = "dev01";
    private String pass = "12341234";

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public RoomTypeDao() {
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


    public RoomType getRoomType(String roomType) {
        RoomType rDto = null;

        String query = "SELECT * FROM roomtype WHERE t_name = ?";

        try {
            conn = DriverManager.getConnection(url, user, pass);

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, roomType);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rDto = new RoomType();
                rDto.setT_name(rs.getString(1));
                rDto.setT_bed(rs.getInt(2));
                rDto.setT_size(rs.getString(3));
                rDto.setT_hub(rs.getString(4));
                rDto.setT_price(rs.getInt(5));
                rDto.setT_parking(rs.getString(6));
                rDto.setT_maxnum(rs.getInt(7));
                rDto.setT_specialnote(rs.getString(8));
            }
        } catch (SQLException e) {
            rDto = null;
        } finally {
            close();
        }
        return rDto;
    }

    public int updateRoomType(RoomType rDto) {
        int result = 0;
        String query = "UPDATE roomtype SET t_price = ?, t_specialnote = ? "
                +"WHERE t_name = ?";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, rDto.getT_price());
            pstmt.setString(2, rDto.getT_specialnote());
            pstmt.setString(3, rDto.getT_name());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            result = 0;
        }finally {
            close();
        }

        return result;
    }
}
