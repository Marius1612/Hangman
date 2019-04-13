package sample;

import constants.ApplicationConstants;
import helper.Utility;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Controller {
    public MenuItem mnuItmChangeCategories;
    public TextField txtFieldUserName;
    public PasswordField passwordField;
    public Button btnLogin;
    public TabPane tabPane;
    public Tab tabLogin;
    public Tab tabPlay;
    public Label lblUsername;
    public Label lblPassword;
    public Tab tabCategories;
    public TextField txtFieldCategoryName;
    public Button btnAddCategory;

    public void loginAction(ActionEvent actionEvent) {
        if (btnLogin.getText().equals(ApplicationConstants.BTN_LOGIN_TEXT)) {
            {
                if (txtFieldUserName.getText().equals(ApplicationConstants.APP_PASSWORD)
                        && passwordField.getText().equals(ApplicationConstants.APP_PASSWORD)) {
                    btnLogin.setText(ApplicationConstants.BTN_LOGOUT_TEXT);
                    lblPassword.setTextFill(Color.BLACK);
                    lblUsername.setTextFill(Color.BLACK);
                    tabPane.getTabs().get(2).setDisable(false);
                    tabPane.getSelectionModel().select(tabCategories);
                }

                else {
                    lblPassword.setTextFill(Color.RED);
                    lblUsername.setTextFill(Color.RED);
                }
            }
        } else {
            btnLogin.setText(ApplicationConstants.BTN_LOGIN_TEXT);
            tabPane.getSelectionModel().select(tabPlay);
            tabPane.getTabs().get(1).setDisable(true);
        }
    }

    public void activateLoginTab(ActionEvent actionEvent) {
        tabPane.getTabs().get(1).setDisable(false);
        tabPane.getSelectionModel().select(tabLogin);
    }

    public void loginEnterKey(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            loginAction(null);
        }
    }

    public void addCategory(ActionEvent actionEvent) {
if(!txtFieldCategoryName.getText().isEmpty())
{
    Utility.createCategoryFile(txtFieldCategoryName.getText());
}
    }
}