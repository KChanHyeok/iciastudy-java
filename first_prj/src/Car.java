public class Car {
    String model; // 자바의 문자열 변수
    String company;
    int tier;
    String color;
    
    //행동(기능, 메소드)
    void exel(int sp) {
        System.out.println("속도 "+ sp +"올림");
    }
    void stop() {
        System.out.println("멈춤");
    }
}
