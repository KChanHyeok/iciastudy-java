package com.controller;

import com.dto.BoardInfo;
import com.service.BoardServiceClass;
import com.view.BoardViewClass;

public class BoardController {

    BoardViewClass bView = new BoardViewClass();
    BoardServiceClass bServ = new BoardServiceClass();

    public void run() {
        while (true) {
            int menu = -1;
            menu = bView.firstShowMenu();
            if(menu == 0) {
                bView.message("게시판을 종료합니다");
                break;
            }
            switch (menu) {
                case 1:
                    intputBoard();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    bView.message("0~5 사이의 숫자만 입력하세요");
                    break;
            }
        }
    }

    private void intputBoard() {
        String msg = null;
        BoardInfo bInfo = new BoardInfo();

        bView.inputBoard(bInfo);

        msg = bServ.insertBoard(bInfo);
        bView.message(msg);
    }
}
