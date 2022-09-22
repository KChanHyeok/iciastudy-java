public class AbstractTest {
    public static void main(String[] args) {
        Cat c = new Cat(); //정상적으로 인스턴스 생성 가능.
        //TestInterface t = new TestInterface()
        InterClass ic = new InterClass();
        TestInterface tf = ic; //다형성 취급이 가능함
    }
}

abstract class Animal {
    String name;
    int age;
    String gender;

    abstract void howl(); //오버라이드가 필요한 메소드

    void eat() {
        System.out.println("먹는다.");
    }
}

class Cat extends Animal {

    @Override
    void howl() {
        System.out.println("야옹~~~");
    }
}

interface TestInterface {
    public static final int a = 10;
    final int b = 20;
    static int c = 30;
    int d = 40;  //전부 생략이 되나 다 상수임

    public abstract void method1();
    public void method2();
    void method3();
}

class InterClass implements TestInterface {
    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }
}