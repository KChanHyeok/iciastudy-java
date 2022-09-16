//라이브러리
import java.util.Scanner;

public class Hello {
    // 메인메소드
    public static void main(String[] args) {
        // 화면에 문장을 출력 :
//        System.out.println("Hello world!");
//        System.out.println("안녕하세요~");
//        // 키보드로 값입력 :
//        Scanner scan = new Scanner(System.in);
//        int num = scan.nextInt();
//        System.out.println("입력받은 값 : " + num);

        Car mycar = new Car(); // 인스턴스 생성
        mycar.model = "소나타";
        mycar.company = "현대";
        mycar.tier = 4;
        mycar.color = "검정색";
        mycar.exel(100);
        mycar.stop();

        System.out.println("나의 자동차의 모델은 " +mycar.model+"이고 브랜드는 "+mycar.company+" 이며 색깔은 "+mycar.color+"으로 바퀴가 "+mycar.tier+" 개 이며");
        mycar.exel(150);
    }// main end
}// class end
