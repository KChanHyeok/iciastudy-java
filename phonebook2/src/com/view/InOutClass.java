package com.view;

import java.util.Scanner;

public class InOutClass {
    // 1. 키보드로부터 데이터의 입력 받는다.
    private Scanner scan = new Scanner(System.in);

    // 문자열 입력 메소드
    public String inStr(String str) {
        // 입력 유도용 안내문구(str)을 출력하고
        // 입력값을 받아서 넘긴다.
        onePrint(str);
        String s = scan.nextLine();

        return s;
    }

    //정수 입력용 메소드
    public int inNum(String str) {
        onePrint(str);
        String s = scan.nextLine();
        int num = -1;
        //아무것도 입력하지 않았을때
        if (s.equals("")) {
            num = -1;
            return num; // 메소드 종료
        }
        // 숫자가 아닌 문자가 입력되었을 경우의 처리
        try {
            num = Integer.parseInt(s);
        } catch (Exception e) {
            twoPrint("잘못된 입력입니다.");
            num = -1;
        }
        return num;
    }


    // 2. 모니터로 데이터를 출력한다.
    // 줄바꿈 안하는 출력 메소드
    public void onePrint(String str) {
        System.out.print(str);
    }

    // 줄바꿈 하는 메소드
    public void twoPrint(String str) {
        System.out.println(str);
    }
}
