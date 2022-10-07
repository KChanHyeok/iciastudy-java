package com.controller;

import com.dto.DataDto;
import com.service.DataService;
import com.view.DataView;

import java.util.List;

public class DataController {
    private DataView dView = new DataView();
    private DataService dServ = new DataService();

    //프로그램 전체 제어 메소드
    public  void run () {
        int menu = -1;

        //종료 명령이 있을 때까지 반복.
        while (true) {
            //타이틀 출력, 메뉴 출력, 메뉴 번호 입력 -< view
            menu = dView.showFirst();
            
            //종료 처리
            if(menu == 0) {
                //종료 메시지 출력 -> view
                dView.printMsg("Bye~~");
                break;
            }

            //나머지 메뉴 처리
            switch (menu) {
                case 1: // 데이터 입력
                    inputData();
                    break;
                case 2: // 데이터 출력(전체 출력)
                    outputData();
                    break;
                case 3: // 데이터 검색(개별 데이터 출력)
                    break;
                case 4: // 데이터 수정
                    break;
                case 5: // 데이터 삭제
                    break;
                default:
                    dView.printMsg("Input Error! Select 1~5 pls");
                    break;
            }

        } // while end
    } // run end

    private void outputData() {
        //service에게 전체 목록(List)을 가져오도록 위임.
        List<DataDto> dList = dServ.getList();
        //목록을 view가 출력하도록 넘김.
        dView.outputList(dList);
    }

    private void inputData() {
        //3가지 데이터를 입력 받는다(str, int, date);
        DataDto data = new DataDto(); // 데이터 입력 공간
        //view에서 입력처리.
        dView.inputData(data);
        //DB에 저장 -> service로 전달
        String msg = dServ.insertData(data);
        //메시지 출력 -> view
        dView.printMsg(msg);
    }
}// class end
