package datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        //Date class : 현재 시간을 저장한 인스턴스 생성
        Date today = new Date();
        System.out.println(today);

        // SimpleDateFormat : 원하는 형태로 날짜와 시간 형식을 지정.
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd(E)");

        String daystr = sdf1.format(today);
        System.out.println(daystr);

        SimpleDateFormat sdf2 = new SimpleDateFormat("[a] hh:mm:ss");

        String timestr = sdf2.format(today);
        System.out.println(timestr);

        SimpleDateFormat sdf3 = new SimpleDateFormat("요일 F / 1년중에 몇번째 주인가 w / 이번달중에 주: W / 1년중에 몇번째 일인가 D");
        String str = sdf3.format(today);
        System.out.println(str);

    }
}
