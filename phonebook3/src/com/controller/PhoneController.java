package com.controller;

import com.dto.PhoneCinfo;
import com.dto.PhoneInfo;
import com.dto.PhoneSinfo;
import com.view.InOutClass;

import java.util.ArrayList;

public class PhoneController {
    //저장 공간(통합)
    ArrayList<PhoneInfo> pList = new ArrayList<>();

    InOutClass io = new InOutClass();

    public void run() {
        int menu = -1;
        io.twoPrint("간단 연락처 프로그램");

        while (true) {
            io.twoPrint("메뉴>");
            io.twoPrint("1. 학교 연락처 입력");
            io.twoPrint("2. 회사 연락처 입력");
            io.twoPrint("3. 전체 출력");
            io.twoPrint("0. 종료");
            menu = io.inNum("번호> ");
            if (menu == 0) {
                io.twoPrint("프로그램을 종료합니다.");
                break;
            }

            switch (menu) {
                case 1:
                    inputSchool();
                    break;
                case 2:
                    inputCompany();
                    break;
                case 3:
                    outputTotal();
                    break;
                default:
                    io.twoPrint("0~3까지 입력해주세요");
                    break;

            }
        }// while end
    }// run end

    private void outputTotal() {
        if (pList.size() == 0) {
            io.twoPrint("연락처 없음\n");
            return;
        }
        for (PhoneInfo p : pList) {
            io.twoPrint("이름 : " + p.getName());
            io.twoPrint("연락처 : " + p.getPhone());
            if (p instanceof PhoneSinfo) {
                PhoneSinfo ps = (PhoneSinfo) p;
                io.twoPrint("전공 : " + ps.getMajor());
            } else {
                PhoneCinfo pc = (PhoneCinfo) p;
                io.twoPrint("부서 : " + pc.getDept());
            }
            io.twoPrint("============================");
        }
    }

    private void inputCompany() {
        io.twoPrint("회사 연락처 입력");
        PhoneCinfo pc = new PhoneCinfo();
        pc.setName(io.inStr("이름 : "));
        pc.setPhone(io.inStr("연락처 : "));
        pc.setDept(io.inStr("부서 : "));
        pList.add(pc);
        io.twoPrint("입력완료\n");
    }

    private void inputSchool() {
        io.twoPrint("학교 연락처 입력");
        PhoneSinfo ps = new PhoneSinfo();
        ps.setName(io.inStr("이름 : "));
        ps.setPhone(io.inStr("연락처 : "));
        ps.setMajor(io.inStr("전공 : "));
        pList.add(ps);
        io.twoPrint("입력완료\n");
    }
} // clss end
