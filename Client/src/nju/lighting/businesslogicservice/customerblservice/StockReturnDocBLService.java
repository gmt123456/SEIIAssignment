package nju.lighting.businesslogicservice.documentblservice;

import nju.lighting.vo.StockReturnDocVO;

import java.rmi.RemoteException;

public interface StockReturnDocBLService {

    public boolean addStockReturnDoc(StockReturnDocVO stockReturnDoc) throws RemoteException;
}
