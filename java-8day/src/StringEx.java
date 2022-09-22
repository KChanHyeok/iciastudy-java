public class StringEx {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        char[] ch = {'h', 'e', 'l', 'l', 'o'};
        String str3 = new String(ch);
        //StringBuffer
        StringBuffer sb = new StringBuffer();

        sb.append("abc");
        sb.append("def");
        String str4 = new String(sb);
        String str5 = sb.toString();

        //////////////////////////////////////////
        char c = str1.charAt(4);
        System.out.println(str1 + " : " + c);

        String str6 = "dog,cat:chicken pig";
        String strs[] = str6.split("[,: ]");
        for(String s : strs) {
            System.out.println(s);
        }
        System.out.println(strs.length);
        System.out.println(str6);

        String str7 = "aa0bbcc1aaee3ffaa5gg";
        String str8 = str7.replace("aa","AA");
        System.out.println(str7);
        System.out.println(str8);
        String str9 = str7.replaceAll("aa","ZZ");
        System.out.println(str9);
        String str10 = str7.replaceAll("[0-9]", " ");
        System.out.println(str10);

        String str11 = str7.substring(0, 10);
        System.out.println(str11);
    }
}
