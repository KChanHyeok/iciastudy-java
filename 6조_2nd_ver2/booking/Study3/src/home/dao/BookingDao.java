package home.dao;

import home.dto.BookingDto;

import java.sql.*;

public class BookingDao {
  public String drv = "com.mysql.cj.jdbc.Driver";
  public String url = "jdbc:mysql://localhost:3306/bookingdb";
  public String user = "BookingConnection";
  public String pass = "0000";

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



  public String selectId(String bookingId) {
    String BookId = null;

    String query = "SELECT * FROM booking WHERE m_id = ?";

    try {
      conn = DriverManager.getConnection(url, user, pass);
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, bookingId);

      rs = pstmt.executeQuery();
      if (rs.next()){
        BookId = rs.getString(1);
      }

    } catch (SQLException e) {
      BookId = null;
    } finally {
      close();
    }

    return BookId;

  }
  public int insertData(BookingDto bDto) {
    int result = 0;

    String query = "INSERT INTO booking VALUES "
      + "(null, ?, ?, ?, ?, ?)";

    try {
      conn = DriverManager.getConnection(url, user, pass);
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, bDto.getM_id());
      pstmt.setInt(2, bDto.getR_no());
      pstmt.setString(3, bDto.getT_name());
      pstmt.setDate(4, Date.valueOf(bDto.getB_start()));
      pstmt.setDate(5, Date.valueOf(bDto.getB_end()));

      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      result = 0;
    }
    return result;
  }
  public int deleteData(String id) {
    int result = 0;

    String query = "DELETE FROM booking WHERE m_id = ?";

    try {
      conn = DriverManager.getConnection(url, user, pass);
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, id);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      result = 0;
    }finally {
      close();
    }
    return result;
  }
  public BookingDto selectData(String id) {
    BookingDto data = null;

    String query = "SELECT * FROM booking WHERE m_id = ?";

    try {
      conn = DriverManager.getConnection(url, user, pass);

      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();

      if (rs.next()){
        data = new BookingDto();
        data.setM_id(rs.getString("m_id"));
        data.setR_no(rs.getInt(3));
        data.setT_name(rs.getString("t_name"));
        data.setB_start(rs.getString(5));
        data.setB_end(rs.getString(6));
      }

    } catch (SQLException e) {
      //e.printStackTrace();
    } finally {
      close();
    }


    return data;
  }




}
