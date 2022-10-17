package home.dao;

import java.sql.*;

public class RoomDao {
  public String drv = "com.mysql.cj.jdbc.Driver";
  public String url = "jdbc:mysql://localhost:3306/bookingdb";
  public String user = "BookingConnection";
  public String pass = "0000";

  private Connection conn;
  private PreparedStatement pstmt;
  private ResultSet rs;

  public RoomDao() {
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

  //roomDao
  public String selectBr(int rNum) {
    String result = null;

    String query = "SELECT r_status FROM room WHERE r_no= ?";

    try {
      conn = DriverManager.getConnection(url, user, pass);
      pstmt = conn.prepareStatement(query);
      pstmt.setInt(1, rNum);

      rs = pstmt.executeQuery();
      if (rs.next()){
        result = rs.getString(1);
      }
    } catch (SQLException e) {
      result = null;
    }finally {
      close();
    }


    return result;
  }





}
