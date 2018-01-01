package nju.lighting.presentation.commodityui;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import nju.lighting.presentation.factory.CommodityBLServiceFactory;
import nju.lighting.vo.commodity.BasicCommodityItemVO;
import nju.lighting.vo.commodity.CommodityItemVO;

/**
 * Created on 2018/1/1.
 * Description
 *
 * @author 陈俊宇
 */
public class Predicate {

    @FXML
    HBox imageContainer;

    void init(CommodityItemVO commodityItemVO){
        CommodityBLServiceFactory.getCommodityBLService().getTrend(commodityItemVO.getId());
    }
}
