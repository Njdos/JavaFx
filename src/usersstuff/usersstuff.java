package usersstuff;

import Connect.DatabaseHandler;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class usersstuff {

    @FXML
    private Rectangle MainPhotoo;

    @FXML
    private Rectangle PhotoN22;

    @FXML
    private Rectangle PhotoN33;

    @FXML
    private Rectangle PhotoN44;

    @FXML
    private Button SendMessange;

    @FXML
    private Text tip;

    @FXML
    private Text price;

    @FXML
    private JFXTextArea opise;

    @FXML
    private Rectangle Loving1;

    @FXML
    private Button love1;

    @FXML
    private Text title;

    @FXML
    private Button userSetting;

    @FXML
    private Button messange;

    @FXML
    private Button home;

    @FXML
    private Button love;

    @FXML
    private Button search;


    DatabaseHandler databaseHandler = new DatabaseHandler();

    @FXML
    void initialize() {

//send messange
        SendMessange.setOnAction(event -> {
            SendMessange.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/godMessage/godMessage.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

//add to love lab
        love1.setOnAction(event -> {
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

//load photo
        Image imageL1 = new Image("file:/C:/Users/Admin/IdeaProjects/TestProgect/src/icon/icons8-лайк-с-заливкой-100.png");
        Loving1.setFill(new ImagePattern(imageL1));

        Image image1 = new Image(String.valueOf(databaseHandler.ImageA1));
        MainPhotoo.setFill(new ImagePattern(image1));
        Image image2 = new Image(String.valueOf(databaseHandler.ImageA2));
        PhotoN22.setFill(new ImagePattern(image2));
        Image image3 = new Image(String.valueOf(databaseHandler.ImageA3));
        PhotoN33.setFill(new ImagePattern(image3));
        Image image4 = new Image(String.valueOf(databaseHandler.ImageA4));
        PhotoN44.setFill(new ImagePattern(image4));
        title.setText(databaseHandler.TitleA);
        tip.setText(databaseHandler.RubricaA);
        price.setText(databaseHandler.PriceA);
        opise.setText(databaseHandler.OpisA);

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