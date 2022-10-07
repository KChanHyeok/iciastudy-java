package com.service;

import com.dao.DataDao;
import com.dto.DataDto;

import java.util.List;

public class DataService {
    //Dao를 사용하여 DB에 data를 저장하고 결과를 controller에게 알림.
    private DataDao dDao = new DataDao();

    public String insertData(DataDto data) {
        String msg = null;

        //Dao를 사용하여 저장
        int res = dDao.insertData(data);

        if (res == 0) {
            msg = "Insert Fail";
        }else {
            msg = "Insert Success";
        }

        return msg;
    }

    public List<DataDto> getList() {
        // Dao에게 DB로 부터 데이터를 검색하여 목록을 가져오게 시킴
        List<DataDto> gList = dDao.selectList();

        //박은 목록을 controller에게 전달.
        return gList;
    }
}
