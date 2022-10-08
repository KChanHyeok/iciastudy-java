package com.view;

import com.dto.DiaryInfo;

public class DiaryView {
    InOutClass ioc = new InOutClass();

    public int firstShowMenu() {
        int menu = -1;
        ioc.twoPrint("<<MY DIARY>>");
        ioc.twoPrint("------------");
        ioc.twoPrint("1. 일기장 작성하기");
        ioc.twoPrint("2. 일기장 조회하기");
        ioc.twoPrint("3. 일기장 검색하기");
        ioc.twoPrint("4. 일기장 수정하기");
        ioc.twoPrint("5. 일기장 삭제하기");
        ioc.twoPrint("0. 종료하기");
        menu = ioc.inNum("선택>");
        return menu;
    }
    public void message(String str){
        ioc.twoPrint(str);
    }

    public void subtitle(String str) {
        ioc.twoPrint("<"+str+">");
        ioc.twoPrint("---------");
    }

    public void inputDiary(DiaryInfo dInfo) {
        subtitle("My Diary Write");
        dInfo.setD_name(ioc.inStr("작성자 : "));
        dInfo.setD_title(ioc.inStr("제목 : "));
        dInfo.setD_content(ioc.inStr("내용 : "));
    }
}
