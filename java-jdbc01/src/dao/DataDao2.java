package dao;

import dto.MemberDto;

import java.sql.*;

public class DataDao2 {
    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/devdb";
    private String user = "dev01";
    private String pwd = "12341234";
    //접속 관리 객체 선언
    Connection conn; // 자동으로 null이 초기화 됨.
    //SQL 실행 객체
    Statement stmt;
    PreparedStatement pstmt;
    // 결합 객체 저장 객체
    ResultSet rs;

    // 드라이버 로드의 경우 최초 1번만 실행하면 됨.(생성자에서 처리)
    public DataDao2() {
        try {
            Class.forName(drv);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버로드 실패");
        }
    } // 생성자 end

    // 해체 전문 메소드 close(통로를 유지하려면 메모리가 소모된다)
    private void close() {
        try {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            //접속 관리 객체가 null이 아닌 경우에만 해제한다.
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // close end


    //접속 테스트 메소드
    public void connectionTest() {
        try {
            conn = DriverManager.getConnection(url, user, pwd);
            System.out.println("접속 성공");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("접속 실패");
        } finally {
            close(); // 해제 메소드 사용
        }
    }

    //비밀번호를 검색해 오는 메소드
    public String selectPwd(String m_id) {
        String dbpwd = null;

        try {
            //DB 접속
            conn = DriverManager.getConnection(url, user, pwd);
            // SQL 실행 객체 생성
            stmt = conn.createStatement();
            // SQL 쿼리문장을 작성
            String query = "SELECT m_pwd FROM member WHERE m_id = '"+m_id+ "'";
            // SELECT e_pwd FROM member WHERE m_id = '입력값'

            String query2 = "SELECT m_pwd FROM member "+"WHERE m_id = ?";
            //사용자의 입력값이 위치하는 곳에 '?'로 작성
            // ? 위치에 문자열일 경우 자동으로 ''를 붙여줌,
            // 숫자값일 경우 '' 없이 추가됨.

            pstmt = conn.prepareStatement(query2);
            pstmt.setString(1, m_id);
            //rs = stmt.executeQuery(query);
            rs = pstmt.executeQuery(); //select 작업용 메소드

            if(rs.next()) {
                //rs.next() : select 결과가 있을 경우 true, 없을 경우 false
                dbpwd = rs.getString("m_pwd");
                // getString(컬럼 순번 또는 컬럼명)
            }

        } catch (SQLException se) {
            System.out.println("접속 실패");
        }

        return dbpwd;
    }

    public void insetMember(MemberDto md) {
        try{
            conn = DriverManager.getConnection(url, user, pwd);

            // 미완성 쿼리문 작성
            String query = "INSERT INTO member "+
                    "VALUES (?, ?, ?, ?, ?, default, default)";
            //실행 객체 생성
            pstmt = conn.prepareStatement(query);
            // 미완성 부분 채워넣기
            pstmt.setString(1, md.getM_id());
            pstmt.setString(2, md.getM_pwd());
            pstmt.setString(3, md.getM_name());
            pstmt.setInt(4, md.getM_age());
            pstmt.setString(5, md.getM_job());
            
            int r = pstmt.executeUpdate();
            //insert, update, delete 작업은 모두 executeUpdate()로 실행
            //작업 실패 시 0을 반환한다.
            if(r != 0 ) {
                System.out.println("입력 성공");
            }else {
                System.out.println("입력 실패");
            }
        }catch (SQLException e) {
            System.out.println("DB 처리 실패");
        }
    }
} // class end
