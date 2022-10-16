package com.dto;

import lombok.Data;

@Data
public class BookingDto {
    int b_no;
    String m_id;
    int r_no;
    String t_name;
    String b_start;
    String b_end;

    public String toString() {
        String str = "예약 번호 : " + b_no + "\n"
                + "유저 아이디 : " + m_id + "\n"
                + "방(호) : " + r_no + "\n"
                + "방 등급 : " + t_name + "\n"
                + "예약 시작일 : " + b_start + "\n"
                + "예약 종료일 : " + b_end;
        return str;
    }
}
