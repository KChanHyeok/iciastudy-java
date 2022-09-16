public class TypeCast {
    public static void main(String[] args) {
        byte b = 10;
        int ivalue = b; //자동 형변환

        short sh = (short)ivalue;

        System.out.println(sh);

        int i2 = 100000;
        sh = (short)i2;

        System.out.println(sh);

        float pi = 3.14f;
        long i3 = (int)pi;
        System.out.println(i3);

        String str = "문자열" + pi; // 문자열이 가장 큰 데이터 타입
        //연산 내부에서 자동으로 형변환이 발생(float -> String)

        //연산식에서 자동 형변환 : 연산 순서에 따라 자동 형변환.
        float rs = pi * 5;
        System.out.println(rs);
        float ff = 5.89f;
        int rsi = (int)ff * 6;
        System.out.println(rsi);
        int rsi2 = (int)(ff*6);
        System.out.println(rsi2);

        String rsi3 = 5 + 4 + "";
        System.out.println(rsi3);
        rsi3 = "" + 5 + 4;
        System.out.println(rsi3);
        rsi3 = 5 + "" + 4;
        System.out.println(rsi3);
        // 숫자 -> 문자열 변환 메소드 : String.valueOf(숫자);
        String sss = String.valueOf(10);
        // 형변환은 데이터가 대상임. 변수는 타입은 변경되지 않는다!
        
        String numStr = "1000";
        // 정수문자열 -> 정수
        int numInt = Integer.parseInt(numStr);
        System.out.println();
        // 실수문자열 -> 실수
        numStr = "3.14";
        float numFloat = Float.parseFloat(numStr);

        float dres = 5.0f / 3;
        System.out.println(dres);

        int ires = 5 / 3;
        System.out.println("몫: "+ ires);
        int r = 5 % 3;
        System.out.println("나머지 : "+r);

    }
}
