package nju.lighting.bl.commoditybl;

import nju.lighting.blservice.commodityblservice.CommodityBLService;
import nju.lighting.vo.commodity.CommodityCategoryVO;
import nju.lighting.vo.commodity.CommodityItemVO;
import nju.lighting.vo.commodity.CommodityTreeVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class CommodityController implements CommodityBLService {

    @Override
    public CommodityTreeVO getCommodityTree() throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage addCommodity(CommodityItemVO newCommodity) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<CommodityItemVO> findCommodityByName(String commodityName) throws RemoteException {
        return null;
    }

    @Override
    public CommodityItemVO findCommodityById(String id) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage deleteCommodity(String id) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage modifyCommodity(CommodityItemVO commodity) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage addCategory(CommodityCategoryVO newCategory) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage deleteCategory(int id) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage modifyCategory(CommodityCategoryVO categoryItemVO) {
        return null;
    }
}
