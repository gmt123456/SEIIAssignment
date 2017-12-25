package nju.lighting.presentation.documentui.lossandgaindoc;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import nju.lighting.presentation.utils.RepositoryHelper;
import nju.lighting.vo.commodity.BasicCommodityItemVO;
import nju.lighting.vo.doc.lossandgaindoc.LossAndGainDocItemVO;
import shared.LossAndGainItemType;

/**
 * Created on 2017/12/25.
 * Description
 *
 * @author 陈俊宇
 */
public class LossAndGainItem {
    SimpleStringProperty name=new SimpleStringProperty();
    SimpleStringProperty id=new SimpleStringProperty();
    SimpleIntegerProperty count=new SimpleIntegerProperty();
    SimpleIntegerProperty repCount=new SimpleIntegerProperty();
    SimpleObjectProperty<LossAndGainItemType> type=new SimpleObjectProperty<>();

    public LossAndGainItem(BasicCommodityItemVO commodity, int number, LossAndGainItemType type){
        name.set(commodity.getName());
        id.set(commodity.getId());
        repCount.set(commodity.getRepCount());
        count.set(number);
        this.type.set(type);
    }
    public LossAndGainItem(LossAndGainDocItemVO vo){
        name.set(vo.getCommodity().getName());
        count.set(vo.getCount());
        id.set(vo.getCommodity().getId());
        repCount.set(vo.getCommodity().getRepCount());
        type.set(vo.getType());
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public int getRepCount() {
        return repCount.get();
    }

    public SimpleIntegerProperty repCountProperty() {
        return repCount;
    }

    public void setRepCount(int repCount) {
        this.repCount.set(repCount);
    }

    public LossAndGainItemType getType() {
        return type.get();
    }

    public SimpleObjectProperty<LossAndGainItemType> typeProperty() {
        return type;
    }

    public void setType(LossAndGainItemType type) {
        this.type.set(type);
    }


    public int getCount() {
        return count.get();
    }

    public SimpleIntegerProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
    }
}
