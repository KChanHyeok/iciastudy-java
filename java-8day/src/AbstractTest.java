public class AbstractTest {
    public static void main(String[] args) {

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
