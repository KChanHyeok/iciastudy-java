package home.dto;

import lombok.Data;

@Data
public class BookingDto {
    int b_no  ;
    String m_id;
    int r_no;

    String t_name;
    String b_start;
    String b_end;



    public String searchbook() {
        String str = "예약자 ID : " + m_id + "\n"
                + "방 번호 : " + r_no + "\n"
                + "방 타입 : " + t_name + "\n"
                + "예약 입실일 : " + b_start + "\n"
                + "예약 퇴실일 : " + b_end + "\n";
        return str;
    }//데이터의 출력 형식을 지정
}
