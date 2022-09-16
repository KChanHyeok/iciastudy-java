package test;

import dto.DtoClass;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerClass {
    Scanner scan = new Scanner(System.in);

    ArrayList<DtoClass> datas = new ArrayList<>();
    String menu;

    void run() {
        System.out.println("★★★★★★★★★★★★★");
        System.out.println("★★★관리 프로그램★★★");
        System.out.println("★★★★★★★★★★★★★");

        while (true) {
            System.out.println("1.입력");
            System.out.println("2.출력");
            System.out.println("0.종료");
            System.out.print("입력> ");
            menu = scan.nextLine();

            if (menu.equals("0")) {
                System.out.println("프로그램을 종료합니다");
                break;
            }

            switch (menu) {
                case "1":
                    inputData();
                    break;
                case "2":
                    outData();
                    break;
                default:
                    System.out.println("잘못입력하셧습니다.");
                    break;
            }

        }

    }

    void inputData() {
        System.out.println("★★★★★ 입력 ★★★★★");
        String invalue = "";
        int number = 0;
        float fnum = 0.0f;
        DtoClass data = null;
        try {
            data = new DtoClass();
            System.out.print("정수 입력: ");
            invalue = scan.nextLine();
            number = Integer.parseInt(invalue);
            data.setNumber(number);
            System.out.print("문자 입력: ");
            invalue = scan.nextLine();
            data.setStr(invalue);
            System.out.print("실수 입력: ");
            invalue = scan.nextLine();
            fnum = Float.parseFloat(invalue);
            data.setFnum(fnum);

        } catch (Exception nfe) {
            System.out.println("숫자를 입력해주세요");
        }
        datas.add(data);
        System.out.println("입력이 완료 되었습니다.");
    }

    void outData() {
        if (datas.size() == 0) {
            System.out.println("데이터가 없습니다");
            return;
        } else {
            System.out.println("전체 출력");
            for(DtoClass d : datas) {
                System.out.println("정수 : " + d.getNumber());
                System.out.println("문자 : " + d.getStr());
                System.out.println("문자 : " + d.getFnum());
                System.out.println("---------");
            }
            System.out.println("출력완료");
            return;
        }
    }
}
