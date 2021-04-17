package godstars;

import java.io.IOException;
import java.sql.SQLException;

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
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class godfirst {

    @FXML
    private Rectangle imageQ1;

    @FXML
    private Text RubricaQ1;

    @FXML
    private Text titleQ1;

    @FXML
    private Text PriceQ1;

    @FXML
    private Button addF;

    @FXML
    private Button addF1;

    @FXML
    private Rectangle imageQ2;

    @FXML
    private Text RubricaQ2;

    @FXML
    private Text titleQ2;

    @FXML
    private Text PriceQ2;

    @FXML
    private Button addS;

    @FXML
    private Button addS1;

    @FXML
    private Rectangle imageQ3;

    @FXML
    private Text RubricaQ3;

    @FXML
    private Text titleQ3;

    @FXML
    private Text PriceQ3;

    @FXML
    private Button addT;

    @FXML
    private Button addT1;

    @FXML
    private JFXTextField Title;

    @FXML
    private JFXTextField PriceTo;

    @FXML
    private JFXTextField PriceFrom;

    @FXML
    private ComboBox<String> Rubrica;

    @FXML
    private Button SearchStuff;

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

    DatabaseHandler databaseHandler = new DatabaseHandler();

    @FXML
    void initialize() {


        ObservableList<String> list1 = FXCollections.observableArrayList("Auto","Home","Child","Beauty");
        Rubrica.setItems(list1);

        try {
            databaseHandler.StuffO();
            Image image = new Image(String.valueOf(databaseHandler.ImageO));
            imageQ1.setFill(new ImagePattern(image));
            titleQ1.setText(databaseHandler.TitleO);
            RubricaQ1.setText(databaseHandler.RubricaO);
            PriceQ1.setText(databaseHandler.PriceO);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            databaseHandler.StuffT();
            Image image = new Image(String.valueOf(databaseHandler.ImageT));
            imageQ2.setFill(new ImagePattern(image));
            titleQ2.setText(databaseHandler.TitleT);
            RubricaQ2.setText(databaseHandler.RubricaT);
            PriceQ2.setText(databaseHandler.PriceT);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            databaseHandler.StuffF();
            Image image = new Image(String.valueOf(databaseHandler.ImageF));
            imageQ3.setFill(new ImagePattern(image));
            titleQ3.setText(databaseHandler.TitleF);
            RubricaQ3.setText(databaseHandler.RubricaF);
            PriceQ3.setText(databaseHandler.PriceF);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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
        addF.setOnAction(event -> {
            try {
                databaseHandler.StuffO1();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            addF.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/userstuff/userstuff.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        addS.setOnAction(event -> {
            try {
                databaseHandler.StuffT1();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            addS.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/userstuff/userstuff.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        addT.setOnAction(event -> {
            try {
                databaseHandler.StuffF1();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            addT.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/userstuff/userstuff.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        });

        SearchStuff.setOnAction(event -> {
            String title = Title.getText().trim();
            String rubrica = Rubrica.getValue();
            String from ;
            String to;
            int i1 = 0;
            int i2 = 999999999;
            if (PriceFrom.getText().trim().equals("")){from=Integer.toString(i1);}
            else{from = PriceFrom.getText().trim();}
            if (PriceTo.getText().trim().equals("")){to=Integer.toString(i2);}
            else{to = PriceTo.getText().trim();}
            try {
                databaseHandler.SearchStuff1(title,rubrica,from,to);
                Image image = new Image(String.valueOf(databaseHandler.ImageO));
                imageQ1.setFill(new ImagePattern(image));
                titleQ1.setText(databaseHandler.TitleO);
                RubricaQ1.setText(databaseHandler.RubricaO);
                PriceQ1.setText(databaseHandler.PriceO);
                addF.setVisible(false);
                addF1.setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                databaseHandler.SearchStuff2(title,rubrica,from,to);
                Image image = new Image(String.valueOf(databaseHandler.ImageT));
                imageQ2.setFill(new ImagePattern(image));
                titleQ2.setText(databaseHandler.TitleT);
                RubricaQ2.setText(databaseHandler.RubricaT);
                PriceQ2.setText(databaseHandler.PriceT);
                addS.setVisible(false);
                addS1.setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                databaseHandler.SearchStuff3(title,rubrica,from,to);
                Image image = new Image(String.valueOf(databaseHandler.ImageF));
                imageQ3.setFill(new ImagePattern(image));
                titleQ3.setText(databaseHandler.TitleF);
                RubricaQ3.setText(databaseHandler.RubricaF);
                PriceQ3.setText(databaseHandler.PriceF);
                addT.setVisible(false);
                addT1.setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });


        addF1.setOnAction(event -> {
            String title = Title.getText().trim();
            String rubrica = Rubrica.getValue();
            String from ;
            String to;
            int i1 = 0;
            int i2 = 999999999;
            if (PriceFrom.getText().trim().equals("")){from=Integer.toString(i1);}
            else{from = PriceFrom.getText().trim();}
            if (PriceTo.getText().trim().equals("")){to=Integer.toString(i2);}
            else{to = PriceTo.getText().trim();}
            try {
                databaseHandler.StuffO12(title,rubrica,from,to);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            addS.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/userstuff/userstuff.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });


        addS1.setOnAction(event -> {
            String title = Title.getText().trim();
            String rubrica = Rubrica.getValue();
            String from ;
            String to;
            int i1 = 0;
            int i2 = 999999999;
            if (PriceFrom.getText().trim().equals("")){from=Integer.toString(i1);}
            else{from = PriceFrom.getText().trim();}
            if (PriceTo.getText().trim().equals("")){to=Integer.toString(i2);}
            else{to = PriceTo.getText().trim();}
            try {
                databaseHandler.StuffT12(title,rubrica,from,to);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            addS.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/userstuff/userstuff.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });


        addT1.setOnAction(event -> {
            String title = Title.getText().trim();
            String rubrica = Rubrica.getValue();
            String from ;
            String to;
            int i1 = 0;
            int i2 = 999999999;
            if (PriceFrom.getText().trim().equals("")){from=Integer.toString(i1);}
            else{from = PriceFrom.getText().trim();}
            if (PriceTo.getText().trim().equals("")){to=Integer.toString(i2);}
            else{to = PriceTo.getText().trim();}
            try {
                databaseHandler.StuffF12(title,rubrica,from,to);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            addS.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/userstuff/userstuff.fxml"));
            try { loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        
    }
}
