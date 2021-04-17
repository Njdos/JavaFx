package godMessage;

import Connect.DatabaseHandler;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class godmessange {

    DatabaseHandler databaseHandler = new DatabaseHandler();

    @FXML
    private JFXTextField firstname;

    @FXML
    private TextArea area;

    @FXML
    private TextField field;

    @FXML
    private Button send;

    @FXML
    private Ellipse Userphoto;

    @FXML
    private JFXTextField User;

    @FXML
    private JFXTextField lastname;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField phone;

    @FXML
    private Button search;

    @FXML
    private Button userSetting;

    @FXML
    private Button love;

    @FXML
    private Button messange;

    @FXML
    private Button home;

    @FXML
    void initialize() {

// load details of users
        try {
            databaseHandler.MessangesUser();
            Image imageset3 = new Image(String.valueOf(databaseHandler.ImageM));
            Userphoto.setFill(new ImagePattern(imageset3));
            firstname.setText(databaseHandler.FirstM);
            lastname.setText(databaseHandler.LastM);
            User.setText(databaseHandler.UserM);
            email.setText(databaseHandler.EmailM);
            phone.setText(databaseHandler.phoneM);
        } catch (Exception e) { e.printStackTrace(); }

//send messange
        send.setOnAction(event -> {
            area.setText(area.getText()+" \n"+field.getText());
            field.clear();
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

//Go to tab with Add
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

//Go to tab with User Setting
        userSetting.setOnAction(event -> {
            userSetting.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/godAvatar/godAvatar.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
