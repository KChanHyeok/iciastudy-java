import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        //scan 인스턴스 생성
        Scanner scan = new Scanner(System.in);

        //정수 입력 int 값
        System.out.print("정수 입력 : ");
        int i = scan.nextInt();
        System.out.println("입력받은 정수 값 : " + i);

        //실수 입력float 값
        System.out.print("실수 입력 : ");
        float f = scan.nextFloat();
        System.out.println("입력받은 실수 값 : "+ f);
//        scan.nextLine(); //개행문자 처리
        //문자열 입력
        System.out.print("문자열 입력 : ");
        String str = scan.next();
        System.out.println("입력받은 문자열 : "+str);

        System.out.print("next() 사용 시 문자열 :");
        String str2 = scan.next();
        System.out.println("next() : "+ str2);

        scan.nextLine();
        System.out.print("nextLine() 사용시 문자열 :");
        String str3 = scan.nextLine();
        System.out.println("nextLine() : "+str3);
    }
}
