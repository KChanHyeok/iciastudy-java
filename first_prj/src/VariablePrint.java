import java.util.Scanner;

public class VariablePrint {
    public static void main(String[] args) {
        //변수에 데이터 대입
        int number1 = 0; // 변수의 선언 및 초기화
        //메소드 내부에 변수를 만들 경우 초기화를 하는 것이 좋다.
        number1 = 350; //임의의 값을 대입
        // '=' : 대입연산자. 우변의 값(또는 변수, 수식)을
        // 좌변의 변수에 입력.
        int number2 = number1;

        number2 = number1 + 250;

        boolean b = (number1 == number2);
        boolean b2 = b;
        // b2 = number1; // 다른 타입의 변수로 대입 불가
        // 형변환(다른 타입으로 변환) : Type Casting

        ////////////////////////////////////////////
        // 일반적으로 많이 사용하는 출력문
        System.out.println(number1);
        System.out.println("안녕하세요!");
        System.out.println(b);
        System.out.println('a');
        ////////////////////////////////////////////
        // 출력문은 3가지 형태가 있다.
        // 1. println : 출력 후 다음 라인으로 커서를 이동.
        // 2. print : 출력 후 현 위치를 유지
        System.out.print("첫번째 print 출력.");
        System.out.print("두번째 print 출력.");
        System.out.println(); //라인만 바꿔줌.
        Scanner scan = new Scanner(System.in);
        //System.out.print("입력> : ");
        //String input = scan.nextLine();

        for (int i =1; i<=31; i++) {
            System.out.print("\t"+i);
            if (i%7==0){
                System.out.println();
            }
        }
        System.out.println();
        ////////////////////////////////////////////
        // 3. printf("형식지정", 변수들);
        System.out.printf("\nnumber2의 값은 %5d입니다.\n", number2);
        //print 처럼 줄바꿈을 하지 않는다.
        //'\n'은 줄바꿈을 표현하는 특수 문자.
        // 서식 지정자 : '%'와 조합하여 사용하는 문자.
        // 1. %d : 정수변수의 값을 출력할 대 사용.
        // 2. %f " 실수변수의 값을 출력할 때 사용.
        float fnum = 3.14f;
        System.out.printf("파이는 %.2f이다.\n", fnum);
        //3. %c : 문자변수의 값을 출력할 때 사용
        //4. %s : 문자열변수의 값을 출려할 때 사용
        char ch = 'A';
        String str = "Hello";
        System.out.printf("문자는 %c이고, 문자열은 %s입니다.\n", ch, str);
        System.out.println("문자는 "+ ch + "이고, 문자열은 "+str+"입니다.");
    }
}
