package sigletonpkg;

public class SingletonTest {
    // 자신의 인스턴스를 저장하는 참조변수(멤버) 선언
    private static SingletonTest instance = null;
    
    //생성자는 private로 선언
    private SingletonTest() {
        //다른 클래스에서 인스턴스를 못 만들도록 설정.
    }

    // 인스턴스를 제공하는 메소드를 선언
    public static SingletonTest  getInstance() {
        if(instance == null) {
            instance = new SingletonTest();
        }
        return instance;
    }

    //기타 기능제공 메소드
    public void method1() {
        System.out.println("싱글톤이다~~");
    }

}
