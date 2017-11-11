package nju.lighting.vo;

import shared.DocType;

import java.util.Date;

public class StockReturnDocVO extends StockTypeDocVO {
    public StockReturnDocVO(Date time, String creatorId, String docId,
                            DocType type, String stockTypeDocID,
                            String customerId, String repository,
                            String userId, String remarks, double totalAmount) {
        super(time, creatorId, docId, type, stockTypeDocID, customerId, repository, userId, remarks, totalAmount);
    }
}