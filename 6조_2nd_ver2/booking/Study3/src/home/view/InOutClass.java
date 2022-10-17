package home.view;

import java.util.Scanner;

public class InOutClass {
    private Scanner scan = new Scanner(System.in);


    public  String inStr(String str){
        //입력 안내 문구(str)를 출력하고
        //입력값을 받아서 넘긴다.
        onePrint(str);
        String s = scan.nextLine();

        return s;
    }


    public int inNum(String str){
        onePrint(str);
        String s = scan.nextLine();
        int num = -1;

        //입력을 안했을때의 처리
        if(s.equals("")){
            num = -1;
            return num;//메소드 종료
        }
        //숫자가 아닌 문자가 입력되었을 경우의 처리
        try{
            num = Integer.parseInt(s);
        }catch(Exception e){
            twoPrint("잘못된 입력!");
            num = -1;
        }//try end

        return num;
    }

    public void onePrint(String str){
        System.out.print(str);
    }
    public void twoPrint(String str){
        System.out.println(str);
    }


}
