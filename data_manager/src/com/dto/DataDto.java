package com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataDto { //Vo : Value Object
    private  int m_code;
    private  String m_str;
    private int m_int;
    private String m_date;

    @Override
    public String toString() {
        String str = "CODE : " + m_code + "\n"
                +"STR : " + m_str + "\n"
                +"INT : " + m_int + "\n"
                +"DATE : " + m_date +"\n";
        return str;
    }
}
