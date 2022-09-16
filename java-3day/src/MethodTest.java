public class MethodTest {
    //인스턴스 멤버 변수
    static int a; // 스태틱 멤버변수(클래스 변수) - 전역변수
    float b;
    String c;

    public static void main(String[] args) {
        //자바 프로그램의 실행 시작 메소드
        //public - 접근제어자 <-> private
        //static - 인스턴스 생성없이 사용 가능하다.
        //void - 반환갑시 없다. return 사용 안함.
        //main - 고정된 이름.
        //String[] args - 프로그램 시작 시 옵션값 저장 배열
//        System.out.println(args[0]);
//        System.out.println(args[1]);
//        System.out.println(args[2]);
        int a = 1000;
        method1();
        a = 10000;
    } // main end

    // static이 붙는 멤버(변수, 메소드 모두)는 static이 붙은
    // 멤버만 사용할 수 있다.

    // void를 사용하는 메소드 작성
    static void method1() {
        System.out.println("return 없는 메소드 실행");
        add(); // 메소드 호출
    }
    static int add() {
        System.out.println("return 있는 메소드 실행");
        return 100;
    }
} // class end
