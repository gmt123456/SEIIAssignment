package nju.lighting.presentation.userui;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nju.lighting.blservice.userblservice.UserBLService;
import nju.lighting.presentation.DialogUI.DialogHelper;
import nju.lighting.presentation.DialogUI.ValidateEventHandle;
import nju.lighting.presentation.factory.UserBLServiceFactory;
import nju.lighting.presentation.mainui.MainUI;
import nju.lighting.presentation.utils.TextFieldHelper;
import nju.lighting.presentation.utils.UserHelper;
import nju.lighting.vo.UserVO;
import shared.Identity;
import shared.ResultMessage;
import shared.UserChangeInfo;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created on 2018/1/3.
 * Description 添加用户的控制类
 *
 * @author 陈俊宇
 */
public class AddUser implements Initializable {
    @FXML
    VBox container;

    @FXML
    JFXTextField userNameText, idText;

    @FXML
    JFXPasswordField passwordText, passwordVerifyText;

    @FXML
    JFXComboBox<Identity> identityBox;

    @FXML
    JFXCheckBox authorityBox;

    @FXML
    HBox passwordVerifyBox;

    UserBLService blService = UserBLServiceFactory.getUserBLService();

    private boolean verify() {
        return verifyExceptPassword() & verifyPassword();
    }

    private boolean verifyExceptPassword() {
        return idText.validate() & userNameText.validate() & identityBox.getValue() != null;
    }

    public boolean verifyPassword() {
        return passwordText.validate() & passwordVerifyText.validate();
    }

    ValidateEventHandle changeHandler(ObservableList<UserVO> userList, UserVO user) {
        userNameText.setText(user.getUsername());
        idText.setText(user.getID());
        identityBox.setValue(user.getIdentity());
        authorityBox.setSelected(user.isAuthority());


        idText.setEditable(false);

        if (user.getIdentity() == Identity.SYSTEM_ADMIN) {
            identityBox.setDisable(true);
            userNameText.setEditable(false);
            idText.getValidators().clear();
            userNameText.getValidators().clear();
        }

        return new ValidateEventHandle() {
            @Override
            public boolean validate()  {
                if (verifyExceptPassword()) {
                    UserChangeInfo.Builder builder = null;
                    try {
                        builder = new UserChangeInfo.Builder(idText.getText());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    builder.changeAuthorized(authorityBox.isSelected())
                            .changeIdentity(identityBox.getValue());

                    if (verifyPassword())
                        builder.changePassword(passwordText.getText());
                    ResultMessage resultMessage = blService.changeUser(builder.build());

                    if (resultMessage == ResultMessage.SUCCESS) {
                        user.setAuthority(authorityBox.isSelected());
                        user.setIdentity(identityBox.getValue());
                        userList.set(userList.indexOf(user), user);
                        return true;
                    } else
                        DialogHelper.dialog("修改",resultMessage, MainUI.getStackPane());

                }
                return false;
            }
        };
    }


    ValidateEventHandle addUserHandler(ObservableList<UserVO> userVOList) {
        return new ValidateEventHandle() {
            @Override
            public boolean validate() {
                ResultMessage resultMessage = null;
                if (verify())
                    resultMessage = blService.addUser(idText.getText(),
                            passwordText.getText(),
                            identityBox.getValue(),
                            userNameText.getText(),
                            authorityBox.isSelected()
                    );
                if (resultMessage == ResultMessage.SUCCESS) {
                    userVOList.add(new UserVO(userNameText.getText(),
                            idText.getText(),
                            identityBox.getValue(),
                            authorityBox.isSelected()));
                    return true;
                } else
                    return false;
            }

        };
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXPasswordField passwordField = new JFXPasswordField();

        TextFieldHelper.addNameValidator(userNameText);
        TextFieldHelper.addRequiredValidator(passwordText);
        TextFieldHelper.addSameValidator(passwordVerifyText, passwordText);
        TextFieldHelper.addIdValidator(idText);

       identityBox.getItems().addAll(Identity.values());
        authorityBox.setText("");
    }
}
