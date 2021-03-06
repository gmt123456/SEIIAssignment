package nju.lighting.po.promotion;


import shared.CustomerGrade;
import shared.PromotionType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * Created on 2017/10/19.
 * Description:
 * @author 陈俊宇
 */
@Entity
@Table(name = "PROMOTION")
public class PromotionPO implements Serializable {
    private static final long serialVersionUID = 213143123109L;
    private int id; //id

    private String creatorId;

    private String name; //促销策略名称

    private PromotionType type;  //促销策略类型

    private Date startDate;  //起始日期

    private Date endDate;  //截止日期

    private Date time; //创建时间

    private CustomerGrade level; //针对不同级别用户中用户的级别

    private double total;  //针对不同总价的促销策略中的总价

    private List<PromotionPackageItemPO> goods; //组合特价包裹

    private double off;  //折让金额

    private double vouchers; //代金券金额

    private Date vouchersEndDate;  //代金券截止日期

    public PromotionPO() {
    }

    @Override
    public String toString() {
        return "PromotionPO{" +
                "id=" + id +
                ", creatorId='" + creatorId + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", time=" + time +
                ", level=" + level +
                ", total=" + total +
                ", goods=" + goods +
                ", off=" + off +
                ", vouchers=" + vouchers +
                ", vouchersEndDate=" + vouchersEndDate +
                '}';
    }

    @Column(name = "CREATOR_ID", nullable = false, length = 20)
    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public PromotionPO(String creatorId, String name, PromotionType type,
                       Date startDate, Date endDate, Date time, CustomerGrade level, double total,
                       List<PromotionPackageItemPO> goods, double off, double vouchers, Date vouchersEndDate) {
        this.creatorId = creatorId;
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.level = level;
        this.total = total;
        this.goods = goods;
        this.off = off;
        this.vouchers = vouchers;
        this.vouchersEndDate = vouchersEndDate;
    }

    public PromotionPO(String name, PromotionType type, Date startDate, Date endDate, CustomerGrade level,
                       double total, List<PromotionPackageItemPO> goods, double off, double vouchers, Date vouchersEndDate) {
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
        this.total = total;
        this.goods = goods;
        this.off = off;
        this.vouchers = vouchers;
        this.vouchersEndDate = vouchersEndDate;
    }

    public PromotionPO(String name, PromotionType type, Date startDate, Date endDate,
                       Date time, CustomerGrade level, double total, List<PromotionPackageItemPO> goods,
                       double off, double vouchers, Date vouchersEndDate) {
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.level = level;
        this.total = total;
        this.goods = goods;
        this.off = off;
        this.vouchers = vouchers;
        this.vouchersEndDate = vouchersEndDate;
    }

    @Column(name = "NAME", length = 36, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGood(PromotionPackageItemPO good) {
        goods.add(good);
    }

    public void removeGood(PromotionPackageItemPO good) {
        goods.remove(good);
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "PROMOTION_TYPE", length = 20, nullable = false)
    public PromotionType getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(PromotionType type) {
        this.type = type;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, name = "CUSTOMER_GRADE")
    public CustomerGrade getLevel() {
        return level;
    }

    public void setLevel(CustomerGrade level) {
        this.level = level;
    }

    @Column(name = "TOTAL", nullable = false)
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Column(nullable = false, name = "OFF")
    public double getOff() {
        return off;
    }

    public void setOff(double off) {
        this.off = off;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    @Transient
    public List<PromotionPackageItemPO> getGoods() {
        return goods;
    }

    public void setGoods(List<PromotionPackageItemPO> goods) {
        this.goods = goods;
    }

    @Column(name = "START_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "END_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "CREATE_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Column(name = "VOUCHER", nullable = false)
    public double getVouchers() {
        return vouchers;
    }

    public void setVouchers(double vouchers) {
        this.vouchers = vouchers;
    }

    @Column(name = "VOUCHER_END_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getVouchersEndDate() {
        return vouchersEndDate;
    }

    public void setVouchersEndDate(Date vouchersEndDate) {
        this.vouchersEndDate = vouchersEndDate;
    }

}
