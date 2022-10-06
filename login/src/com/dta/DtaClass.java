package com.dta;

import com.dto.MemberDto;
import com.view.InOutClass;

import java.sql.*;

public class DtaClass {

    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/testdb";
    private String user = "dev01";
    private String pwd = "12341234";

    Connection cnn;
    InOutClass io = new InOutClass();

    PreparedStatement pstat;

    ResultSet rs;

    public DtaClass() {
        try {
            Class.forName(drv);
        } catch (ClassNotFoundException e) {
            io.twoPrint("드라이버로드 실패");
        }
    }

    private void close() {
        try {
            if (rs != null) rs.close();
            if (pstat != null) pstat.close();
            if (cnn != null) cnn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connetionTest() {
        try {
            cnn = DriverManager.getConnection(url, user, pwd);
            io.twoPrint("접속 성공");
        } catch (SQLException e) {
            e.printStackTrace();
            io.twoPrint("접속 실패");
        } finally {
            close();
        }
    }

    public String selectPwd(String m_id) {
        String dbpwd = null;
        try {
            cnn = DriverManager.getConnection(url, user, pwd);

            String query = "SELECT m_pwd FROM member " + "WHERE m_id = ?";

            pstat = cnn.prepareStatement(query);
            pstat.setString(1, m_id);

            rs = pstat.executeQuery();

            if (rs.next()) {
                dbpwd = rs.getString("m_pwd");
            }
        } catch (SQLException e) {
            io.twoPrint("접속 실패");
        }
        return dbpwd;
    }

    public String selectName(String m_id) {
        String dbname = null;
        try {
            cnn = DriverManager.getConnection(url, user, pwd);

            String query = "SELECT m_name FROM member " + "WHERE m_id = ?";

            pstat = cnn.prepareStatement(query);
            pstat.setString(1, m_id);

            rs = pstat.executeQuery();

            if (rs.next()) {
                dbname = rs.getString("m_name");
            }
        } catch (SQLException e) {
            io.twoPrint("접속 실패");
        }
        return dbname;
    }

    public void insetMember(MemberDto md) {
        try {
            cnn = DriverManager.getConnection(url, user, pwd);

            String query = "INSERT INTO member " + "VALUES (?, ?, ?, ?, ?, default, default)";

            pstat = cnn.prepareStatement(query);

            pstat.setString(1, md.getM_id());
            pstat.setString(2, md.getM_pwd());
            pstat.setString(3, md.getM_name());
            pstat.setInt(4, md.getM_age());
            pstat.setString(5, md.getM_job());

            int r = pstat.executeUpdate();

            if (r != 0) {
                io.twoPrint("입력 성공");
            }else {
                io.twoPrint("입력 실패");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
