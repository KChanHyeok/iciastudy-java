package com.view;

import com.dto.BoardInfo;

public class BoardViewClass {
    InOutClass ioc = new InOutClass();

    public int firstShowMenu() {
        int menu = -1;
        ioc.twoPrint("<<board menu>>");
        ioc.twoPrint("---------------");
        ioc.twoPrint("1. 게시판 작성");
        ioc.twoPrint("2. 게시판 조회");
        ioc.twoPrint("3. 게시판 검색");
        ioc.twoPrint("4. 게시판 수정");
        ioc.twoPrint("5. 게시판 삭제");
        ioc.twoPrint("0. 종료하기");
        menu = ioc.inNum("선택>");
        return menu;
    }

    public void message(String str) {
        ioc.twoPrint(str);
    }

    public void subTitle(String str) {
        ioc.twoPrint("<"+str+">");
        ioc.twoPrint("-----------------");
    }

    public void inputBoard(BoardInfo bInfo) {
        subTitle("게시글 작성하기");
        bInfo.setB_name(ioc.inStr("작성자 : "));
        bInfo.setB_title(ioc.inStr("제목 : "));
        bInfo.setB_content(ioc.inStr("내용 : "));
    }
}
