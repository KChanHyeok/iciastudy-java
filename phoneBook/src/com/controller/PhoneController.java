package com.controller;

import com.dto.PhoneInfo;
import com.view.InOutClass;

import java.util.ArrayList;

public class PhoneController {
    //입출력장치
    private InOutClass io = new InOutClass();
    //연락처 저장공간
    ArrayList<PhoneInfo> book = new ArrayList<>();

    //전체제어 메소드
    public void run() {
        //메뉴 번호 저장 변수
        int menu = -1;

        //타이틀 출력
        io.twoPrint("연락처 관리 프로그램");
        io.twoPrint("=================");
        while (true) {
            //메뉴출력
            menuShow();

            menu = io.inNum("입력> ");
            //종료 처리
            if (menu == 0) {
                io.onePrint("종료합니다.");
                break;
            }

            //메뉴 번호에 따라 기능 처리
            switch (menu) {
                case 1: //입력 메소드 실행
                    inputData();
                    break;
                case 2: //출력 메소드 실행
                    outputData();
                    break;
                case 3: //검색 메소드 실행
                    searchData();
                    break;
                case 4: //수정 메소드 실행
                    updateData();
                    break;
                case 5: //삭제 메소드 실행
                    deleteData();
                    break;
                default:
                    io.twoPrint("0~5번까지 입력하세요.");
                    break;
            }

        } // while end
    } // run end

    //삭제 메소드
    private void deleteData() {
        //저장된 정보가 있는지 확인
        if (book.size() == 0) {
            io.twoPrint("정보가 없습니다.\n");
            return; //메소드 종료
        }
        io.twoPrint("-- 연락처 삭제 --");
        io.twoPrint("----------------");
        String sname = io.inStr("삭제할 이름: ");
        int i;
        PhoneInfo p = null;
        for (i = 0; i < book.size(); i++) {
            p = book.get(i);
            if (sname.equals(p.getName())) {
                io.twoPrint("이름 : " + p.getName());
                io.twoPrint("연락처 : " + p.getPhone());
                io.twoPrint("생일 : " + p.getBirth());
                io.twoPrint("나이 : " + p.getAge());
                io.twoPrint("-----------------------");
                break; // for(루프)를 멈추는 break 사용.
            }
        }// for end
        //검색 결과가 없을 경우의 처리
        if (i == book.size()) {
            io.twoPrint("검색한 내용이 없습니다.");
            return; // 메소드 종료.
        }
        //삭제할 연락처를 검색 성공.
        String yn = io.inStr("삭제할까요?(y/n) ");
        if(yn.equals("y")) {
            book.remove(p);
            io.twoPrint("삭제 완료. \n");
            return;
        }

        io.twoPrint("삭제 취소 \n");
    }

    //수정 메소드
    private void updateData() {
        //저장된 정보가 있는지 확인
        if (book.size() == 0) {
            io.twoPrint("정보가 없습니다.\n");
            return; //메소드 종료
        }
        io.twoPrint("-- 연락처 수정 --");
        io.twoPrint("----------------");

        //수정할 데이터 검색
        String sname = io.inStr("수정할 이름: ");
        int i;
        PhoneInfo p = null;
        for (i = 0; i < book.size(); i++) {
            p = book.get(i);
            if (sname.equals(p.getName())) {
                io.twoPrint("이름 : " + p.getName());
                io.twoPrint("연락처 : " + p.getPhone());
                io.twoPrint("생일 : " + p.getBirth());
                io.twoPrint("나이 : " + p.getAge());
                io.twoPrint("-----------------------");
                break; // for(루프)를 멈추는 break 사용.
            }
        }// for end
        //검색 결과가 없을 경우의 처리
        if (i == book.size()) {
            io.twoPrint("검색한 내용이 없습니다.");
            return; // 메소드 종료.
        }

        //검색 결과의 연락처 수정(연락처, 생일, 나이)
        //아무것도 입력하지 않고 '엔터'를 치면 수정 안함.
        io.twoPrint("수정할 내용이 없으면 엔터를 누르시오.");
        String ustr = io.inStr("연락처 : ");
        if(!ustr.equals("")) { // 수정할 값을 입력했는가?
            p.setPhone(ustr); //지정(검색한) 연락처를 변경
        }
        ustr = io.inStr("생일 : ");
        if(!ustr.equals("")) { // 수정할 값을 입력했는가?
            p.setBirth(ustr); //지정(검색한) 생일을 변경
        }
        int a = io.inNum("나이 : ");
        if(a != -1) { // 수정할 값을 입력했는가?
            p.setAge(a); //지정(검색한) 연락처를 변경
        }

        io.twoPrint("수정 완료.\n");
    }// updateData end


    //검색 메소드
    private void searchData() {
        //저장된 정보가 있는지 확인
        if (book.size() == 0) {
            io.twoPrint("정보가 없습니다.\n");
            return; //메소드 종료
        }
        io.twoPrint("-- 연락처 검색--");
        io.twoPrint("--------------");
        // 1. 검색 키워드(이름)을 입력 받는다.
        String sname = io.inStr("검색할 이름 : ");

        // 2. 목록에서 입력받은 키워드와 같은 데이터를 비교
        for (PhoneInfo p : book) {
            if (sname.equals(p.getName())) {
                io.twoPrint("이름 : " + p.getName());
                io.twoPrint("연락처 : " + p.getPhone());
                io.twoPrint("생일 : " + p.getBirth());
                io.twoPrint("나이 : " + p.getAge());
                io.twoPrint("검색 완료\n");
                return;
            }//if end
        }//for end
        //다음 문장은 검색 결과가 없을 경우만 실행된다.
        io.twoPrint("검색한 내용이 없습니다\n");
    }

    //출력 메소드
    private void outputData() {
        //저장된 정보가 있는지 확인
        if (book.size() == 0) {
            io.twoPrint("정보가 없습니다.\n");
            return; //메소드 종료
        } else {
            io.twoPrint("-- 연락처 출력 --");
            io.twoPrint("----------------");
            for (PhoneInfo p : book) {
                io.twoPrint("이름 : " + p.getName());
                io.twoPrint("연락처 : " + p.getPhone());
                io.twoPrint("생일 : " + p.getBirth());
                io.twoPrint("나이 : " + p.getAge());
                io.twoPrint("-----------------------");
            }
        }
        io.twoPrint("출력완료\n");
    }//outputData end

    //입력 메소드
    private void inputData() {
        io.twoPrint("-- 연락처 입력--");
        io.twoPrint("--------------");
//        pInfo.setName(io.inStr("이름 : "));
//        pInfo.setPhone(io.inStr("연락처 : "));
//        pInfo.setBirth(io.inStr("생일(mm-dd) : "));
//        pInfo.setAge(io.inNum("나이 : "));
        PhoneInfo pInfo = new PhoneInfo(io.inStr("이름 : "), io.inStr("연락처 : "), io.inStr("생일(mm-dd) : "), io.inNum("나이 : "));
        //연락처
        book.add(pInfo);
        io.twoPrint("입력완료.\n");
    }

    //메뉴출력 메소드
    private void menuShow() {
        io.twoPrint("1. 연락처 입력");
        io.twoPrint("2. 연락처 출력");
        io.twoPrint("3. 연락처 검색");
        io.twoPrint("4. 연락처 수정");
        io.twoPrint("5. 연락처 삭제");
        io.twoPrint("0. 종료");
    }


}
