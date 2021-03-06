package nju.lighting.po.doc.lossandgaindoc;

import nju.lighting.po.doc.DocPO;
import shared.DocType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "LOSS_AND_GAIN_DOC")
public class LossAndGainDocPO extends DocPO {

    private static final long serialVersionUID = 6918970037634014229L;
    private String comment;

    private List<LossAndGainItemPO> itemPOS;

    public LossAndGainDocPO() {

    }

    public LossAndGainDocPO(String id, DocType docType, String userId,
                            Date time, String comment) {
        super(id, docType, userId, time);
        this.comment = comment;
    }

    public LossAndGainDocPO(String id, DocType docType, String userId,
                            Date time, String comment, List<LossAndGainItemPO> itemPOS) {
        super(id, docType, userId, time);
        this.comment = comment;
        this.itemPOS = itemPOS;
    }

    @Column(name = "COMMENT", length = 300)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Transient
    public List<LossAndGainItemPO> getItemPOS() {
        return itemPOS;
    }

    public void setItemPOS(List<LossAndGainItemPO> itemPOS) {
        this.itemPOS = itemPOS;
    }

    @Override
    @Transient
    public List<Object> getItems() {
        List<Object> list = new ArrayList<>();
        list.addAll(this.itemPOS);
        return list;
    }

    @Override
    public void setItems(List<Object> list) {
        this.itemPOS = new ArrayList<>();
        for (Object o: list) {
            itemPOS.add((LossAndGainItemPO)o);
        }
    }
}
