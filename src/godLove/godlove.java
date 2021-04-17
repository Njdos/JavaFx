package godLove;

import Connect.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import usersstuff.usersstuff;

import java.io.IOException;
import java.sql.SQLException;

public class godlove {

    usersstuff usersstuff = new usersstuff();
    DatabaseHandler databaseHandler = new DatabaseHandler();

    @FXML
    private Pane panea;

    @FXML
    private Rectangle imageQ11;

    @FXML
    private Text RubricaQ11;

    @FXML
    private Text titleQ11;

    @FXML
    private Text PriceQ11;

    @FXML
    private Button addF1;

    @FXML
    private Button search;

    @FXML
    private Button userSetting;

    @FXML
    private Button messange;

    @FXML
    private Button love;

    @FXML
    private Button home;


    @FXML
    void initialize() {
        try {
            databaseHandler.StuffLoves();
            Image image = new Image(String.valueOf(databaseHandler.ImageQ));
            imageQ11.setFill(new ImagePattern(image));
            titleQ11.setText(databaseHandler.TitleQ);
            RubricaQ11.setText(databaseHandler.RubricaQ);
            PriceQ11.setText(databaseHandler.PriceQ);
        } catch (Exception e) {
            panea.setVisible(false);
        }

        addF1.setOnAction(event -> {
            addF1.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/userstuff/userstuff.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
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
