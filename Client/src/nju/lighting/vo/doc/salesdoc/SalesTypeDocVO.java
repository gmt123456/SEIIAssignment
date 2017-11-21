package nju.lighting.vo.doc.salesdoc;

import nju.lighting.vo.DocVO;
import shared.DocType;

import java.util.Date;

public class SalesTypeDocVO extends DocVO {

    private String salesTypeDocID;
    private String customerId;
    private String salesman;
    private String repository;
    private String remarks;
    private double beforeDiscountAmount = 0;
    private double discount = 0;
    private double voucher = 0;
    private double finalAmount = 0;

    public SalesTypeDocVO(Date time, String creatorId, String docId, DocType type,
                          String salesTypeDocID, String customerId, String salesman,
                          String repository, String remarks,
                          double beforeDiscountAmount, double discount,
                          double voucher, double finalAmount) {
        super(time, creatorId, docId, type);
        this.salesTypeDocID = salesTypeDocID;
        this.customerId = customerId;
        this.salesman = salesman;
        this.repository = repository;
        this.remarks = remarks;
        this.beforeDiscountAmount = beforeDiscountAmount;
        this.discount = discount;
        this.voucher = voucher;
        this.finalAmount = finalAmount;
    }

    public String getSalesTypeDocID() {
        return salesTypeDocID;
    }

    public void setSalesTypeDocID(String salesTypeDocID) {
        this.salesTypeDocID = salesTypeDocID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getBeforeDiscountAmount() {
        return beforeDiscountAmount;
    }

    public void setBeforeDiscountAmount(double beforeDiscountAmount) {
        this.beforeDiscountAmount = beforeDiscountAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getVoucher() {
        return voucher;
    }

    public void setVoucher(double voucher) {
        this.voucher = voucher;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.beforeDiscountAmount = beforeDiscountAmount;
    }
}