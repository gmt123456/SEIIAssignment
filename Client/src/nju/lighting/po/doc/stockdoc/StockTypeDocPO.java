package nju.lighting.po.doc.stockdoc;

import nju.lighting.po.doc.DocPO;
import shared.DocType;

import java.util.Date;

public class StockTypeDocPO extends DocPO {

    private String stockTypeDocID;
    private String customerId;
    private String repository;
    private String userId;
    private String remarks = "";
    private double totalAmount = 0;

    public StockTypeDocPO(String id, DocType docType, String userId, Date time,
                          String stockTypeDocID, String customerId, String repository,
                          String userId1, String remarks, double totalAmount) {
        super(id, docType, userId, time);
        this.stockTypeDocID = stockTypeDocID;
        this.customerId = customerId;
        this.repository = repository;
        this.userId = userId1;
        this.remarks = remarks;
        this.totalAmount = totalAmount;
    }

    public String getStockTypeDocID() {
        return stockTypeDocID;
    }

    public void setStockTypeDocID(String stockTypeDocID) {
        this.stockTypeDocID = stockTypeDocID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}