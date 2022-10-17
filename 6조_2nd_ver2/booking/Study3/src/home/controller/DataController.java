package home.controller;

import home.dto.BookingDto;
import home.service.BookingService;
import home.service.RoomService;
import home.service.RoomTypeService;
import home.view.DataView;


public class DataController {
    private DataView dView = new DataView();
    private BookingDto bDto = new BookingDto();
private BookingService bServ = new BookingService();
private RoomService rServ = new RoomService();
private RoomTypeService tServ = new RoomTypeService();




    public void addDeleteRun(){
        int menu = -1;

        while (true){
            menu = dView.showMenu();

            if (menu == 0){
                dView.printMsg("돌아가기");
                break;
            }

            switch (menu){
                case 1:
                    inputbooking();
                    break;
                case 2:
                    deletedata();
                    break;
                default:
                    dView.printMsg("숫자만 입력해주세요");
            }

        }//while end
    }//run end

    //예약 삭제
    private void deletedata() {
        String id = dView.searchCode("예약 삭제");
        BookingDto data = bServ.getData(id);
        dView.outData(data);

        if (data != null){
            String yn = dView.delete();
            if (yn.equals("삭제")){
                String msg = bServ.deleteData(id);
                dView.printMsg(msg);

            }
        }
    }
    //예약자 아이디 검색
    private void inputbooking() {
        String bookingId = dView.bookingId();
        String userId = bServ.getBookingId(bookingId);

        if (userId == null){
            System.out.println("없는 아이디입니다.");
        }
        else {
            System.out.println("회원이십니다.");
            //예약된 회원 방조회


            //예약 안된 회원의 예약할 방이름
            int bookingRnum = dView.bookingR();
            String bookingRoom = rServ.getBookingRoom(bookingRnum);

            if (bookingRoom == null){
                System.out.println("없는 객실입니다.");
            }
            else {
                //예약중인지 확인
                dView.printMsg(bookingRoom);
                    if (bookingRoom.equals("예약중")) {

                    }
                    else {
                        String rType = dView.inputRtype();
                        String roomType = tServ.roomType(rType);

                        if (roomType == null){
                            System.out.println("없는 방 타입입니다 제대로 입력해주세요");
                        }
                        else {
                            BookingDto bDto = new BookingDto();
                            dView.bookingInput(bDto, bookingId, bookingRnum, roomType);
                            String msg = bServ.insertData(bDto);
                            dView.printMsg(msg);
                        }
                    }
            }//방상태 end
        }//회원 end
    }//input end




}
