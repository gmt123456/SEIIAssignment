package nju.lighting.po.doc.costdoc;

import shared.CostDocItemType;

import javax.persistence.*;

/**
 * Created on 2017/10/21.
 * Description:
 * @author Liao
 */
@Entity
@Table(name = "COST_DOC_ITEM")
public class CostDocItemPO {

    private int id;

    private CostDocItemType type;

    private String costDocID;

    private double amount;

    private String comment;

    public CostDocItemPO() {
    }

    public CostDocItemPO(CostDocItemType type, String costDocID, double amount, String comment) {
        this.type = type;
        this.costDocID = costDocID;
        this.amount = amount;
        this.comment = comment;
    }

    public CostDocItemPO(int id, CostDocItemType type, String costDocID, double amount, String comment) {
        this.id = id;
        this.type = type;
        this.costDocID = costDocID;
        this.amount = amount;
        this.comment = comment;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "COST_DOC_ID", nullable = false, length = 36)
    public String getCostDocID() {
        return costDocID;
    }

    public void setCostDocID(String costDocID) {
        this.costDocID = costDocID;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false, length = 20)
    public CostDocItemType getType() {
        return type;
    }

    public void setType(CostDocItemType type) {
        this.type = type;
    }

    @Column(name = "AMOUNT", nullable = false)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "COMMENT", length = 300)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}