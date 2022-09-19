import java.lang.reflect.Array;
import java.util.Arrays;

public class ConstructorTest {
    public static void main(String[] args) {
        Car c1 = new Car();
        //c1.setColor("white");
        Car c2 = new Car("white");
        Car c3 = new Car("black", "auto");
        Car c4 = new Car("white", "auto", 4);

        Car c5 = new Car(null, "manual");
        Car c6 = new Car(null, null, 5);
        Car c7 = new Car(4);

        //지역변수
        int a = 0;
        c2.printAll();


    }
}

class Car {
    private String color;
    private String gearType;
    private int door;

    // 필드에 값 입력 방법
    // 1) setter 사용
    public void setColor(String color) {
        this.color = color;
    }

    // 2) 생성자 사용
    public Car() {
    }

    //생성자 오버로딩
    public Car(String color) {
        this.color = color;
    } // 개발자가 어떤 생성자를 작성하는 순간

    // 컴파일러는 기본 생성자를 작성해주지 않는다!
    public Car(String color, String gearType) {
        this.color = color;
        this.gearType = gearType;
    }

    public Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    public Car(int door) {
        this.door = door;
    }

    public void printAll() {
        System.out.println(color);
        System.out.println(gearType);
        System.out.println(door);
    }
}
