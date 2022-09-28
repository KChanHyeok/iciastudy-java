package filetest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File folder = new File("data");
            if(!folder.isDirectory()) {
                folder.mkdir();
            }
            File file = new File("data\\test.txt");
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            System.out.print("내용 작성 : ");
            String str = scan.nextLine();
            bw.write(str);
            bw.flush();
            System.out.println("저장성공");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                bw.close();
                fw.close();
            }catch (IOException ie){
                ie.printStackTrace();
            }
        }
    }
}
