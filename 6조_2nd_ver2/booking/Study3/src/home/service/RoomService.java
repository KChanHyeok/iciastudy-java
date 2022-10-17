package home.service;

import home.dao.RoomDao;

public class RoomService {
RoomDao rDao = new RoomDao();
  //Roomservice
  public String getBookingRoom(int bookingRnum) {
    String getBookingR = null;
    getBookingR = rDao.selectBr(bookingRnum);

    return getBookingR;

  }
}
