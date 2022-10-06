package com.controller;

import com.dta.DtaClass;
import com.dto.MemberDto;
import com.view.InOutClass;

public class ControllerClass {
    InOutClass io = new InOutClass();
    DtaClass dt = new DtaClass();

    public void run() {
        int menu = -1;
        io.twoPrint("***커뮤니티 사이트 오신걸 환영합니다. ***");
        io.twoPrint("************************************");
        while (true) {
            showmenu();
            menu = io.inNum("입력 : ");
            if(menu == 0 ) {
                io.twoPrint("시스템을 종료합니다.");
                break;
            }
            switch (menu) {
                case 1 :
                    inputLogin();
                    break;
                case 2 :
                    inputSinge();
                    break;
                default:
                    io.twoPrint("0에서 2까지의 숫자만 입력해주세요\n");
                    break;
            }
        }

        
    }

    private void inputSinge() {
        io.twoPrint("******회원가입******");
        io.twoPrint("*******************");
        MemberDto md = new MemberDto();
        md.setM_id(io.inStr("ID : "));
        md.setM_pwd(io.inStr("PWD : "));
        md.setM_name(io.inStr("NAME : "));
        md.setM_age(io.inNum("AGE : "));
        md.setM_job(io.inStr("JOB : "));

        dt.insetMember(md);

    }

    private void inputLogin() {
        io.twoPrint("******로그인******");
        io.twoPrint("*****************");
        String m_id = io.inStr("ID : ");
        String m_pwd = io.inStr("PWD : ");
        String dbpwd = dt.selectPwd(m_id);

        try {
            if(dbpwd.equals(m_pwd)) {
                int submenu = -1;
                while (true){
                    showLogin(m_id);
                    submenu = io.inNum("입력 : ");
                    if( submenu == 0) {
                        io.twoPrint("로그아웃을 합니다.");
                        break;
                    }
                }
            }else {
                io.twoPrint("로그인 실패");
            }
        }catch (NullPointerException ne){
            io.twoPrint("로그인 실패");
        }
    }

    private void showmenu() {
        io.twoPrint("1. 로그인하기");
        io.twoPrint("2. 회원가입하기");
        io.twoPrint("0. 종료");
    }
    private  void showLogin(String m_id) {
         String m_name = dt.selectName(m_id);
        io.twoPrint("환영합니다 "+ m_name +"님");
        io.twoPrint("0. 로그아웃하기");
    }
}
