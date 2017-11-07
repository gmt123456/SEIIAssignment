package nju.lighting.po.doc.stockdoc;

import shared.DocType;

import java.util.Date;

public class StockReturnDocPO extends StockTypeDocPO {
    public StockReturnDocPO(String id, DocType docType, String userId,
                            Date time, String stockTypeDocID, String customerId,
                            String repository, String userId1, String remarks, double totalAmount) {
        super(id, docType, userId, time, stockTypeDocID, customerId, repository, userId1, remarks, totalAmount);
    }
}
