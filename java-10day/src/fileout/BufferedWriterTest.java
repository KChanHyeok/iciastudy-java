package fileout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try{
            File folder = new File("data");
            if(!folder.isDirectory()){
                folder.mkdir();
            }
            File file = new File("data\\test.txt");
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            String str = "파일에 저장할 내용.\n";
            bw.write(str);
            bw.flush();
            System.out.println("저장 성공.");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
    }
}
