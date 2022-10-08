package com.service;

import com.dao.DiaryDao;
import com.dto.DiaryInfo;

import java.util.List;

public class DiaryService {

    DiaryDao dDao = new DiaryDao();
    public String insertDiary(DiaryInfo dInfo) {
        String msg =null;
        int res = dDao.insertDiary(dInfo);

        if(res != 0) {
            msg = "일기작성 완료";
        }else {
            msg = "일기작성 실패";
        }
        return msg;
    }

    public List<DiaryInfo> getList() {
        List<DiaryInfo> gList = dDao.selectList();
        return gList;
    }
}
