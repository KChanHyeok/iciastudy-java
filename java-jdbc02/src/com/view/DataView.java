package com.view;

import com.dto.DataDto;

import java.util.List;

public class DataView {
    //입출력을 위한 부품.(InOutClass)
    private InOutClass ioc = new InOutClass();

    //타이틀, 메뉴 츌려그 메뉴번호 입력
    public int showFirst() {
        int m = -1;

        ioc.twoPrint("");//첫줄 띄기.
        ioc.twoPrint("<<DB 연동 데이터 관리 프로그램>>");
        ioc.twoPrint("----------------------------");
        ioc.twoPrint("메뉴>");
        ioc.twoPrint("1. Data input");
        ioc.twoPrint("2. Data output");
        ioc.twoPrint("3. Data search");
        ioc.twoPrint("4. Data update");
        ioc.twoPrint("5. Data delete");
        ioc.twoPrint("0. Quit");
        m = ioc.inNum("Select> ");

        return m;
    } // showFirst end
    
    //메세지 출력용 메소드
    public void printMsg(String msg) {
        ioc.twoPrint(msg);
    }

    //데이터 입력 메소드
    public void inputData(DataDto data) {
        ioc.twoPrint("<Data input>");
        ioc.twoPrint("----------------");
        data.setM_str(ioc.inStr("STRING : "));
        data.setM_int(ioc.inNum("INTEGER : "));
        data.setM_date(ioc.inStr("DATE(yyyy-mm-dd) : "));
    }// inputData end

    //전체 데이터 출력용 메소드
    public void outputLists(List<DataDto> dList) {
        ioc.twoPrint("<Data output>");
        ioc.twoPrint("----------------");
        if(dList == null) {
            ioc.twoPrint("데이터가 없습니다.");
        }

        // 목록 출력(반복)
        for(DataDto d : dList) {
            ioc.twoPrint("CODE : "+d.getM_code());
            ioc.twoPrint( "STRING : "+d.getM_str());
            ioc.twoPrint("INT : " + d.getM_int());
            ioc.twoPrint("DATE : "+d.getM_date());
            ioc.twoPrint("---------------");
        }
    } // outputlist end

    // 검색 코드 입력 메소드
    public int searchCode(String str) {
        int code = 0;

        ioc.twoPrint("<Data search>");
        ioc.twoPrint("---------------");
        code = ioc.inNum(str);

        return code;
    }// searchCode end

    //개별 데이터 출력용
    public void outputData(DataDto data) {
        ioc.twoPrint("<검색 결과>");
        ioc.twoPrint("---------------");

        if(data == null) {
            ioc.twoPrint("검색 결과 없음.");
        }else {
            ioc.twoPrint("CODE : "+data.getM_code());
            ioc.twoPrint( "STRING : "+data.getM_str());
            ioc.twoPrint("INT : " + data.getM_int());
            ioc.twoPrint("DATE : "+data.getM_date());
            ioc.twoPrint("---------------");
        }
    }


    
} // class end
