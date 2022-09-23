package filetest;

import java.io.*;

public class FileOutput {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            // 특정 폴더를 만들고 파일을 저장하자.
            File folder = new File("data");
            if(!folder.isDirectory()) {
                folder.mkdir();
            }
            File file = new File("data\\test1.txt");

            //FileOutputStream 사용
            //fos = new FileOutputStream(file, true);
            // file 뒤에 true를 넣으면, 붙여쓰기 모드(append)
            //true를 빼면 덮어쓰기 모드

            //FileWriter 사용
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);

            String str = "안녕하세요~~\n";
            
            //FileOutputStream 사용
            // 문자열 -> byte 배열로 전환
            //byte[] b = str.getBytes();
            //byte 배열을 파일 출력
            //fos.write(b);

            //FileWriter 사용
            //fw.write(str);
            bw.write(str);
            
            // 통로(스트림)에 전송 안된 데이터를 처리
            bw.flush();

            System.out.println("저장 완료");

        }catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }catch (IOException ie) {
            ie.printStackTrace();
        }finally {
            try {
                //fos.close(); //FileOutputSteam 사용
                bw.close(); //BufferedWriter 먼저 정리
                fw.close(); //FileWriter 사용
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
