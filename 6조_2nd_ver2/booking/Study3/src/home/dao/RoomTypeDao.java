package home.dao;

import java.sql.*;

public class RoomTypeDao {
  public String drv = "com.mysql.cj.jdbc.Driver";
  public String url = "jdbc:mysql://localhost:3306/bookingdb";
  public String user = "BookingConnection";
  public String pass = "0000";

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

  //Roomtypedao
  public String selectRtype(String rType) {
    String result = null;

    String query = "SELECT * FROM roomtype WHERE t_name= ?";

    try {
      conn = DriverManager.getConnection(url, user, pass);
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, rType);

      rs = pstmt.executeQuery();
      if (rs.next()){
        result = rs.getString(1);
      }

    } catch (SQLException e) {
      result = null;
    }

    return result;
  }


}
