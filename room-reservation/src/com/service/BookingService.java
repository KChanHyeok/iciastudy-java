package com.service;

import com.dao.BookingDao;
import com.dto.BookingDto;

public class BookingService {

    BookingDao bDao = new BookingDao();
    public BookingDto getBooking(String userId) {
        BookingDto bDto = null;

        bDto = bDao.getBooking(userId);

        return bDto;
    }

    public String updateBooking(BookingDto bDto) {
        String msg = null;
        int res =bDao.updateBooking(bDto);
        if(res != 0) {
            msg = "변경 성공";
        }else {
            msg = "변경실패";
        }
        return msg;
    }
}
