package nju.lighting.vo;

public class StockReturnDocVO extends StockTypeDocVO {

    public StockReturnDocVO(String ID, CustomerVO supplier, String repository, UserVO operator, CommodityListVO commodityList, String remarks){
        this.setID(ID);
        this.setSupplier(supplier);
        this.setRepository(repository);
        this.setOperator(operator);
        this.setCommodityList(commodityList);
        this.setRemarks(remarks);
    }

}
