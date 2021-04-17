package createNewAccount;

import Animation.Shake;
import Connect.DatabaseHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class registerUser {


    @FXML
    private JFXPasswordField registerConfirmPassword;

    @FXML
    private JFXButton registerCreateNewAccount;

    @FXML
    private JFXTextField registerFirstName;

    @FXML
    private JFXPasswordField registerPassword;

    @FXML
    private JFXTextField registerLastName;

    @FXML
    private JFXTextField registerEmailAddress;

    @FXML
    private JFXTextField registerPhoneNumber;

    @FXML
    private DatePicker registerDate;

    @FXML
    private JFXTextField registerUserName;

    @FXML
    private ComboBox<String> registerLocation;

    @FXML
    private RadioButton radioButton1;

    @FXML
    private RadioButton radioButton2;

    @FXML
    private Button registerClose;

    @FXML
    void initialize(){

//Choise Location
        DatabaseHandler databaseHandler = new DatabaseHandler();
        ObservableList<String> list = FXCollections.observableArrayList("Ukaraine","Russia");
        registerLocation.setItems(list);

//Close Window
        registerClose.setOnAction(event -> registerClose.getScene().getWindow().hide());

//Create New Account
        registerCreateNewAccount.setOnAction(event -> {

//Audit
        boolean fsddfsd = false;
        boolean fsddfsd13 = false;
        boolean fsddfsd15 = false;
            try {
                fsddfsd =  databaseHandler.UserNameRepeat(registerUserName.getText().trim());
            } catch (SQLException | ClassNotFoundException ignored) {}
            try {
                fsddfsd13 =  databaseHandler.EmailRepeated(registerEmailAddress.getText().trim());
            } catch (SQLException | ClassNotFoundException ignored) {}
            try {
                fsddfsd15 =  databaseHandler.PhoneReapet(registerPhoneNumber.getText().trim());
            } catch (SQLException | ClassNotFoundException ignored) {}
            try {
                registerLocation.getValue().isEmpty();
            }catch (NullPointerException e ){
                Shake userLoginF10 = new Shake(registerLocation);
                userLoginF10.playAnim();
            }if ((registerFirstName.getText().trim()).equals("")){
                Shake userLoginF10 = new Shake(registerFirstName);
                userLoginF10.playAnim();
            } if ((registerLastName.getText().trim()).equals("")){
                Shake userLoginF10 = new Shake(registerLastName);
                userLoginF10.playAnim();
            }  if (!fsddfsd){
                Shake userLoginF10 = new Shake(registerUserName);
                userLoginF10.playAnim();
            } if (!fsddfsd13){
                Shake userLoginF10 = new Shake(registerEmailAddress);
                userLoginF10.playAnim();
            }if (!fsddfsd15){
                Shake userLoginF10 = new Shake(registerPhoneNumber);
                userLoginF10.playAnim();
            }if ((registerUserName.getText().trim()).equals("")){
                Shake userLoginF10 = new Shake(registerUserName);
                userLoginF10.playAnim();
            }  if (!(registerPassword.getText().trim()).equals(registerConfirmPassword.getText().trim())){
                Shake userLoginF10 = new Shake(registerConfirmPassword);
                userLoginF10.playAnim();
            } if ((registerPassword.getText().trim()).equals("")){
                Shake userLoginF10 = new Shake(registerPassword);
                userLoginF10.playAnim();
            } if ((registerConfirmPassword.getText().trim()).equals("")){
                Shake userLoginF10 = new Shake(registerConfirmPassword);
                userLoginF10.playAnim();
            } if ((registerEmailAddress.getText().trim()).equals("")){
                Shake userLoginF10 = new Shake(registerEmailAddress);
                userLoginF10.playAnim();
            } if ((registerPhoneNumber.getText().trim()).equals("")){
                Shake userLoginF10 = new Shake(registerPhoneNumber);
                userLoginF10.playAnim();
            } if (!radioButton1.isSelected() && !radioButton2.isSelected()){
                Shake userLoginF10 = new Shake(radioButton1);
                userLoginF10.playAnim();
                Shake userLoginF11 = new Shake(radioButton2);
                userLoginF11.playAnim();
            }if (registerDate.getEditor().getText().trim().equals("")){
                Shake userLoginF10 = new Shake(registerDate);
                userLoginF10.playAnim();
            }  else if ((radioButton1.isSelected() || radioButton2.isSelected()) && !(registerPhoneNumber.getText().trim().equals("")) && !(registerEmailAddress.getText().trim().equals("")) && !(registerConfirmPassword.getText().trim().equals("")) && !((registerPassword.getText().trim()).equals("")) && !((registerFirstName.getText().trim()).equals("")) && !((registerLastName.getText().trim()).equals("")) && !((registerUserName.getText().trim()).equals("")) && ((registerPassword.getText().trim()).equals(registerConfirmPassword.getText().trim())) && fsddfsd==true && fsddfsd13 && fsddfsd15==true){
                if (radioButton1.isSelected()){
                    String genderS = "Male";
                    try {  LocalDate ld = registerDate.getValue();
                        databaseHandler.SignUpUser(registerFirstName.getText().trim(),registerLastName.getText().trim(),registerUserName.getText().trim(),ld.toString().trim(),registerPassword.getText().trim(),registerEmailAddress.getText().trim(),registerPhoneNumber.getText().trim(),registerLocation.getValue().trim(),genderS);
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                }
                else{String genderS = "Female";
                    try {        LocalDate ld = registerDate.getValue();
                        databaseHandler.SignUpUser(registerFirstName.getText().trim(), registerLastName.getText().trim(), registerUserName.getText().trim(), ld.toString().trim(), registerPassword.getText().trim(), registerEmailAddress.getText().trim(), registerPhoneNumber.getText().trim(),registerLocation.getValue().trim(), genderS);
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                }
                registerCreateNewAccount.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/sample.fxml"));
                try { loader.load(); }
                catch (IOException e) { e.printStackTrace(); }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
    }
}
