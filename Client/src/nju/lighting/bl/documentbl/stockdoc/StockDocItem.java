package nju.lighting.bl.documentbl.stockdoc;

/**
 * Description:
 * 进货类单据里的商品条目
 */
public class StockDocItem {

    private int id;
    private String stockDocID;
    private String commodityID;
    private String commodityName;
    private String commodityType;
    private int number = 0;
    private double salePrice = 0;
    private double totalAmount = 0;
    private String remarks = "";

    public StockDocItem() {
    }

    public StockDocItem(int id, String stockDocID, String commodityID, String commodityName, String commodityType,
                        int number, double salePrice, String remarks) {
        this.id = id;
        this.stockDocID = stockDocID;
        this.commodityID = commodityID;
        this.commodityName = commodityName;
        this.commodityType = commodityType;
        this.number = number;
        this.salePrice = salePrice;
        this.remarks = remarks;
    }

    private void updateTotalAmount() {
        totalAmount = number * salePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockDocID() {
        return stockDocID;
    }

    public void setStockDocID(String salesDocID) {
        this.stockDocID = stockDocID;
    }

    public String getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(String commodityID) {
        this.commodityID = commodityID;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        updateTotalAmount();
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
        updateTotalAmount();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}