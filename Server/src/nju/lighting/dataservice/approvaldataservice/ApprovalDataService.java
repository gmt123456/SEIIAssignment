package nju.lighting.dataservice.approvaldataservice;

import shared.ResultMessage;


import java.util.ArrayList;

/**
 * Created on 2017/10/21.
 * Description
 *
 * @author 陈俊宇
 */
public interface ApprovalDataService {
    ArrayList<HistoryDocPO> getDocumentList();

    ResultMessage update(HistoryDocPO po);

}
