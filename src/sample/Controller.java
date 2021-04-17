package sample;

import Animation.Shake;
import Connect.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class Controller {

    @FXML
    private JFXTextField UserSignInF;

    @FXML
    private JFXPasswordField PasswordSignInF;

    @FXML
    private JFXButton ButtonSighInF;

    @FXML
    private Hyperlink ForgotPasswordF;

    @FXML
    private JFXButton CreateNewAccountF;

    @FXML
    private Button CloseSignInF;

    DatabaseHandler databaseHandler = new DatabaseHandler();

    @FXML
    void initialize(){

//Press on buttonn "Create New Account"
        CreateNewAccountF.setOnAction(event -> {
            CreateNewAccountF.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/createNewAccount/newAccount.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });


//Press on button 'Sign In'
        ButtonSighInF.setOnAction(event -> {

// Get Entry details
            String TextFUser = UserSignInF.getText().trim();
            String TextFPassword = PasswordSignInF.getText().trim();

// Pass details of account
            try {
                databaseHandler.SignInWebSite(TextFUser, TextFPassword);
                 if (TextFPassword.isEmpty()){
                    Shake userLoginF10 = new Shake(PasswordSignInF);
                    userLoginF10.playAnim();
                }if (TextFUser.isEmpty()){
                    Shake userLoginF64 = new Shake(UserSignInF);
                    userLoginF64.playAnim();

// Mistake in user
                }if (DatabaseHandler.getIdq()==0){
                    Shake userLoginF456 = new Shake(UserSignInF);
                    userLoginF456.playAnim();

// Mistake in password, user correct
                }else if (DatabaseHandler.getIdq()==5){
                    Shake userLoginF10 = new Shake(PasswordSignInF);
                    userLoginF10.playAnim();

//  User and password is Correct
                }else if (DatabaseHandler.getIdq()==7){
                    ButtonSighInF.getScene().getWindow().hide(); }
            } catch (SQLException | ClassNotFoundException throwables) { throwables.printStackTrace(); }
        });

//Close Window
        CloseSignInF.setOnAction(event -> CloseSignInF.getScene().getWindow().hide());

//Forgot password
        ForgotPasswordF.setOnAction(event -> {
            ForgotPasswordF.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/createForgotPassword/forgotPassword.fxml"));
            try { loader.load(); } catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}

