package home.view;

import home.dto.BookingDto;

public class DataView {

    private InOutClass ioc = new InOutClass();
    public int showMenu() {
        int m = -1;


        ioc.twoPrint("==예약==");
        ioc.twoPrint("============");

        ioc.twoPrint("1. 예약 입력");
        ioc.twoPrint("2. 예약 삭제");
        ioc.twoPrint("0. 돌아가기");

        m = ioc.inNum("입력해주세요. >");

        return m;
    }//showmenu end
    //메세지 출력용
    public void printMsg(String msg) {
        ioc.twoPrint(msg);
    }
    public void subTitle(String str) {
        ioc.twoPrint("<<" + str + ">>");
        ioc.twoPrint("================");
    }
    //객실 입력 :
    public String inputRtype() {
        ioc.twoPrint("선택 : 일반 | 더블 | 특실 | 트리플" );
        String inputRt = ioc.inStr("방 타입 : ");

        return inputRt;
    }
    //아이디 :
    public String bookingId() {
        String id = null;
        ioc.twoPrint("<<입실 예약>>");
        ioc.twoPrint("================");
        id = ioc.inStr("아이디 : ");

        return id;
    }
    //호실 입력 :
    public int bookingR() {
        int num = 0;
        ioc.twoPrint("선택 <3층> 301, 302, 303, 304, 305, 306");
        ioc.twoPrint("선택 <2층> 201, 202, 203, 204, 205, 206");
        ioc.twoPrint("선택 <1층> 101, 102, 103, 104, 105, 106");
        num = ioc.inNum("객실 :");

        return num;
    }
    public void bookingInput(BookingDto bDto, String bookingId, int bookingRnum, String roomType) {
        bDto.setM_id(bookingId);
        bDto.setR_no(bookingRnum);
        bDto.setT_name(roomType);
        bDto.setB_start(ioc.inStr("입실일 : "));
        bDto.setB_end(ioc.inStr("퇴실일 : "));
    }
    //예약 삭제 id조회
    public String searchId() {
        String id = null;
        ioc.twoPrint("예약 삭제");
        id = ioc.inStr("아이디 : ");

        return id;
    }
    public String delete() {
        String yn = ioc.inStr("예약 삭제하시겠습니까?(삭제/취소)"
                + "\n" + "입력> ");
        return yn;
    }
    public String searchCode(String str) {
        String id = null;
        subTitle(str);
        id = ioc.inStr("아이디 : ");

        return id;
    }
    public void outData(BookingDto data) {
        subTitle("예약 확인");

        if (data == null){
            printMsg("데이터가 없음");
            return;
        }

        ioc.twoPrint(data.searchbook());
    }
}
