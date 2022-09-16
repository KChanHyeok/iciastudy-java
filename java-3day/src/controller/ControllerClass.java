package controller;

import dto.DataDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerClass {
    //멤버로 Scanner 작성
    Scanner scan = new Scanner(System.in);
    //데이터 저장 공간(ArrayList) - 정수배열

    //데이터 저장 공간(ArrayList) - Dto배열(DataDto)
    ArrayList<DataDto> datas = new ArrayList<>();

    public void run() {
        // 지역변수는 초기화를 가급적 하자!
        String menu = null;// String(객체)은 null

        System.out.println("★★ 관리 프로그램 ★★");
        System.out.println("====================");

        while (true) {
            System.out.println("1. 입력");
            System.out.println("2. 출력");
            System.out.println("0. 종료");
            System.out.print("입력> ");
            menu = scan.nextLine();

            if (menu.equals("0")) {
                System.out.println("프로그램 종료");
                break; //또는 return
            }

            switch (menu) { //정수변수, 문자변수, 문자열변수
                case "1":
                    inputData();
                    break;
                case "2":
                    outputData();
                    break;
                default:
                    System.out.println("1~2번 중에 하나를 입력하세요");
                    break;
            }

        } // while end

    } // run end

    //입력 처리용 메소드
    void inputData() {
        System.out.println("★ 입력(숫자 입력) ★");
        System.out.println("-------------------");

        String inValue = null;
        int num = 0;
        float fnum = 0.0f;
        DataDto data = null; // null : 비어있다.


        // 사용자가 숫자가 아닌 값을 입력한다면?
        try {
            data = new DataDto();
            System.out.print("정수 입력 : ");
            inValue = scan.nextLine();
            num = Integer.parseInt(inValue);
            data.setNumber(num);
            System.out.print("문자열입력 : ");
            inValue = scan.nextLine();
            data.setStr(inValue);
            System.out.print("실수 입력 : ");
            inValue = scan.nextLine();
            fnum = Float.parseFloat(inValue);
            data.setFnumber(fnum);
        } catch (Exception nfe) {
            System.out.println("숫자를 입력하세요");
            return;
        }
        // ArrayList에 값 추가 : add()
        datas.add(data); //push와 같은 일을 하는 메소드
        System.out.println("입력 완료. 이전 메뉴로 돌아갑니다.");
    }// inputData end

    void outputData() {
        System.out.println("★ 전체출력 ★");
        System.out.println("-------------");

        //데이터의 유무 확인하여 없을 경우 메소드를 종료한다.
        if (datas.size() == 0) {
            System.out.println("데이터가 없습니다.");
            return;
        } else {
            int sum = 0;
            for (DataDto d : datas) {
//                System.out.println(d.getNumber() + ", " + d.getStr() + ", "+ d.getFnumber());
                System.out.println("정수 : " + d.getNumber());
                System.out.println("문자열 : " + d.getStr());
                System.out.println("실수 : " + d.getFnumber());
                sum += d.getNumber();
                System.out.println("------------------------");
            }
            System.out.println(" 총합 : " + sum);
            System.out.println("출력 완료. 이전 메뉴로 돌아갑니다.");
        }
    }

} // class end
