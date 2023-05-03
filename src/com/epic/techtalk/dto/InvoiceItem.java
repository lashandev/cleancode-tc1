package com.epic.techtalk.dto;


import java.util.Date;

public class InvoiceItem {
    String productCode;
    Double unitPrice;
    Integer quantity;
    Date datePurchased;

    public InvoiceItem() {
    }

    public InvoiceItem(String productCode, Double unitPrice, Integer quantity, Date datePurchased) {
        this.productCode = productCode;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.datePurchased = datePurchased;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(Date datePurchased) {
        this.datePurchased = datePurchased;
    }
}
