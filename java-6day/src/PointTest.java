public class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point3d p31 = new Point3d();

        p1.x = 10;
        p1.y = 20;
        p1.color = "red";
        // p1.z = 44;
        p1.showPoint();
        System.out.println(p1);


        p31.x = 30;
        p31.y = 50;
        p31.z = 80;
        p31.color = "blue";
        p31.showPoint();
        System.out.println(p31);

        System.out.println(p1.pattern);
        p1.pattern = "물결";
        System.out.println(p1.pattern);
        System.out.println(p31.pattern);
        p31.pattern = "구름";
        System.out.println(p31.pattern);
        p31.showPattern();
    }
}

class Point { // 2D 그래프용 점 객체
    int x;
    int y;
    String color;
    String pattern = "어떤 모양";

    public Point(){}
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    void showPoint() {
        System.out.println("X : " + x + ", Y : " + y + ", color : " + color);
    }

    @Override
    public String toString() {
        return "x : " + x + ", y: " + y;
    }

}

class Point3d extends Point {
    int z;
    String pattern;

    public Point3d() {
        //super();
    }

    public Point3d(int x, int y, int z){
        super(x,y); // x와 y는 부모클래스에서 초기화.
        this.z = z; // 부모클래스에 없는 변수만 처리.
    }


    @Override
        //Annotation(어노테이션)
    void showPoint() {
        System.out.println("X : " + x + ", Y : " + y + ", Z : " + z + ", color : " + color);
    }

    @Override
    public String toString() {
        return super.toString() + ", z: " + z;
    }
    public void showPattern() {
        System.out.println("부모의 pattern : " + super.pattern);
        System.out.println("pattern : " + pattern);
    }
}
/*
class Point3d {
    int x;
    int y;
    int z;
    String color;
}
*/
