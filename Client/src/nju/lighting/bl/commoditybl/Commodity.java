package nju.lighting.bl.commoditybl;

import nju.lighting.vo.commodity.CommodityCategoryVO;
import nju.lighting.vo.commodity.CommodityItemVO;
import nju.lighting.vo.commodity.CommodityTreeVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Commodity {

    public CommodityTreeVO getCommodityTree() throws RemoteException {
        return null;
    }

    public ResultMessage addCommodity(CommodityItemVO newCommodity) {
        return null;
    }

    public ArrayList<CommodityItemVO> findCommodityByName(String commodityName) {
        return null;
    }

    public CommodityItemVO findCommodityById(String id) {
        return null;
    }

    public ResultMessage deleteCommodity(String id) {
        return null;
    }

    public ResultMessage modifyCommodity(CommodityItemVO commodity) {
        return null;
    }

    public ResultMessage addCategory(CommodityCategoryVO newCategory) {
        return null;
    }

    public ResultMessage deleteCategory(int id) {
        return null;
    }

    public ResultMessage modifyCategory(CommodityCategoryVO categoryItemVO) {
        return null;
    }
}