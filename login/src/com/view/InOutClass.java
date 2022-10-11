package com.view;

import java.util.Scanner;

public class InOutClass {
    Scanner scan = new Scanner(System.in);


    public String inStr(String str) {
        onePrint(str);
        String s = scan.nextLine();
        return s;
    }
    public int inNum(String str) {
        onePrint(str);
        int num = -1;
        String s = scan.nextLine();
        if(s.equals("")){
            num = -1;
            return num;
        }
        try {
            num = Integer.parseInt(s);
        }catch (Exception e) {
            num = -1;
            twoPrint("잘못된 입력입니다.");
            return num;
        }
        return num;
    }

    public void twoPrint(String str) {
        System.out.println(str);
    }
    public void onePrint(String str) {
        System.out.print(str);
    }
}
