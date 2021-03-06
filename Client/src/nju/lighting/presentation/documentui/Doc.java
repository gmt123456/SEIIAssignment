package nju.lighting.presentation.documentui;

import javafx.fxml.FXMLLoader;
import nju.lighting.vo.DocVO;
import shared.DocType;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created on 2017/12/2.
 * Description 起到根据 type分配 url 的作用， 分配的是查看单据的url
 *
 * @author 陈俊宇
 */
public class Doc {
    private static DocVO doc;
    private static HashMap<DocType, String> map = new HashMap<>();

    static {
        map.put(DocType.GIFT, "giftdoc/GiftDoc.fxml");
        map.put(DocType.ACCOUNT_IN, "accountiodoc/AccountIODoc.fxml");
        map.put(DocType.ACCOUNT_OUT, "accountiodoc/AccountIODoc.fxml");
        map.put(DocType.LOSS_AND_GAIN, "lossandgaindoc/LossAndGainDoc.fxml");
        map.put(DocType.SALES, "salesdoc/SalesDoc.fxml");
        map.put(DocType.SALES_RETURN, "salesdoc/SalesReturnDoc.fxml");
        map.put(DocType.STOCK, "stockdoc/StockDoc.fxml");
        map.put(DocType.STOCK_RETURN, "stockdoc/StockReturnDoc.fxml");
        map.put(DocType.ALERT, "alertdoc/AlertDoc.fxml");
        map.put(DocType.COST, "costdoc/CostDoc.fxml");


    }


    public static FXMLLoader getLoader() throws IOException {
        return new FXMLLoader(Doc.class.getResource(map.get(doc.getType())));
    }

    public static DocVO getDoc() {
        return doc;
    }

    public static void setDoc(DocVO doc) {
        Doc.doc = doc;
    }
}
