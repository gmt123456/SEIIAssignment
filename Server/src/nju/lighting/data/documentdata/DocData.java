package nju.lighting.data.documentdata;

import nju.lighting.dataservice.documentdataservice.DocDataService;
import nju.lighting.po.doc.DocPO;
import shared.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 2017/11/27.
 * Description: 用于DocData模块请求的分发
 *
 * @author iznauy
 */
public class DocData implements DocDataService {

    private AccountIODocData accountIODocData;

    private AlertDocData alertDocData;

    private CostDocData costDocData;

    private GiftDocData giftDocData;

    private LossAndGainDocData lossAndGainDocData;

    public DocData() {

    }

    private AccountIODocData getAccountIODocData() {
        if (accountIODocData == null)
            accountIODocData = new AccountIODocData();
        return accountIODocData;
    }

    private AlertDocData getAlertDocData() {
        if (alertDocData == null)
            alertDocData = new AlertDocData();
        return alertDocData;
    }

    private CostDocData getCostDocData() {
        if (costDocData == null)
            costDocData = new CostDocData();
        return costDocData;
    }

    private GiftDocData getGiftDocData() {
        if (giftDocData == null)
            giftDocData = new GiftDocData();
        return giftDocData;
    }

    private LossAndGainDocData getLossAndGainDocData() {
        if (lossAndGainDocData == null)
            lossAndGainDocData = new LossAndGainDocData();
        return lossAndGainDocData;
    }



    @Override
    public TwoTuple<ResultMessage, String> commitDoc(DocPO doc) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage updateDoc(DocPO doc) throws RemoteException {
        return null;
    }

    @Override
    public List<DocPO> findByUserId(String id) throws RemoteException {
        return null;
    }

    @Override
    public List<DocPO> findByState(DocState docState) throws RemoteException {
        return null;
    }

    @Override
    public List<DocPO> findByType(DocType type) throws RemoteException {
        return null;
    }

    @Override
    public List<DocPO> findByTime(Date from, Date to) throws RemoteException {
        return null;
    }

    @Override
    public List<DocPO> findByTimeAndType(Date from, Date to, DocType type) throws RemoteException {
        return null;
    }
}
