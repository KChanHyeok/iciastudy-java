package home.service;

import home.dao.RoomTypeDao;

public class RoomTypeService {
RoomTypeDao tDao = new RoomTypeDao();
  //roomTypeservice
  public String roomType(String rType) {
    String getRoomType = null;
    getRoomType = tDao.selectRtype(rType);

    return getRoomType;
  }

}
