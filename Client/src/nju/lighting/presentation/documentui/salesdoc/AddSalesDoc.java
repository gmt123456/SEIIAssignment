package nju.lighting.presentation.documentui.salesdoc;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import nju.lighting.bl.documentbl.DocController;
import nju.lighting.blservice.documentblservice.DocBLService;
import nju.lighting.blservice.promotionblservice.PromotionBLService;
import nju.lighting.presentation.documentui.AddDoc;
import nju.lighting.presentation.documentui.CommodityItem;
import nju.lighting.presentation.documentui.CommodityList;
import nju.lighting.presentation.factory.PromotionBLServiceFactory;
import nju.lighting.presentation.mainui.Client;
import nju.lighting.presentation.mainui.Upper;
import nju.lighting.presentation.utils.*;
import nju.lighting.vo.CustomerVO;
import nju.lighting.vo.DocVO;
import nju.lighting.vo.UserVO;
import nju.lighting.vo.commodity.BasicCommodityItemVO;
import nju.lighting.vo.doc.giftdoc.GiftDocVO;
import nju.lighting.vo.doc.salesdoc.SalesDocItemVO;
import nju.lighting.vo.doc.salesdoc.SalesDocVO;
import nju.lighting.vo.doc.salesdoc.SalesReturnDocVO;
import nju.lighting.vo.promotion.PromotionVO;
import shared.CustomerType;
import shared.PromotionType;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AddSalesDoc extends AddDoc implements Initializable, Upper {
    private PromotionBLService promotionBLService =
            PromotionBLServiceFactory.getPromotionBLService();
    @FXML
    private HBox container, promotionBox;
    @FXML
    private VBox verticalVBox;
    @FXML
    private Pane commodityContainer;

    @FXML
    private Button choseCustomBtn, promotionBtn;

    @FXML
    private JFXTextField customer, accountBeforeDis, discount,
            voucher, account, promotionText;

    @FXML
    private JFXComboBox<UserVO> salesmanBox;

    @FXML
    JFXComboBox<String> repositoryBox;
    @FXML
    private TextArea remarks;
    @FXML
    private Label sub, title;


    private ObservableList<BasicCommodityItemVO> commodityList = FXCollections.observableArrayList();
    private ObservableList<CommodityItem> docItemList;
    private SimpleObjectProperty<CustomerVO> customerProperty = new SimpleObjectProperty<>();
    private SimpleObjectProperty<PromotionVO> promotionProperty = new SimpleObjectProperty<>();
    private CommodityList commodityListController;
    private PromotionVO promotionVO;
    private DocBLService docBLService = new DocController();
    private Upper upper = this;
    private boolean hasMax = true;

    public void chooseCommodity() {
        CommodityHelper.chooseCommodity(upper, commodityList);
    }

    public void chooseCustomer() {
        CustomerHelper.setCustomer(upper, customerProperty, CustomerType.SALESPERSON);
    }


    public void choosePromotion() throws IOException {
        PromotionHelper.setPromotion(upper, promotionProperty, promotionBLService.getBenefitsPlan(
                customerProperty.getValue().getGrade(),
                commodityList.stream()
                        .map(BasicCommodityItemVO::getId)
                        .collect(Collectors.toList()),
                commodityListController.getTotal().doubleValue()
        ));

    }


    public void back() {
        setChildren(mainPane, "");
    }

    @Override
    public void setChildren(Node node, String title) {
        container.getChildren().setAll(node);
        sub.setText(title);
    }

    protected SalesDocVO getDoc() {
        if (customer.validate() & docItemList.size() > 0)
            return new SalesDocVO(new Date(), Client.getUserVO().getID(), customerProperty.getValue().getID(),
                    salesmanBox.getValue().getID(), repositoryBox.getValue(), remarks.getText(),
                    Double.parseDouble(discount.getText()),
                    Double.parseDouble(voucher.getText()),
                    docItemList.stream()
                            .map(CommodityItem::toSalesDocItem)
                            .collect(Collectors.toList()));
        else return null;
    }

    SalesReturnDocVO getReturnDoc() {
        if (customer.validate() & docItemList.size() > 0)
            return new SalesReturnDocVO(new Date(), Client.getUserVO().getID(), customerProperty.getValue().getID(),
                    salesmanBox.getValue().getID(), repositoryBox.getValue(), remarks.getText(),
                    Double.parseDouble(discount.getText()),
                    Double.parseDouble(voucher.getText()),
                    docItemList.stream()
                            .map(CommodityItem::toSalesDocItem)
                            .collect(Collectors.toList()));
        else return null;
    }


    /**
     * 提交赠品单
     */
    private void commitGift() {
        PromotionVO promotion = promotionProperty.getValue();
        if (promotion != null
                && promotion.getType() != PromotionType.Combo
                && promotion.getGoods() != null
                && promotion.getGoods().size() != 0) {
            docBLService.commitDoc(new GiftDocVO(new Date(),
                    promotion.getCreator().getID(),
                    promotion.getGoods(),
                    customerProperty.getValue().getID()));
        }
    }


    //当重要参数发生变化时清除正在作用的promotion
    private void clearPromotion() {
        if (promotionText != null)
            promotionText.setText("");
        promotionVO = null;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TextFieldHelper.addDeleteMenuItem(customer, customerProperty);
        TextFieldHelper.addDeleteMenuItem(promotionText, promotionProperty);

        repositoryBox.getItems().add("默认仓库");
        repositoryBox.setValue(repositoryBox.getItems().get(0));


        UserHelper.intiUserBox(salesmanBox);


        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("nju/lighting/presentation/documentui/CommodityList.fxml"));
        try {
            commodityContainer.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        commodityListController = loader.getController();
        commodityListController.setEditable();
        commodityListController.setMaxSize(480, 700);

        docItemList = commodityListController.getGiftObservableList();

        customer.textProperty().addListener(c -> {
            if (customer.getText() != "")
                promotionBtn.setDisable(false);
        });

        commodityList.addListener(CommodityHelper.getListChangeListener(docItemList,hasMax));

        customerProperty.addListener(c -> {
            if (customerProperty.getValue() != null) {
                customer.setText(customerProperty.getValue().getName());
                salesmanBox.setValue(UserHelper.getSalesman(salesmanBox, customerProperty.getValue().getSalesman()));

            } else {
                customer.setText("");
                salesmanBox.setValue(null);
            }
            clearPromotion();

        });

        promotionProperty.addListener(c -> {
            clearPromotion();
            if (promotionProperty.getValue() != null) {
                promotionVO = promotionProperty.getValue();
                promotionText.setText(promotionVO.getName());
            } else {
                promotionText.setText("");
            }


        });

        //监听，如果价总价变化 account跟着变化
        accountBeforeDis.textProperty().bind(commodityListController.getTotal().asString());

        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                account.setText("" + (
                        Double.parseDouble(accountBeforeDis.textProperty().get())
                                - Double.parseDouble(discount.textProperty().get())
                                - Double.parseDouble(voucher.textProperty().get())
                ));
            }
        };

        TextFieldHelper.addDoubleValidator(discount);
        TextFieldHelper.addDoubleValidator(voucher);


        discount.textProperty().addListener(changeListener);
        voucher.textProperty().addListener(changeListener);
        accountBeforeDis.textProperty().addListener(c -> {
            clearPromotion();
            account.setText("" + (
                    Double.parseDouble(accountBeforeDis.textProperty().get())
                            - Double.parseDouble(discount.textProperty().get())
                            - Double.parseDouble(voucher.textProperty().get())
            ));
        });


        TextFieldHelper.addRequiredValidator(customer);

        commitBtn.setOnAction(e -> {
            DocHelper.commitDoc(getDoc());
            commitGift();
        });

        TextFieldHelper.addDeleteMenuItem(customer, customerProperty);
        TextFieldHelper.addDeleteMenuItem(promotionText, promotionProperty);
    }

    void setReturn() {
        title.setText("制定销售退货单");
        verticalVBox.getChildren().remove(promotionBox);
        hasMax = false;
        commitBtn.setOnAction(e -> DocHelper.commitDoc(getReturnDoc()));
    }

    void init(Upper upper, List<SalesDocItemVO> itemList, int customerID, String remarks,
              String voucher, String discount, boolean hasMax) {
        this.upper = upper;
        docItemList.setAll(itemList.stream()
                .map(x -> new CommodityItem(x, hasMax))
                .collect(Collectors.toList()));

        customerProperty.set(CustomerHelper.getCustomer(customerID));

        this.remarks.setText(remarks);

        this.voucher.setText(voucher);

        this.discount.setText(discount);
    }

    @Override
    public void modify(Upper upper, DocVO docVO, boolean redFlush) {
        SalesDocVO salesDocVO = (SalesDocVO) docVO;
        init(upper, salesDocVO.getItems(), salesDocVO.getCustomerId(),
                salesDocVO.getRemarks(), salesDocVO.getVoucher() + "",
                salesDocVO.getDiscount() + "", true);
        verticalVBox.getChildren().remove(promotionBox);
        super.modify(upper, docVO, redFlush);
    }


    public Button getCommitBtn() {
        return commitBtn;
    }


}
