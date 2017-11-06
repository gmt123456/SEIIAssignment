package nju.lighting.po;

import nju.lighting.po.commodity.CommodityItemPO;

public class CommodityListItemPO {

    private CommodityItemPO commodity;
    private String commodityID;
    private String name;
    private String commodityType;
    private int number = 0;
    private double salePrice = 0;
    private double totalAmount = 0;
    private String remarks = "";

    public String getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(String commodityID) {
        this.commodityID = commodityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        totalAmount = number * salePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public CommodityItemPO getCommodity() {
        return commodity;
    }

    public void setCommodity(CommodityItemPO commodity) {
        this.commodity = commodity;
        commodityID = commodity.getId();
        name = commodity.getName();
        commodityType = commodity.getCommodityType();
        salePrice = commodity.getRecentSalePrice();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
