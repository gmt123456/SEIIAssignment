package nju.lighting.bl.documentbl.lossandgaindoc;

import nju.lighting.bl.documentbl.Doc;
import nju.lighting.po.doc.DocPO;
import nju.lighting.vo.DocVO;
import nju.lighting.vo.doc.lossandgaindoc.LossAndGainDocVO;
import shared.DocType;
import shared.ResultMessage;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created on 2017/11/7.
 * Description: 处理库存报损报溢相关业务
 * @author iznauy
 */
public class LossAndGainDoc extends Doc {

    private ArrayList<LossAndGainDocItem> items;

    public LossAndGainDoc(String id, DocType docType, String userId, Date time, ArrayList<LossAndGainDocItem> items) {
        super(id, docType, userId, time);
        this.items = items;
    }

    @Override
    public void approve() {

    }

    @Override
    public ResultMessage reject() {
        return null;
    }

    @Override
    public ResultMessage modify() {
        return null;
    }

    @Override
    public DocVO createVO() {
        return null;
    }

    @Override
    public DocPO createPO() {
        return null;
    }
}