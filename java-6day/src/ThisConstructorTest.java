import com.dto.PhoneInfo;

public class ThisConstructorTest {
    public static void main(String[] args) {
        Car c1 = new Car("white");

        String str = "강찬혁";

        PhoneInfo p = new PhoneInfo(str, "010-9960-0464", "05-24", 24);

    }
}

class Car {
    private String color;
    private String gearType;
    private int door;

    // 기본 생성자
    public Car() {}

    public Car(String color) {
        // this.color = color;
        this(color, null);
    }

    public Car(String color, String gearType) {
        //this.color = color;
        //this.gearType = gearType;
        this(color, gearType, 0);
    }

    public Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}

