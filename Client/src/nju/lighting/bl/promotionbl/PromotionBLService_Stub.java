package nju.lighting.bl.promotionbl;

import nju.lighting.bl.approvalbl.ApprovalBLService_Stub;
import nju.lighting.bl.userbl.UserBLServie_Stub;
import nju.lighting.blservice.promotionblservice.PromotionBLService;
import nju.lighting.vo.DocVO;
import nju.lighting.vo.UserVO;
import nju.lighting.vo.commodity.BasicCommodityItemVO;
import nju.lighting.vo.commodity.BasicCommodityTreeVO;
import nju.lighting.vo.doc.giftdoc.GiftDocVO;
import nju.lighting.vo.doc.giftdoc.GiftItemVO;
import nju.lighting.vo.promotion.ComboPromotionVO;
import nju.lighting.vo.promotion.CustomerOrientedPromotionVO;
import nju.lighting.vo.promotion.PriceOrientedVO;
import nju.lighting.vo.promotion.PromotionVO;
import shared.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 2017/10/21.
 * Description
 *
 * @author 陈俊宇
 */
public class PromotionBLService_Stub implements PromotionBLService {

    @Override
    public List<PromotionVO> getBenefitsPlan(CustomerGrade customerLevel, ArrayList<String> CommodityList, double total) {
        BasicCommodityItemVO commodityVO1 = new BasicCommodityItemVO("xx0002222", "日本LED无障碍灯泡", null,
                100, 100, 100);
        BasicCommodityItemVO commodityVO2 = new BasicCommodityItemVO("xx0002223", "日本LED无障碍灯泡" + "-b", null,
                100, 100, 100);

        ArrayList<GiftItemVO> gifts1 = new ArrayList<>();

        GiftItemVO giftItemVO1 = new GiftItemVO(commodityVO1, 10);
        GiftItemVO giftItemVO2 = new GiftItemVO(commodityVO2, 1);

        gifts1.add(giftItemVO1);
        gifts1.add(giftItemVO2);

        UserVO creator=new UserBLServie_Stub().getUser("0");

        PromotionVO promotionVo1 = new CustomerOrientedPromotionVO("店庆酬宾",creator,PromotionType.CustomerOriented,
                null,null,CustomerGrade.FIVE,gifts1,0,0,null);
        PromotionVO promotionVo2 = new ComboPromotionVO("店庆酬宾",creator,PromotionType.Combo,null,null,
                gifts1,300,50);

        ArrayList<PromotionVO> promotionVOs = new ArrayList<>();
        promotionVOs.add(promotionVo1);
        promotionVOs.add(promotionVo2);

        return promotionVOs;
    }

    @Override
    public ArrayList<PromotionVO> getPromotionList() {
        UserVO creator=new UserBLServie_Stub().getUser("0");
        ArrayList<DocVO> gifts=((new ApprovalBLService_Stub().getDocumentList()));
        PromotionVO vo1 =new CustomerOrientedPromotionVO("店庆酬宾",creator,PromotionType.CustomerOriented,
                new Date(),new Date(),CustomerGrade.FIVE,null,30,0,null);
        PromotionVO vo2 =  new PriceOrientedVO("店庆酬宾",creator,PromotionType.PriceOriented,new Date(),new Date(),
                150,0,
                ((GiftDocVO)gifts.get(0)).getGiftItemListVO().getGiftItemVOs(),
                300,new Date());
        PromotionVO vo3 =  new PriceOrientedVO("店庆酬宾",creator,PromotionType.PriceOriented,new Date(),new Date(),
                150,0, null, 300,new Date());

        ArrayList<PromotionVO> promotionVOs = new ArrayList<>();
        promotionVOs.add(vo1);
        promotionVOs.add(vo2);
        promotionVOs.add(vo3);

        return promotionVOs;
    }

    @Override
    public BasicCommodityTreeVO create() {
        return null;
    }

    @Override
    public TwoTuple<ResultMessage, Integer> commit(PromotionBuildInfo info) {
        return null;
    }

    @Override
    public ResultMessage modify(PromotionVO vo) {
        return null;
    }

    @Override
    public ResultMessage delete(int promotionID) {
        return ResultMessage.FAILURE;
    }
}
