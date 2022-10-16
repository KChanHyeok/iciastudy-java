package com.controller;

import com.dto.BookingDto;
import com.dto.RoomType;
import com.service.BookingService;
import com.service.MemberService;
import com.service.RoomTypeService;
import com.view.DataView;

public class ControllerClass {

    DataView dView = new DataView();
    MemberService dServ = new MemberService();

    BookingService bServ = new BookingService();

    RoomTypeService rServ = new RoomTypeService();
    final String passId = "admin";
    final String passPwd = "1234";

    public void run() {
        while (true) {
            int menu = -1;
            //String id = null;
            //int pass = 0;
            menu = dView.loginMenu();
            if (menu == 0) {
                dView.msgPrint("프로그램을 종료합니다.");
                break;
            }
            switch (menu) {
                case 1:
                    int res = login();
                    if (res == 0) {
                        dView.msgPrint("로그인 성공");
                        run2();
                        break;
                    } else {
                        dView.msgPrint("로그인 실패");
                        break;
                    }
                default:
                    dView.msgPrint("0~1사이의 숫자만 입력하시오");
                    break;
            }
        }
    } // run() end

    public void run2() {
        int menu = -1;
        while (true) {
            menu = dView.secondMenu();
            if (menu == 0) {
                dView.msgPrint("수정페이지를 나갑니다.");
                break;
            }
            switch (menu) {
                case 1:
                    bookingUpdate();
                    break;
                case 2:
                    roomTypeUpdate();
                    break;
                default:
                    dView.msgPrint("0에서 2까지의 숫자만 입력하세요");
                    break;
            }
        }

    }

    private void roomTypeUpdate() {
        String roomType = dView.search("수정할 RoomType을 입력하세요 : ");
        RoomType rDto = rServ.getRoomType(roomType);
        dView.outData(rDto);
        if(rDto != null) {
            String yn = dView.isupdate();
            if(yn.equals("y")) {
                dView.updateInput(rDto);

                String msg = rServ.updateInput(rDto);

                dView.msgPrint(msg);
            }
        }
    }

    private void bookingUpdate() {
        String name = dView.search("예약자이름 검색 : ");
        String phone = dView.search("예약자전화번호 검색 :");
        String userId = dServ.getMemberId(name, phone);
        BookingDto bDto = bServ.getBooking(userId);
        dView.outData(bDto);
        if (bDto != null) {
            String yn = dView.isupdate();
            if (yn.equals("y")) {
                dView.updateInput(bDto);

                String msg = bServ.updateBooking(bDto);

                dView.msgPrint(msg);
            }else {
                dView.msgPrint("수정을 취소합니다");
            }
        }
    }

    private int login() {
        String id = dView.inputLogin("ID : ");
        String pwd = dView.inputLogin("PWD : ");
        if (this.passId.equals(id) && this.passPwd.equals(pwd)) {
            return 0;
        } else {
            return 1;
        }

    }

}
