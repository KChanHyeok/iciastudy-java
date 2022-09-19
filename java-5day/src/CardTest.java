public class CardTest {
    public static void main(String[] args) {
        Etc.cv = 100;
        Etc e = new Etc();
        e.iv = 200;
        Etc e2 = new Etc();
        e2.iv = 500;
        e.cv = 600;
        e2.cv = 700;

        System.out.println(Etc.cv);
        System.out.println(e2.iv);
        System.out.println(e.iv);

        /////////////////////////////////
        Card c1 = new Card();
        c1.kind = "하트";
        c1.number = 7;
        Card c2 = new Card();
        c2.kind = "스페이드";
        c2.number = 3;

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
        System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");

        Card.width = 50;
        c2.height = 80;

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
        System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");

    }
}

class Etc {
    int iv; // 인스턴스 변수
    static int cv; // 스태틱 변수, 클래스 변수

    final int MAX = 100;// 상수(보통 이름은 대문자로 작성)


    static void method1() {
        //iv = 1000; //error
        cv = 50000;
        //method2();

    }

    void method2() {
        iv = 20000;
        cv = 70000;
    }

}

class Card {
    // 카드의 모양 : 하트, 다이아몬드, 스페이드, 클로버
    // 카드별 숫자 : 1~13
    // 인스턴스 변수
    String kind;
    int number;

    // 카드의 크기(가로/세로)는 모두 동일해야한다.
    // 스태틱(클래스) 변수(초기화도 함께 처리)
    static int width = 100;
    static int height = 250;


}
