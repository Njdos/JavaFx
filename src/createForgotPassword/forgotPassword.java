package createForgotPassword;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class forgotPassword {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ForgotPasswordClose;

    @FXML
    private JFXButton ButtonSendCode;

    @FXML
    private JFXTextField ForgotPasswordEmailSend;

    @FXML
    void initialize() {

//Close Forgot Password Window
        ForgotPasswordClose.setOnAction(event -> {
            ForgotPasswordClose.getScene().getWindow().hide();
        });
    }
}
