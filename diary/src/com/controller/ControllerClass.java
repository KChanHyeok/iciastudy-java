package com.controller;

import com.dto.DiaryInfo;
import com.view.InOutClass;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Calendar;

public class ControllerClass {
    InOutClass io = new InOutClass();
    File folder = new File("data");
    ArrayList<DiaryInfo> dList = new ArrayList<>();

    public void run() {
        int menu = -1;
        io.twoPrint("✨✨✨나만의 일기✨✨✨");

        if (!folder.isDirectory()) {
            if (folder.mkdir()) { //폴더 생성 메소드 mkdir()
                System.out.println("생성 성공");
            } else {
                System.out.println("생성 실패");
            }
        }// if end

        if (folder.exists()) {
            File[] list = folder.listFiles();
            for (File f : list) {
                if (f.isFile()) {
                    FileReader fr = null;
                    BufferedReader br = null;
                    try {
                        fr = new FileReader(f);
                        br = new BufferedReader(fr);

                        DiaryInfo dInfo = new DiaryInfo();
                        String str = null;
                        int count = 1;
                        while ((str = br.readLine()) != null) {
                            switch (count) {
                                case 1:
                                    dInfo.setNo(Integer.parseInt(str));
                                    break;
                                case 2:
                                    dInfo.setDate(str);
                                    break;
                                case 3:
                                    dInfo.setTitle(str);
                                    break;
                                default:
                                    dInfo.setContent(str);
                                    break;
                            }
                            count++;
                        }
                        dList.add(dInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            br.close();
                            fr.close();
                        } catch (IOException e) {
                        }
                    }
                }
            }
        }

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
                    updateData();
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

    private void updateData() {
        if (dList.size() == 0) {
            io.twoPrint("수정할 일기가 없습니다.");
            return;
        }
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            io.twoPrint("✨✨✨나의 일기 수정하기✨✨✨");
            io.twoPrint("===============================");
            File[] flist = folder.listFiles();
            String date;
            for (File f : flist) {
                io.twoPrint(f.toString());
            }
            date = io.inStr("수정할 파일이름을 입력해주세요 : ");
            int i;
            DiaryInfo d = null;
            for (i = 0; i < dList.size(); i++) {
                d = dList.get(i);
                if ((d.getDate() + "-" + (i + 1)).equals(date)) {
                    String title = io.inStr("제목 : ");
                    d.setTitle(title);
                    String content = io.inStr("내용 : ");
                    d.setContent(content);
                    File file = new File("data\\" + d.getDate() + "-" + d.getNo() + ".txt");
                    fw = new FileWriter(file, true);
                    new FileOutputStream(file).close();
                    bw = new BufferedWriter(fw);
                    bw.write(d.getNo() + "\n");
                    bw.write(d.getDate() + "\n");
                    bw.write(title + "\n");
                    bw.write(content + "\n");
                    bw.flush();
                    io.twoPrint("수정완료되었습니다.\n");
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            } catch (NullPointerException np) {
                io.twoPrint("찾으시는 일기가 없습니다.");
                return;
            }
        }

    }

    private void outputData() {
        if (dList.size() == 0) {
            io.twoPrint("저장된 일기가 없습니다.");
            return;
        }
        io.twoPrint("✨✨✨나만의 일기 전체보기✨✨✨");
        io.twoPrint("===============================");
        for (DiaryInfo f : dList) {
            io.twoPrint("넘버 : " + f.getNo());
            io.twoPrint("작성일자 : " + f.getDate());
            io.twoPrint("제목 : " + f.getTitle());
            io.twoPrint("내용 : " + f.getContent());
            io.twoPrint("======================");
        }

    }

    private void inputData() {
        io.twoPrint("✨✨✨나만의 일기 작성하기✨✨✨");
        io.twoPrint("===============================");

        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            int no;
            if (dList.size() == 0) {
                no = 1;
            } else {
                no = getLastNum() + 1;
            }
            Calendar cal = Calendar.getInstance();
            DiaryInfo dInfo = new DiaryInfo();

            String year = cal.get(Calendar.YEAR) + "";
            int month = (cal.get(Calendar.MONTH) + 1);
            int day = cal.get(Calendar.DATE);
            String today = year + String.format("%02d", month) + String.format("%02d", day);

            File file = new File("data\\" + today + "-" + no + ".txt");
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);

            dInfo.setNo(no);
            bw.write(no + "\n");
            dInfo.setDate(today);
            bw.write(today + "\n");
            String title = io.inStr("제목 : ");
            dInfo.setTitle(title);
            bw.write(title + "\n");
            String content = io.inStr("내용 : ");
            dInfo.setContent(content);
            bw.write(content + "\n");
            dList.add(dInfo);
            bw.flush();
            io.twoPrint("저장성공");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }

    }

    private int getLastNum() {
        int lno = 0;
        int n = this.dList.size();
        DiaryInfo d = dList.get(n - 1);
        lno = d.getNo();
        return lno;
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
