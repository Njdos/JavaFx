package godAvatar;

import Animation.Shake;
import Connect.DatabaseHandler;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import usersstuff.usersstuff;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;

public class godavatar {

        @FXML
        private Ellipse Userphoto;

        @FXML
        private JFXTextField User;

        @FXML
        private JFXTextField Password;

        @FXML
        private JFXTextField Email;

        @FXML
        private JFXTextField Number;

        @FXML
        private Button Edit;

        @FXML
        private Button Save;

        @FXML
        private ComboBox<String> Language;

        @FXML
        private ComboBox<String> Color;

        @FXML
        private Button ChangeImage;

        @FXML
        private Button messange;

        @FXML
        private Button love;

        @FXML
        private Button home;

        @FXML
        private Button search;

        @FXML
        private ImageView Pen;

        DatabaseHandler databaseHandler = new DatabaseHandler();

    static private String images ;
    static private String languages ;
    static private String colors ;

    @FXML
    void initialize()  {

//Display user data
        User.setText(databaseHandler.getUserA());
        Password.setText(databaseHandler.getPasswordA());
        Email.setText(databaseHandler.getEmailA());
        Number.setText(databaseHandler.getPhoneA());
        Language.setPromptText(DatabaseHandler.getLanguageA());
        Color.setPromptText(DatabaseHandler.getTemaA());
        Image imageset = new Image(String.valueOf(DatabaseHandler.getImageA()));
        Userphoto.setFill(new ImagePattern(imageset));
        Pen.setVisible(false);
        ChangeImage.setVisible(false);
        Color.setDisable(true);
        Language.setDisable(true);

//Edit User
        Edit.setOnAction(event -> {
            User.setEditable(true);
            Password.setEditable(true);
            Email.setEditable(true);
            Number.setEditable(true);
            Save.setVisible(true);
            Edit.setVisible(false);
            Pen.setVisible(true);
            ChangeImage.setVisible(true);
            Color.setDisable(false);
            Language.setDisable(false);
            ObservableList<String> list1 = FXCollections.observableArrayList("English","Russia");
            Language.setItems(list1);
            ObservableList<String> list2 = FXCollections.observableArrayList("Blue","Red");
            Color.setItems(list2);
        });

//Go to tab with Suggestions
        home.setOnAction(event -> {
            home.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/godstars/godstart.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

//Change User Image
        ChangeImage.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            URI fil1 = file.toURI();
            Image image = new Image(String.valueOf(fil1));
            Userphoto.setFill(new ImagePattern(image));
            images=fil1.toString();
        });

//Go to tab with Liked the suggestions
        love.setOnAction(event -> {
            love.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/godLove/godLove.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

//Go to tab with Messanges
        messange.setOnAction(event -> {
            messange.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/godMessage/godMessage.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

//Go to tab with User Setting
        search.setOnAction(event -> {
            search.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/godAdd/godAdd.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

//Change details User
        Save.setOnAction(event -> {

//Change Photos Users
            try {
                images.isEmpty(); }
            catch (NullPointerException e) { images = "file:/C:/Users/Admin/IdeaProjects/TestProgect/src/icon/user.png";}
            catch (Exception e){images = "file:/C:/Users/Admin/IdeaProjects/TestProgect/src/icon/user.png";}

//Change Language Users
            try {
                Language.getValue().isEmpty();
                languages = Language.getValue().trim(); }
            catch (NullPointerException e) { languages = databaseHandler.getLanguageA();}
            catch (Exception e){languages = databaseHandler.getLanguageA();}

//Change Color Users
            try {
                Color.getValue().isEmpty();
                colors = Color.getValue().trim();}
            catch (NullPointerException e) { colors = databaseHandler.getTemaA();}
            catch (Exception e){colors = databaseHandler.getTemaA();}

//Audit New Details
            try { databaseHandler.EditUser(User.getText().trim(),Email.getText().trim(),Number.getText().trim()); }
            catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }

//New Details User
            if (User.getText().trim().isEmpty() || DatabaseHandler.user2 ==false){
                Shake userLoginF10 = new Shake(User);
                userLoginF10.playAnim();}
            boolean passsword1 =false;
            if (Password.getText().trim().isEmpty()){
                Shake userLoginF10 = new Shake(Password);
                userLoginF10.playAnim();}else {passsword1 = true;}
            if (Email.getText().trim().isEmpty() || DatabaseHandler.user3 ==false){
                Shake userLoginF10 = new Shake(Email);
                userLoginF10.playAnim();}
            if (Number.getText().trim().isEmpty() || DatabaseHandler.user4 ==false){
                Shake userLoginF10 = new Shake(Number);
                userLoginF10.playAnim();}

//If New Details Correct Change
            if (DatabaseHandler.user2 ==true && DatabaseHandler.user3 ==true && databaseHandler.user4==true && passsword1==true){
            try { databaseHandler.EdirAllest(User.getText().trim(),Password.getText().trim(),Email.getText().trim(),Number.getText().trim(),images,languages,colors); }
            catch (SQLException | ClassNotFoundException ignored){}
                User.setEditable(false);
                Password.setEditable(false);
                Email.setEditable(false);
                Number.setEditable(false);
                Pen.setVisible(false);
                ChangeImage.setVisible(false);
                Save.setVisible(false);
                Edit.setVisible(true);}
                Color.setDisable(true);
                Language.setDisable(true);
        });
    }
}
