package nju.lighting.data.promotiondata;

import nju.lighting.dataservice.promotiondataservice.PromotionDataService;
import nju.lighting.po.CustomerGrade;
import nju.lighting.po.PromotionPO;
import shared.ResultMessage;

import java.util.ArrayList;

/**
 * Created on 2017/10/22.
 * Description
 *
 * @author 陈俊宇
 */
public class PromotionDataService_Stub implements PromotionDataService {
    @Override
    public ArrayList<PromotionPO> getBenefitsPlan(int customerLevel, ArrayList<String> commodityList, double total) {
        PromotionPO promotionPO=new PromotionPO(3,10000,20000,null,399,null,null,
                50,0,0);
        ArrayList<PromotionPO> promotionPOs=new ArrayList<>();
        promotionPOs.add(promotionPO);

        return promotionPOs;
    }

    @Override
    public ArrayList<PromotionPO> getPromotionList() {

        PromotionPO po1=new PromotionPO(1,10000,20000, CustomerGrade.THREE,0,null,null,
                10,0,0);

        ArrayList<PromotionPO> promotionPOs=new ArrayList<>();
        promotionPOs.add(po1);
        return promotionPOs;
    }

    @Override
    public ResultMessage insert(PromotionPO po) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage update(PromotionPO po) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage delete(PromotionPO po) {
        return ResultMessage.SUCCESS;
    }
}
