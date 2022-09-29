package com.controller;

import com.dto.DiaryInfo;
import com.view.InOutClass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class ControllerClass {
    InOutClass io = new InOutClass();
    File folder = new File("data");

    File[] list =folder.listFiles();
    BufferedWriter bw = null;
    FileWriter fw = null;
    int cnt = 1;
    public void run() {
        if(!folder.isDirectory()){
            if(folder.mkdir()){ //폴더 생성 메소드 mkdir()
                System.out.println("생성 성공");
            }
            else {
                System.out.println("생성 실패");
            }
        }// if end
        int menu = -1;
        io.twoPrint("✨✨✨나만의 일기✨✨✨");
        while (true) {
            menuShow();
            menu = io.inNum("입력> ");
            if (menu == 0) {
                io.twoPrint("일기장프로그램을 종료 합니다.");
                break;
            }
            switch (menu) {
                case 1:
                    inputData();
                    break;
                case 2:
                    outputData();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    io.twoPrint("0~5번까지 입력하세요");
                    break;
            }
        }
    }

    private void outputData() {
        io.twoPrint("✨✨✨나의일기들✨✨✨");
        if(list.length==0) {
            io.twoPrint("작성한일기가 없습니다.\n");
            return;
        }
        for(File f : list) {
            io.twoPrint(f.toString());
        }
    }

    private void inputData() {
        io.twoPrint("✨✨✨나만의 일기 작성하기✨✨✨");
        io.twoPrint("===============================");
        Calendar cal = Calendar.getInstance();
        String today = (cal.get(Calendar.YEAR)+""+(cal.get(Calendar.MONTH)+1)+""+(cal.get(Calendar.DATE)));
        try {
            File file = new File("data\\"+today+"-"+cnt+".txt");
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(today+"\n");
            bw.write("제목 : "+io.inStr("제목 : ")+"\n\n");
            bw.write(io.inStr("내용 : "));
            bw.flush();
            System.out.println("저장성공");
            cnt++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            bw.close();
            fw.close();
        }catch (IOException ie) {

        }
    }

    private void menuShow() {
        io.twoPrint("1. 일기저장");
        io.twoPrint("2. 일기읽기");
        io.twoPrint("3. 일기수정");
        io.twoPrint("4. 일기삭제");
        io.twoPrint("5. 일기검색");
        io.twoPrint("0. 종료");
    }
}
