public class PolyTest {
    public static void main(String[] args) {
        Child5 ch5 = new Child5();
        Child6 ch6 = new Child6();

        //up casting
        Parent5 p5 = ch5;
        Parent5 p6 = ch6;
        Parent5 p7 = new Parent5();

        p5.a = 10;
        p5.b = 20;
        //p5.c = 30; //불가

        //down casting
        //Child5 cc5 = (Child5)p5;
        //Child5 cc6 = (Child5)p7;
        //Child5 cc7 = (Child5)p6;

        Parent5 p = new Child6();
        if(p instanceof Child5) {
            Child5 cc5 = (Child5)p;
            System.out.println("Child5로 만든 인스턴스임");
            cc5.c = 300;
        }else {
            Child6 cc7 = (Child6)p;
            System.out.println("Child6으로 만든 인스턴스임");
            cc7.d = 500;
        }
    }
}

class Parent5 {
    int a;
    int b;
}

class Child5 extends Parent5 {
    int c;
}

class Child6 extends Parent5 {
    int d;
}


