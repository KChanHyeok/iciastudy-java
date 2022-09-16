public class VariableTest {
    public static void main(String[] args) {
        //문자형(Character)
        char ch;
        ch = '가'; // 반드시 ' 사용!
        char zzzzz;
        // 작며법 : 대소문자 구분. a~z, A~Z, 0~9, _, $만 사용가능.
        //          숫자를 첫글자로 사용 불가. 글자 사이에 공백 X.
        // 권장사항 : 첫글자는 반드시 소문자로 작성할 것.

        // 정수형 변수
        byte numByte;
        short numShort;
        int numInt; // 가장 많이 사용하는 형태
        //long zzzzz; //타입이 달라도 같은 변수명은 쓸 수 없다!
        //경고는 무시해도 상관 없음.
        long numLong = 100L; // 접미사 'L'. long 타입의 값을 표시.

        //실수형 변수
        float f = 0.0f;
        double du = 0.0;

        float f2;
        int iva = 10;
        f2 = iva;
//        System.out.println(f2);

        boolean b = true;
        boolean bb = false;

        //참조형 String
        String str = "이건 문장입니다.";

        int n1 = 100;
        int n2 = 100;

        boolean res = (n1 == n2);
        //System.out.println(res);
        String sb1 = "abc";
        String sb2 = "abc";
        res = (sb1 == sb2);
        System.out.println(res);

        String s1 = new String("abc");
        String s2 = new String("abc");

        res = (s1 == s2); // false
        System.out.println(res);
        res = (s1.equals(s2)); //문자열 비교 s1과 s2에 들어가있는 데이터가 같은가?
        System.out.println(res);
    }
}
