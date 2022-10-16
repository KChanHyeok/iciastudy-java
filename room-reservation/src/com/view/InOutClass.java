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
        int num = -1;
        onePrint(str);
        String s = scan.nextLine();
        if (s.equals("")) {
            num = -1;
            twoPrint("잘못된 입력입니다");
        } try{
            num = Integer.parseInt(s);
        }catch (Exception e){
            twoPrint("잘못된 입력!");
            num = -1;
        }
        return num;
    }


    public void onePrint(String str) {
        System.out.print(str);
    }

    public void twoPrint(String str) {
        System.out.println(str);
    }
}
