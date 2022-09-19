package com.controller;

import com.dto.ProductInfo;
import com.view.InOutClass;

import java.util.ArrayList;

public class ProductController {

    InOutClass io = new InOutClass();

    ArrayList<ProductInfo> products = new ArrayList<>();

    public void run() {
        int menu = -1;

        io.twoPrint("=제품관리 프로젝트=");
        io.twoPrint("=================");

        while (true) {
            menuShow();
            menu = io.inNum("입력> ");

            if (menu == 0) {
                io.twoPrint("프로그램을 종료합니다.");
                break;
            }

            switch (menu) {
                case 1:
                    inputData();
                    break;
                case 2:
                    outData();
                    break;
                case 3:
                    searchData();
                    break;
                case 4:
                    updateData();
                    break;
                case 5:
                    deleteData();
                    break;
                default:
                    io.twoPrint("잘못입력하셨습니다 1~5까지 안에서 선택해주세요");
                    break;
            } // switch end
        } // while end
    } // run end

    private void deleteData() {
        if (products.size() == 0) {
            io.twoPrint("등록된 제품이 없습니다.");
            return;
        }
        io.twoPrint("=====제품삭제=====");
        io.twoPrint("=================");
        String sname = io.inStr("삭제할 제품이름 입력 : ");
        ProductInfo p = null;
        int i;

        for (i = 0; i < products.size(); i++) {
            p = products.get(i);
            if (p.getProductName().equals(sname)) {
                io.twoPrint("제품 이름 : " + p.getProductName());
                io.twoPrint("제품 가격 : " + p.getProductPrice() + "원");
                io.twoPrint("제품 출시 날짜 : " + p.getProductRelease());
                io.twoPrint("제품 판매 수량 : " + p.getProductQuantity() + "개");
                io.twoPrint("제품 제조업체 : " + p.getProductCompany());
                io.twoPrint("======================");
                break;
            }
        }
        if(i==products.size()) {
            io.twoPrint("삭제할 제품이 없습니다.");
            return;
        }
        String yn = io.inStr("삭제 하시겠습니까? (y/n)");
        if(yn.equals("y")) {
            products.remove(p);
            io.twoPrint("삭제 완료\n");
            return;
        }
        io.twoPrint("삭제 취소\n");
    }

    private void updateData() {
        if(products.size()==0) {
            io.twoPrint("등록된 제품이 없습니다.");
            return;
        }
        io.twoPrint("=====제품수정=====");
        io.twoPrint("=================");
        String sname = io.inStr("수정할 제품이름 입력 : ");
        ProductInfo p =null;
        int i;

        for(i=0; i<products.size(); i++) {
            p=products.get(i);
            if(p.getProductName().equals(sname)) {
                io.twoPrint("제품 이름 : "+p.getProductName());
                io.twoPrint("제품 가격 : "+p.getProductPrice()+"원");
                io.twoPrint("제품 출시 날짜 : "+p.getProductRelease());
                io.twoPrint("제품 판매 수량 : "+p.getProductQuantity()+"개");
                io.twoPrint("제품 제조업체 : "+p.getProductCompany());
                io.twoPrint("======================");
                break;
            }
        }
        if(i==products.size()) {
            io.twoPrint("수정할 제품명이 다릅니다.");
            return;
        }
        io.twoPrint("수정할 내용이 없으면 엔터를 눌러주세요.");
        int unum =io.inNum("제품 가격 : ");
        if(unum!=-1){
            p.setProductPrice(unum);
        }
        String ustr = io.inStr("제품 출시 날짜 : ");
        if(!ustr.equals("")) {
            p.setProductRelease(ustr);
        }
        unum = io.inNum("제품 판매 수량 : ");
        if(unum!=-1) {
            p.setProductQuantity(unum);
        }
        ustr = io.inStr("제품 판매 업체 : ");
        if(!ustr.equals("")) {
            p.setProductCompany(ustr);
        }
        io.twoPrint("수정완료\n");
    }

    private void searchData() {
        if(products.size()==0) {
            io.twoPrint("등록된 제품이 없습니다.");
            return;
        }
        io.twoPrint("=====제품검색=====");
        io.twoPrint("=================");
        String sname = io.inStr("검색할 제품이름 입력 : ");
        for(ProductInfo p : products) {
            if(p.getProductName().equals(sname)) {
                io.twoPrint("제품 이름 : "+p.getProductName());
                io.twoPrint("제품 가격 : "+p.getProductPrice()+"원");
                io.twoPrint("제품 출시 날짜 : "+p.getProductRelease());
                io.twoPrint("제품 판매 수량 : "+p.getProductQuantity()+"개");
                io.twoPrint("제품 제조업체 : "+p.getProductCompany());
                io.twoPrint("검색완료\n");
                return;
            }
        }
        io.twoPrint("찾으시는 제품이 없습니다.");
    }

    private void menuShow() {
        io.twoPrint("1. 제품입력");
        io.twoPrint("2. 제품출력");
        io.twoPrint("3. 제품검색");
        io.twoPrint("4. 제품수정");
        io.twoPrint("5. 제품삭제");
        io.twoPrint("0. 종료");
    }

    private void outData() {
        if(products.size()==0) {
            io.twoPrint("등록된 제품이 없습니다.");
            return;
        }
            io.twoPrint("=====제품출력=====");
            io.twoPrint("=================");
            for(ProductInfo p : products) {
                io.twoPrint("제품 이름 : "+p.getProductName());
                io.twoPrint("제품 가격 : "+p.getProductPrice()+"원");
                io.twoPrint("제품 출시 날짜 : "+p.getProductRelease());
                io.twoPrint("제품 판매 수량 : "+p.getProductQuantity()+"개");
                io.twoPrint("제품 제조업체 : "+p.getProductCompany());
                io.twoPrint("======================");
            }
            io.twoPrint("출력 완료\n");
        }

    private void inputData() {
        io.twoPrint("=====제품입력=====");
        io.twoPrint("=================");

        ProductInfo pInfo = new ProductInfo();
        String pname = io.inStr("제품 이름 : ");
        for(ProductInfo pi : products){
            if(pi.getProductName().equals(pname)){
                io.twoPrint("이미 등록된 제품입니다");
                return;
            }
        }

        pInfo.setProductName(pname);
        pInfo.setProductPrice(io.inNum("제품 가격 : "));
        pInfo.setProductRelease(io.inStr("제품 출시 일자(yyyy-mm-dd) : "));
        pInfo.setProductQuantity(io.inNum("제품 판매 수량 : "));
        pInfo.setProductCompany(io.inStr("제품 제조업체 : "));

        products.add(pInfo);
        io.twoPrint("입력완료 \n");
    }



}
