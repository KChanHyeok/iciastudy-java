package com.service;

import com.dao.RoomTypeDao;
import com.dto.RoomType;

public class RoomTypeService {
    RoomTypeDao rDao = new RoomTypeDao();

    public RoomType getRoomType(String roomType) {
        RoomType rDto = null;
        rDto = rDao.getRoomType(roomType);
        return rDto;
    }

    public String updateInput(RoomType rDto) {
        String msg = null;
        int res = rDao.updateRoomType(rDto);
        if(res != 0) {
            msg = "변경성공";
        }else {
            msg = "변경실패";
        }
        return msg;
    }
}
