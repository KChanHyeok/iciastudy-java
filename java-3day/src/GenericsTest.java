public class GenericsTest {
    public static void main(String[] args) {
        Box b1 = new Box();

        b1.setItem("abc");
        Box b2 = new Box();
        b2.setItem(100);
        System.out.println(b1.getItem());
        // 저장된 데이터의 맞는 형태로 변경하여 사용.
        // 형변환 연산자가 필요함. 잘못 형변환을 하면
        // 예외사항이 발생함.


        String rb1 = (String) b1.getItem();
        int rb2 = (int)b2.getItem();

        //제네릭스 박스 사용
        Box2<String> gb1 = new Box2<>();
        Box2<Integer> gb2 = new Box2<>();
        
        gb1.setItem("안녕하세요");
        gb2.setItem(15466);

        System.out.println(gb1.getItem());
        System.out.println(gb2.getItem());

    }
} // class end

class Box {
    private Object item;

    public void setItem(Object item) {
    this.item = item;
    }
    Object getItem(){
        return item;
    }
} // box end

class Box2<T> {
    private  T item;

    public void setItem(T item){
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}