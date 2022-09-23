package sbtest;

public class StringBufferTest {
    public static void main(String[] args) {
        // 기본 생성법(16칸의 공간을 형성)
        StringBuffer sb1 = new StringBuffer();
        //System.out.println(sb1.capacity());
        //원하는 크기로 생성
        StringBuffer sb2 = new StringBuffer(100);
        //System.out.println(sb2.capacity());

        sb1.append("abcdefghijklmnopqrstuvwxyz");
        //System.out.println(sb1.capacity());

        StringBuffer sb3 = new StringBuffer("abcd");
        //System.out.println(sb3.capacity());
        //System.out.println(sb3.length());

        //System.out.println(sb1);
        StringBuffer sb4 = sb1.delete(2, 6);
        //System.out.println(sb4);

        sb4.insert(5, "와");
        //System.out.println(sb4);
        sb4.replace(6, 10, "오~~~~~" );
        //System.out.println(sb4);

        sb1.reverse();
        System.out.println(sb1);

        //최종적으로 문자열로 변환
        String s = sb1.toString();
    }
}
