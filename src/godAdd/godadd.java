package godAdd;

import Animation.Shake;
import Connect.DatabaseHandler;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;

public class godadd {


    @FXML
    private Rectangle MainPhotoo;

    @FXML
    private Rectangle PhotoN22;

    @FXML
    private Rectangle PhotoN33;

    @FXML
    private Rectangle PhotoN44;

    @FXML
    private JFXTextArea Opis;

    @FXML
    private ComboBox<String> Rubrica;

    @FXML
    private Button AddStuff;

    @FXML
    private JFXTextField Price;

    @FXML
    private JFXTextField Title;

    @FXML
    private Text qw1;

    @FXML
    private Text qw4;

    @FXML
    private Text qw3;

    @FXML
    private Text qw2;

    @FXML
    private Button MainPhoto;

    @FXML
    private Button PhotoN2;

    @FXML
    private Button PhotoN3;

    @FXML
    private Button PhotoN4;

    @FXML
    private Button userSetting;

    @FXML
    private Button messange;

    @FXML
    private Button love;

    @FXML
    private Button search;

    @FXML
    private Button home;

    static private String images0 ;
    static private String images1 ;
    static private String images2 ;
    static private String images3 ;

    DatabaseHandler databaseHandler = new DatabaseHandler();

    @FXML
    void initialize() {

        ObservableList<String> list1 = FXCollections.observableArrayList("Auto","Home","Child","Beauty");
        Rubrica.setItems(list1);

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


        MainPhoto.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            URI fil1 = file.toURI();
            Image image = new Image(String.valueOf(fil1));
            MainPhotoo.setFill(new ImagePattern(image));
            images0=fil1.toString();
        });PhotoN2.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            URI fil1 = file.toURI();
            Image image = new Image(String.valueOf(fil1));
            PhotoN22.setFill(new ImagePattern(image));
            images1=fil1.toString();
        });PhotoN3.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            URI fil1 = file.toURI();
            Image image = new Image(String.valueOf(fil1));
            PhotoN33.setFill(new ImagePattern(image));
            images2=fil1.toString();
        });PhotoN4.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            URI fil1 = file.toURI();
            Image image = new Image(String.valueOf(fil1));
            PhotoN44.setFill(new ImagePattern(image));
            images3=fil1.toString();
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

//Add New Stuff
        AddStuff.setOnAction(event -> {
            try { Rubrica.getValue().isEmpty(); }
            catch (NullPointerException e ){ Shake userLoginF10 = new Shake(Rubrica);userLoginF10.playAnim(); }
            try { images0.trim().isEmpty(); }
            catch (NullPointerException e ){ Shake userLoginF10 = new Shake(qw1);userLoginF10.playAnim(); }
            try { images1.trim().isEmpty(); }
            catch (NullPointerException e ){ Shake userLoginF10 = new Shake(qw2);userLoginF10.playAnim(); }
            try {images2.trim().isEmpty(); }
            catch (NullPointerException e ){ Shake userLoginF10 = new Shake(qw3);userLoginF10.playAnim(); }
            try {images3.trim().isEmpty(); }
            catch (NullPointerException e ){ Shake userLoginF10 = new Shake(qw4);userLoginF10.playAnim(); }
            if (Opis.getText().trim().isEmpty()){ Shake userLoginF10 = new Shake(Opis);userLoginF10.playAnim();}
            if (Price.getText().trim().isEmpty()){ Shake userLoginF10 = new Shake(Price);userLoginF10.playAnim();}
            if (Title.getText().trim().isEmpty()){ Shake userLoginF10 = new Shake(Title);
            userLoginF10.playAnim();}
            if (!Opis.getText().trim().isEmpty() && !Price.getText().trim().isEmpty() && !Title.getText().trim().isEmpty() && !images0.trim().isEmpty() && !images1.trim().isEmpty() && !images2.trim().isEmpty() && !images3.trim().isEmpty() && !Rubrica.getValue().isEmpty()){
                try {
                    databaseHandler.AddStuff(images0, images1, images2, images3, Title.getText().trim(), Rubrica.getValue(),Price.getText().trim(), Opis.getText().trim());
                    home.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/godstars/godstart.fxml"));
                    try { loader.load(); }
                    catch (IOException e) { e.printStackTrace(); }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }catch (SQLException | ClassNotFoundException exception){
                    System.out.println(exception);}
            }
        });
    }
}
