package com.service;


import com.dao.BookingDao;
import com.dao.MemberDao;
import com.dto.BookingDto;

public class MemberService {

    MemberDao mDao = new MemberDao();

    public String getMemberId(String name, String phone) {
        String userId = null;
        userId = mDao.selectMemberId(name, phone);
        return userId;
    }

}
