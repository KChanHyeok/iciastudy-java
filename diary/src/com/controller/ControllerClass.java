package com.controller;

import com.dto.DiaryInfo;
import com.view.InOutClass;

import java.io.File;
import java.util.Calendar;

public class ControllerClass {
    InOutClass io = new InOutClass();
    public void run() {
        int menu = -1;
        io.twoPrint("✨✨✨나만의 일기✨✨✨");

        File folder = new File("date");


        while (true) {
            menuShow();
            menu = io.inNum("입력> ");
            if (menu == 0) {
                io.twoPrint("일기장프로그램을 종료 합니다.");
                break;
            }
            switch (menu) {
                case 1:
                    inputData();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    io.twoPrint("0~5번까지 입력하세요");
                    break;
            }
        }
    }

    private void inputData() {
        io.twoPrint("✨✨✨나만의 일기 작성하기✨✨✨");
        io.twoPrint("===============================");
        DiaryInfo dInfo = new DiaryInfo();
        Calendar cal = Calendar.getInstance();

        dInfo.setTitle(io.inStr("제목 : "));
        dInfo.setContent(io.inStr("내용 : "));
        dInfo.setDate(cal.get(Calendar.YEAR)+""+(cal.get(Calendar.MONTH)+1)+""+(cal.get(Calendar.DATE)));


    }

    private void menuShow() {
        io.twoPrint("1. 일기저장");
        io.twoPrint("2. 일기읽기");
        io.twoPrint("3. 일기수정");
        io.twoPrint("4. 일기삭제");
        io.twoPrint("5. 일기검색");
        io.twoPrint("0. 종료");
    }
}
