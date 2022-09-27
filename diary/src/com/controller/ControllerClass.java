package com.controller;

import com.view.InOutClass;

public class ControllerClass {

    InOutClass io = new InOutClass();

    public void run() {
        int menu = -1;
        io.twoPrint("✨✨✨나만의 일기✨✨✨");

        while (true) {
            menuShow();
            if (menu == 0) {
                io.twoPrint("일기장프로그램을 종료 합니다.");
                break;
            }
            switch (menu) {
                case 1:
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

    private void menuShow() {
        io.twoPrint("1. 일기저장");
        io.twoPrint("2. 일기읽기");
        io.twoPrint("3. 일기수정");
        io.twoPrint("4. 일기삭제");
        io.twoPrint("5. 일기검색");
        io.twoPrint("0. 종료");
        io.in
    }
}
