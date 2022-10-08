package com.controller;

import com.dao.DiaryDao;
import com.dto.DiaryInfo;
import com.service.DiaryService;
import com.view.DiaryView;

import java.lang.invoke.CallSite;
import java.util.List;

public class DiaryController {
    DiaryView dView = new DiaryView();
    DiaryService dServ = new DiaryService();

    public void run() {
        while (true) {
            int menu = -1;
            menu = dView.firstShowMenu();

            if (menu == 0) {
                dView.message("일기장을 종료합니다.");
                break;
            }
            switch (menu) {
                case 1:
                    inputDiary();
                    break;
                case 2:
                    outputDiary();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    dView.message("0~5까지 숫자만 입력하시오");
                    break;
            }
        }
    }

    private void outputDiary() {
        List<DiaryInfo> dList = dServ.getList();
        dView.outputList(dList);
    }

    private void inputDiary() {
        String msg = null;
        DiaryInfo dInfo = new DiaryInfo();

        dView.inputDiary(dInfo);

        msg = dServ.insertDiary(dInfo);
        dView.message(msg);
    }

}
