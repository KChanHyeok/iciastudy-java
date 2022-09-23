package test;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();

        System.out.print("년도 입력>");
        int year = scan.nextInt();
        System.out.print("월 입력 >");
        int month = scan.nextInt();

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1);

        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        int lastDay = cal.getActualMaximum(Calendar.DATE);

        System.out.println();
        System.out.println(year + "년\t\t\t\t" + month + "월");
        System.out.println("==========================");
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        System.out.println("==========================");
        int cnt = 0;

        for (int i = 1; i <startDay; i++) {
            if (startDay==7) {
                break;
            }
            System.out.print("\t");
            cnt++;
        }

        for (int k = 1; k<=lastDay; k++ ) {
                System.out.print(k);
                cnt++;
            if(cnt%7==0){
                System.out.println();
            }else {
                System.out.print("\t");
            }

        }


    }
}
