package com.dto;

public class ProductInfo {
    private String productName; //제품 이름
    private String productRelease; //제품 출시 일자
    private String productCompany; //제품 제조업체
    private int productPrice; //제품 가격
    private int productQuantity; // 제품 수량

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductRelease() {
        return productRelease;
    }

    public void setProductRelease(String productRelease) {
        this.productRelease = productRelease;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
