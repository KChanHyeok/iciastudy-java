package com.view;

import java.util.Scanner;

public class InOutClass {
    private Scanner scan = new Scanner(System.in);

    public String inStr(String str) {
        onePrint(str);
        String s = scan.nextLine();
        return s;
    }
    public int inNum(String str) {
        onePrint(str);
        String s = scan.nextLine();
        int num = -1;

        if(s.equals("")) {
            num = -1;
            return num;
        }
        try {
            num = Integer.parseInt(s);
        }catch (Exception e) {
            twoPrint("잘못입력하셨습니다.");
            num = -1;
        }
        return num;
    }

    public void onePrint(String str) {
        System.out.println(str);
    }

    public void twoPrint(String str) {
        System.out.println(str);
    }
}
