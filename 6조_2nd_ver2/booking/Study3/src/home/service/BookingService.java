package home.service;

import home.dao.BookingDao;
import home.dto.BookingDto;

public class BookingService {
BookingDao bDao = new BookingDao();
  //bookinservice
  public String insertData(BookingDto bDto){
    String msg = null;

    int res = bDao.insertData(bDto);

    if (res == 0){
      msg = "입력 실패";
    } else {
      msg = "예약 성공하셨습니다.";
    }
    return msg;
  }

  public String getBookingId(String bookingId) {
    String BookingId = null;
    BookingId = bDao.selectId(bookingId);

    return BookingId;
  }
  public BookingDto getData(String id) {
    BookingDto data = null;
    data = bDao.selectData(id);

    return data;
  }
  public String deleteData(String id) {
    String msg = null;

    int res = bDao.deleteData(id);

    if (res > 0){
      msg = "예약 취소하셨습니다.";
    }
    else {
      msg = "예약 취소 실패하셨습니다";
    }

    return msg;
  }


}
