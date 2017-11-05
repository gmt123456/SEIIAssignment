package nju.lighting.po;

import java.util.ArrayList;

/**
 * Created on 2017/10/18.
 * Description:
 * @author Liao
 */
public class CostDocPO extends DocPO {
    private String accountID;
    private ArrayList<CostDocItemPO> itemList;
    private int total;

    public CostDocPO(String accountID, ArrayList<CostDocItemPO> itemList, int total) {
        this.accountID = accountID;
        this.itemList = itemList;
        this.total = total;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public ArrayList<CostDocItemPO> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<CostDocItemPO> itemList) {
        this.itemList = itemList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
