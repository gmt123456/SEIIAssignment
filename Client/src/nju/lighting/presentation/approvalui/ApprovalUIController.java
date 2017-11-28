package nju.lighting.presentation.approvalui;

import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import nju.lighting.bl.approvalbl.ApprovalBLService_Stub;
import nju.lighting.bl.documentbl.giftdoc.GiftDocItem;
import nju.lighting.blservice.approvalblservice.ApprovalBLService;
import nju.lighting.presentation.documentui.GiftDocController;
import nju.lighting.vo.DocVO;
import nju.lighting.vo.doc.giftdoc.GiftDocVO;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created on 2017/11/27.
 * Description
 *
 * @author 陈俊宇
 */
public class ApprovalUIController implements Initializable {
    ApprovalBLService approvalBLService;
    ArrayList<DocVO> docs;

    @FXML
    JFXListView docList;

    @FXML
    Pane detail;

    @FXML
    Text detailNum;

    @FXML
    Label test;



    @FXML
    public void clicked(MouseEvent event) throws IOException {
        ObservableList list = docList.getSelectionModel().getSelectedItems();
        if (list != null && list.size() != 0) {
            Label clicked = (Label) docList.getSelectionModel().getSelectedItems().get(0);
            int i = findDoc(clicked.getText());
            detailNum.setText("Doc " + i);
            GiftDocController.giftDoc=(GiftDocVO) docs.get(i);
            //detail= FXMLLoader.load(getClass().getResource("../documentui/GiftDoc.fxml"));
            System.out.println("SUCC");
            //detail.setVisible(true);
            detail.getChildren().add(FXMLLoader.load(getClass().getResource("../documentui/GiftDoc.fxml")));
        }
    }

    int findDoc(String Id) {
        for (int i = 0; i < docs.size(); i++) {
            if (Id.equals(docs.get(i).getDocId()))
                return i;
        }
        return -1;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        approvalBLService = new ApprovalBLService_Stub();

        docs = approvalBLService.getDocumentList();

        for (int i = 0; i < docs.size(); i++) {
            Label item = new Label(docs.get(i).getDocId()+""
                   );
            int index = i;
            docList.getItems().add(item);
        }




    }


}
