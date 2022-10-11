package com.service;

import com.dao.BoardDao;
import com.dto.BoardInfo;

public class BoardServiceClass {
    BoardDao bDao = new BoardDao();

    public String insertBoard(BoardInfo bInfo) {
        String msg = null;
        int res = bDao.insertBoard(bInfo);
        if(res != 0 ) {
            msg = "글작성 완료";
        }else {
            msg = "글작성 실패";
        }
        return msg;
    }
}
