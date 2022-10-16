package com.view;

import com.dto.BookingDto;
import com.dto.RoomType;

public class DataView {

    InOutClass ioc = new InOutClass();
    public int loginMenu() {
        int menu = -1;
        ioc.twoPrint("<< 예약자 관리 프로그램 로그인 >>");
        ioc.twoPrint("1. 로그인");
        ioc.twoPrint("0. 종료하기");
        menu = ioc.inNum("선택>");
        return menu;
    }

    public void msgPrint(String str) {
        ioc.twoPrint(str);
    }
    public String inputLogin(String str) {
        String login = ioc.inStr(str);
        return login;
    }

    public void subTitle(String str) {
        ioc.twoPrint("<"+str+">");
        ioc.twoPrint("-----------------");
    }
    public int secondMenu() {
        int menu = -1;
        subTitle("정보수정");
        ioc.twoPrint("1. 예약 정보 수정");
        ioc.twoPrint("2. 방타입 정보 수정");
        ioc.twoPrint("0. 수정 나가기");
        menu = ioc.inNum("선택>");
        return menu;
    }

    public String search(String str) {
        String s = null;
        s =ioc.inStr(str);

        return s;
    }

    public void updateInput(BookingDto bDto) {
        subTitle("수정");
        String str = null;
        int num = 0;
        num = ioc.inNum("변경할 방(호) : ");
        if(num != -1) {
            bDto.setR_no(num);
        }
        str = ioc.inStr("변경할 방등급 : ");
        if(!str.equals("")) {
            bDto.setT_name(str);
        }
        str = ioc.inStr("변경할 예약시작일자(yyyy-mm-dd) : ");
        if(!str.equals("")) {
            bDto.setB_start(str);
        }
        str = ioc.inStr("변경할 예약종료일자(yyyy-mm-dd) : ");
        if(!str.equals("")) {
            bDto.setB_end(str);
        }
    }

    public void outData(BookingDto bDto) {
        subTitle("검색한 데이터");
        if(bDto==null) {
            msgPrint("데이터가 없습니다");
            return;
        }
        ioc.twoPrint(bDto.toString());
        ioc.twoPrint("-----------------");
    }

    public String isupdate() {
        String yn = ioc.inStr("수정하시겠습니까?(y/n)");
        return yn;
    }

    public void outData(RoomType rDto) {
        subTitle("검색한 데이터");
        if(rDto==null) {
            msgPrint("데이터가 없습니다");
            return;
        }
        ioc.twoPrint(rDto.toString());
        ioc.twoPrint("-----------------");
    }

    public void updateInput(RoomType rDto) {
        subTitle("수정");
        String str=null;
        int num = -1;
        num = ioc.inNum("변경할 가격 : ");
        rDto.setT_price(num);
        str = ioc.inStr("특이사항 추가 : ");
        rDto.setT_specialnote(str);
    }
}
