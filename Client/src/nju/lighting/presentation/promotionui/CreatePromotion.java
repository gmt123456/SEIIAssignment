package nju.lighting.presentation.promotionui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import nju.lighting.blservice.promotionblservice.PromotionBLService;
import nju.lighting.presentation.DialogUI.DialogHelper;
import nju.lighting.presentation.documentui.CommodityItem;
import nju.lighting.presentation.documentui.CommodityList;
import nju.lighting.presentation.factory.PromotionBLServiceFactory;
import nju.lighting.presentation.mainui.Client;
import nju.lighting.presentation.utils.CommodityHelper;
import nju.lighting.presentation.utils.DateHelper;
import nju.lighting.presentation.utils.TextFieldHelper;
import nju.lighting.vo.commodity.BasicCommodityItemVO;
import nju.lighting.vo.doc.giftdoc.GiftItemVO;
import nju.lighting.vo.promotion.PromotionVO;
import shared.PromotionBuildInfo;
import shared.PromotionType;
import shared.Result;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created on 2017/12/28.
 * Description 创建促销策略的控制类，里面有所有促销策略相同的一部分，然后根据选择出啊关键的类型建在其他部分
 *
 * @author 陈俊宇
 */
public class CreatePromotion implements Initializable {
    @FXML
    VBox verticalBox;
    @FXML
    Button chooseCommodityBtn;
    @FXML
    Pane tableContainer;
    @FXML
    JFXButton commit;
    @FXML
    JFXTextField nameText;
    @FXML
    JFXDatePicker startDatePicker, endDatePicker;
    @FXML
    StackPane stackPane;
    @FXML
    Label totalLabel;
    private PromotionUIManageUI upper;
    private ObservableList<BasicCommodityItemVO> commodities = FXCollections.observableArrayList();
    private ObservableList<CommodityItem> itemList;
    private HashMap<PromotionType, String> typeToUrl = new HashMap<>();
    private HashMap<PromotionType, EventHandler> typeToEventHandle = new HashMap<>();
    private FXMLLoader typeLoader;
    private PromotionBLService blService = PromotionBLServiceFactory.getPromotionBLService();

    private Result<PromotionVO> commitPriceOriented() {
        PromotionBuildInfo.Builder builder = createBuilder(PromotionType.PriceOriented);
        CreatePriceOriented controller = typeLoader.getController();
        if (itemList.size() != 0 || (controller.getVoucherEndDate() != null)) {
            builder.price(controller.getPrice())
                    .goods(getGiftList())
                    .vouchers(controller.getVoucher(), controller.getVoucherEndDate());
            System.out.println("succ commit");
            return blService.commit(builder);
        } else return null;
    }

    private Result<PromotionVO> commitCombo() {
        CreateCombo controller = typeLoader.getController();
        if (itemList.size() != 0 & controller.getOff() > 0) {
            PromotionBuildInfo.Builder builder = createBuilder(PromotionType.Combo);
            builder.goods(getGiftList())
                    .off(controller.getOff());
            return blService.commit(builder);
        } else return null;
    }

    private Result<PromotionVO> commitCustomerOriented() {
        CreateCustomerOriented controller = typeLoader.getController();

        PromotionBuildInfo.Builder builder = createBuilder(PromotionType.CustomerOriented);

        if (itemList.size() != 0 || controller.getOff() > 0 || controller.getVoucherEndDate() != null) {
            builder.level(controller.getLevel())
                    .goods(getGiftList())
                    .off(controller.getOff())
                    .vouchers(controller.getVoucher(), controller.getVoucherEndDate());

            return blService.commit(builder);
        } else
            return null;
    }


    public void setType(PromotionType type) throws IOException {

        typeLoader = new FXMLLoader(getClass().getResource(typeToUrl.get(type)));
        verticalBox.getChildren().add(typeLoader.load());
        commit.setOnAction(event -> {
            if (verify()) {
                Result<PromotionVO> res;
                switch (type) {
                    case Combo:
                        res = commitCombo();
                        break;
                    case PriceOriented:
                        res = commitPriceOriented();
                        break;
                    case CustomerOriented:
                        res = commitCustomerOriented();
                        break;
                    default:
                        res = null;
                        break;
                }
                if (res != null) {
                    if (res.hasValue()) {
                        upper.getPromotionList().add(res.getValue());
                        upper.backToMain();
                    } else
                        DialogHelper.dialog("提交促销策略", res.getResultMessage(), stackPane);
                }
            }
        });
    }


    private boolean verify() {
        return nameText.validate() & startDatePicker.getValue() != null & endDatePicker.getValue() != null;
    }

    private PromotionBuildInfo.Builder createBuilder(PromotionType type) {
        return new PromotionBuildInfo.Builder(
                nameText.getText(),
                type,
                DateHelper.localDateToDate(startDatePicker.getValue()),
                DateHelper.localDateToDate(endDatePicker.getValue()), Client.getUserVO());
    }

    private List<GiftItemVO> getGiftList() {
        return itemList.stream()
                .map(x -> new GiftItemVO(x.getCommodity(), x.getCount()))
                .collect(Collectors.toList());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TextFieldHelper.addRequiredValidator(nameText);

        typeToUrl.put(PromotionType.Combo, "CreateCombo.fxml");
        typeToUrl.put(PromotionType.CustomerOriented, "CreateCustomerOrientedUI.fxml");
        typeToUrl.put(PromotionType.PriceOriented, "CreatePriceOrientedUI.fxml");


        chooseCommodityBtn.setOnAction(e -> CommodityHelper.chooseCommodity(upper, commodities));
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("nju/lighting/presentation/documentui/CommodityList.fxml"));
        try {
            tableContainer.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        CommodityList controller = loader.getController();
        controller.setGiftAndEditable();
        itemList = controller.getGiftObservableList();
        totalLabel.textProperty().bind(controller.getTotal().asString());

        commodities.addListener(CommodityHelper.getListChangeListener(itemList));
    }

    public void setUpper(PromotionUIManageUI upper) {
        this.upper = upper;
    }

}
