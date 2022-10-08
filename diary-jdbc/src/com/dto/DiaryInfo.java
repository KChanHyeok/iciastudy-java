package com.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryInfo {
    private int d_no;
    private String d_date;
    private String d_name;
    private String d_title;
    private String d_content;

    @Override
    public String toString() {
        String str = "작성일자 [" + d_date + "]" + "\n"
                + "작성자 : " + d_name + " \n"
                + "제목 : " + d_title + "\n"
                + "내용 : " + d_content;
        return str;
    }
}

