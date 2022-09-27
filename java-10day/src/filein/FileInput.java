package filein;

import java.io.*;

public class FileInput {
    public static void main(String[] args) {
        //FileInputStream fis = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            File file = new File("data\\test.txt");

            //fis = new FileInputStream(file);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            //int i = 0;//읽어온 데이터(byte 단위)를 저장하는 변수
            //FileInputStream 사용
            //read() : byte 단위로 읽어오는 메소드.
            // 읽어온 내용이 없으면 -1을 반환.
            //while ((i = fis.read()) != -1){
            //    System.out.write(i);
            //}
            //FileReader 만 사용.
            //while ((i = fr.read()) != -1){
            //    System.out.print((char)i);
            //}
            //BufferedReader 사용
            String str = null;
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //fis.close();
                br.close();
                fr.close();
            } catch (IOException e) { }
        }
    }
}
