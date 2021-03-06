package nju.lighting.presentation.documentui.salesdoc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import nju.lighting.presentation.documentui.CommodityItem;
import nju.lighting.presentation.documentui.CommodityList;
import nju.lighting.presentation.documentui.Doc;
import nju.lighting.presentation.utils.CustomerHelper;
import nju.lighting.presentation.utils.UserHelper;
import nju.lighting.vo.doc.salesdoc.SalesReturnDocVO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created on 2018/1/5.
 * Description
 *
 * @author 陈俊宇
 */
public class SalesReturnDoc implements Initializable {

    @FXML
    HBox  tableContainer;

    @FXML
    Label customer, creator, salesman, repository, comments,accountBefore,discount,voucher,account,idLabel;


    SalesReturnDocVO salesReturnDocVO;
    public SalesReturnDoc() {
        salesReturnDocVO = (SalesReturnDocVO) Doc.getDoc();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        customer.setText(CustomerHelper.getCustomer(salesReturnDocVO.getCustomerId()).getName());
        creator.setText(UserHelper.getUserString(salesReturnDocVO.getCreatorId()));
        salesman.setText(UserHelper.getUserString(salesReturnDocVO.getSalesman()));
        repository.setText(salesReturnDocVO.getRepository());
        comments.setText(salesReturnDocVO.getRemarks());
        account.setText(salesReturnDocVO.getFinalAmount()+"");
        accountBefore.setText(salesReturnDocVO.getBeforeDiscountAmount()+"");
        discount.setText(salesReturnDocVO.getDiscount()+"");
        voucher.setText(salesReturnDocVO.getVoucher()+"");
        idLabel.setText(salesReturnDocVO.getDocId());

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("nju/lighting/presentation/documentui/CommodityList.fxml"));
        try {
            tableContainer.getChildren().add(loader.load());
            ((CommodityList) loader.getController()).getGiftObservableList()
                    .addAll(salesReturnDocVO.getItems().stream()
                            .map(x -> new CommodityItem(x))
                            .collect(Collectors.toList()));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
