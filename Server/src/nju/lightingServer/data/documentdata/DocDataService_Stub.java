package nju.lightingServer.data.documentdata;

import nju.lighting.blservice.commodityblservice.CommodityBLService;
import nju.lighting.dataservice.documentdataservice.DocDataService;
import nju.lighting.po.doc.DocPO;
import nju.lighting.po.init.InitPO;
import shared.BusinessConditionFilter;
import shared.DocType;
import shared.DocumentFilter;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class DocDataService_Stub implements DocDataService {

    @Override
    public String create(DocType type) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage commitDoc(DocPO doc) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<DocPO> getDocs(DocumentFilter filter) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<DocPO> findSaleRecords(BusinessConditionFilter filter) throws RemoteException {
        return null;
    }

}