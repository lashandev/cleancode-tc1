package com.epic.techtalk.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;


public class Invoice {
    String invoiceNo;
    Date dateInvoiced;
    Double total;
    Double discount;
    Double netTotal;
    List<InvoiceItem> invoiceItems;

    public Invoice() {
    }

    public Invoice(String invoiceNo, Date dateInvoiced, Double total, Double discount, Double netTotal, List<InvoiceItem> invoiceItems) {
        this.invoiceNo = invoiceNo;
        this.dateInvoiced = dateInvoiced;
        this.total = total;
        this.discount = discount;
        this.netTotal = netTotal;
        this.invoiceItems = invoiceItems;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getDateInvoiced() {
        return dateInvoiced;
    }

    public void setDateInvoiced(Date dateInvoiced) {
        this.dateInvoiced = dateInvoiced;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(Double netTotal) {
        this.netTotal = netTotal;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }
}
