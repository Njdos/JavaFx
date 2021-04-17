package Connect;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public static String getId() {
        return String.valueOf(id);
    }

    static public String ImageA1;
    static public String ImageA2;
    static public String ImageA3;
    static public String ImageA4;
    static public String TitleA;
    static public String RubricaA;
    static public String PriceA;
    static public String OpisA;
    static public String IDA;
    static public String IDUser;

    static public String ImageM;
    static public String UserM;
    static public String FirstM;
    static public String LastM;
    static public String EmailM;
    static public String phoneM;

    static public String ImageQ;
    static public String TitleQ;
    static public String RubricaQ;
    static public String PriceQ;

    static public String ImageO;
    static public String TitleO;
    static public String RubricaO;
    static public String PriceO;

    static public String ImageT;
    static public String TitleT;
    static public String RubricaT;
    static public String PriceT;

    static public String ImageF;
    static public String TitleF;
    static public String RubricaF;
    static public String PriceF;

    static private int id = 0;
    static private int idq = 0;

    static public int getIdq() {
        return idq;
    }

    static private String userA;
    static private String passwordA;
    static private String emailA;
    static private String phoneA;
    static private String imageA;
    static private String languageA;
    static private String temaA;

    private char ch = '\'';

    static public boolean user2;
    static public boolean user3;
    static public boolean user4;

    public String getUserA() {
        return userA;
    }
    public String getPasswordA() {
        return passwordA;
    }
    public String getEmailA() {
        return emailA;
    }
    public String getPhoneA() {
        return phoneA;
    }
    public static String getImageA() {
        return imageA;
    }
    public static String getTemaA() {
        return temaA;
    }
    public static String getLanguageA() {
        return languageA;
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    //Register User
    public void SignUpUser(String firstName, String lastName, String userName, String date, String password, String emailAddress, String phoneNumber, String location, String gender) throws SQLException, ClassNotFoundException {
        String insertIntoDB = "INSERT INTO " + Const.USER_TABLE + "(" + Const.Users_FirstName + "," + Const.Users_LastName + "," + Const.Users_UserName + "," + Const.Users_Date + "," + Const.Users_Password + "," + Const.Users_EmailAddress + "," + Const.Users_MobileNumber + "," + Const.Location + "," + Const.Users_Gender + ")" + "VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insertIntoDB);prSt.setString(1, firstName);prSt.setString(2, lastName);prSt.setString(3, userName);prSt.setString(4, date);prSt.setString(5, password);prSt.setString(6, emailAddress);prSt.setString(7, phoneNumber);prSt.setString(8, location);prSt.setString(9, gender);prSt.executeUpdate();
    }

    // Sign In Your Account
    public void SignInWebSite(String userName, String password) throws SQLException, ClassNotFoundException {
        String SelectF = "SELECT * FROM " + Const.USER_TABLE + " AS u WHERE " + Const.Users_UserName + "=? AND " + Const.Users_Password + "=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(SelectF);
        prSt.setString(1, userName);
        prSt.setString(2, password);
        ResultSet resultSet = prSt.executeQuery();

//Get id this user who Sign in
        while (resultSet.next()) {
            id = resultSet.getInt("id");
        }

//IF id > 0 Sorry but i don know What i DID;)
        if (id > 0) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/godstars/godstart.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            idq = 7;
            String Selectavatar = "SELECT * FROM " + Const.USER_TABLE + " AS u WHERE " + Const.Users_UserName + "=?";
            PreparedStatement prStA = getDbConnection().prepareStatement(Selectavatar);
            prStA.setString(1, userName);
            ResultSet resultSetA = prStA.executeQuery();
            while (resultSetA.next()) { userA = resultSetA.getString(4);passwordA = resultSetA.getString(6);emailA = resultSetA.getString(7);phoneA = resultSetA.getString(8);imageA = resultSetA.getString(11);languageA = resultSetA.getString(12);temaA = resultSetA.getString(13); }
        }

//Why we have proplem
        else if (id == 0) {
            String SelectFq = "SELECT * FROM " + Const.USER_TABLE + " AS u WHERE " + Const.Users_UserName + "=?";
            PreparedStatement prStq = getDbConnection().prepareStatement(SelectFq);
            prStq.setString(1, userName);
            ResultSet resultSetq = prStq.executeQuery();
            int ida = 0;
            while (resultSetq.next()) {
                ida = resultSetq.getInt("id");
            }
            if (ida > 0) {
                idq = 5;
            } else {
                idq = 0;
            }
        }
    }

    //Register ?USER?
    public boolean UserNameRepeat(String userName) throws SQLException, ClassNotFoundException {
        int res = 0;
        String SelectF12 = "SELECT * FROM " + Const.USER_TABLE + " AS u WHERE " + Const.Users_UserName + "=?";
        PreparedStatement prSt12 = getDbConnection().prepareStatement(SelectF12);
        prSt12.setString(1, userName);
        ResultSet resultSet12 = prSt12.executeQuery();
        while (resultSet12.next()) {
            res = resultSet12.getInt("id");
        }
        return res <= 0;
    }

    //Register ?Email?
    public boolean EmailRepeated(String emailAddress) throws SQLException, ClassNotFoundException {
        int id13 = 0;
        String SelectF13 = "SELECT * FROM " + Const.USER_TABLE + " AS u WHERE " + Const.Users_EmailAddress + "=?";
        PreparedStatement prSt13 = getDbConnection().prepareStatement(SelectF13);
        prSt13.setString(1, emailAddress);
        ResultSet resultSet13 = prSt13.executeQuery();
        while (resultSet13.next()) {
            id13 = resultSet13.getInt("id");
        }
        return id13 <= 0;
    }

    //Register ?Number?
    public boolean PhoneReapet(String phoneNumber) throws SQLException, ClassNotFoundException {
        int id15 = 0;
        String SelectF15 = "SELECT * FROM " + Const.USER_TABLE + " AS u WHERE " + Const.Users_MobileNumber + "=?";
        PreparedStatement prSt15 = getDbConnection().prepareStatement(SelectF15);
        prSt15.setString(1, phoneNumber);
        ResultSet resultSet15 = prSt15.executeQuery();
        while (resultSet15.next()) {
            id15 = resultSet15.getInt("id");
        }
        return id15 <= 0;
    }

    //Сheck for repetition of  <  User ? Email ? Phone  >
    public void EditUser(String userNames, String emails, String phones) throws SQLException, ClassNotFoundException {
        int user1 = 0;
        String SelectF1 = "SELECT * FROM " + Const.USER_TABLE + " AS u WHERE " + Const.Users_UserName + " = " + ch + userNames + ch + " AND " + Const.Users_ID + "<>" + id;
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) {
            user1 = resultSet1.getInt("id");
        }
        if (user1 == 0) {
            user2 = true;
        } else {
            user2 = false;
        }
        int email2 = 0;
        String SelectF2 = "SELECT * FROM " + Const.USER_TABLE + " AS u WHERE " + Const.Users_EmailAddress + " = " + ch + emails + ch + " AND " + Const.Users_ID + "<>" + id;
        PreparedStatement prSt2 = getDbConnection().prepareStatement(SelectF2);
        ResultSet resultSet2 = prSt2.executeQuery();
        while (resultSet2.next()) {
            email2 = resultSet2.getInt("id");
        }
        if (email2 == 0) {
            user3 = true;
        } else {
            user3 = false;
        }
        int phone3 = 0;
        String SelectF3 = "SELECT * FROM " + Const.USER_TABLE + " AS u WHERE " + Const.Users_MobileNumber + " = " + ch + phones + ch + " AND " + Const.Users_ID + "<>" + id;
        PreparedStatement prSt3 = getDbConnection().prepareStatement(SelectF3);
        ResultSet resultSet3 = prSt3.executeQuery();
        while (resultSet3.next()) {
            phone3 = resultSet3.getInt("id");
        }
        if (phone3 == 0) {
            user4 = true;
        } else {
            user4 = false;
        }
    }

    //ADD to database new audit to User
    public void EdirAllest(String userNames, String passwords, String emails, String phones, String images, String languages, String colors) throws SQLException, ClassNotFoundException {
        if (user2 == true && user3 == true && user4 == true && !passwords.trim().isEmpty() && !userNames.trim().isEmpty() && !emails.trim().isEmpty() && !phones.trim().isEmpty()) {
            String insertIntoDB = "UPDATE " + Const.USER_TABLE + " SET " + "userName = ? " + ", password = ? " + ", emailAddress = ? " + ", phoneNumber = ? " + ", image = ? " + ", language = ? " + ", tema = ? " + " WHERE id=" + id;
            PreparedStatement prSt = getDbConnection().prepareStatement(insertIntoDB);prSt.setString(1, userNames);prSt.setString(2, passwords);prSt.setString(3, emails);prSt.setString(4, phones);prSt.setString(5, images);prSt.setString(6, languages);prSt.setString(7, colors);prSt.executeUpdate();
        }
    }

    //ADD stuff
    public void AddStuff(String ADD_image1, String ADD_image2, String ADD_image3, String ADD_image4, String title, String tip, String price, String opis) throws SQLException, ClassNotFoundException {
        String insertIntoDB = "INSERT INTO " + Const.ADD_TABLE + "(" + Const.ADD_image1 + "," + Const.ADD_image2 + "," + Const.ADD_image3 + "," + Const.ADD_image4 + "," + Const.ADD_title + "," + Const.ADD_tip + "," + Const.ADD_price + "," + Const.ADD_opis + "," + Const.ADD_userAdd + ")" + "VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insertIntoDB);prSt.setString(1, ADD_image1);prSt.setString(2, ADD_image2);prSt.setString(3, ADD_image3);prSt.setString(4, ADD_image4);prSt.setString(5, title);prSt.setString(6, tip);prSt.setString(7, price);prSt.setString(8, opis);prSt.setString(9, getId());prSt.executeUpdate();
    }

//stuff add
    public void StuffO() throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.stuffo  WHERE userAdd<>" + id + " order by id DESC limit 1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) { ImageO = resultSet1.getString("image1");TitleO = resultSet1.getString("title");RubricaO = resultSet1.getString("tip");PriceO = resultSet1.getString("price"); } }
    public void StuffT() throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.stuffo WHERE userAdd<>" + id + " order by id DESC limit 1,1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) { ImageT = resultSet1.getString("image1");TitleT = resultSet1.getString("title");RubricaT = resultSet1.getString("tip");PriceT = resultSet1.getString("price"); } }
    public void StuffF() throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.stuffo WHERE userAdd<>" + id + " order by id DESC limit 2, 1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) { ImageF = resultSet1.getString("image1");TitleF = resultSet1.getString("title");RubricaF = resultSet1.getString("tip");PriceF = resultSet1.getString("price"); } }

//stuff user
    public void StuffO1() throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.stuffo  WHERE userAdd<>" + id + " order by id DESC limit 1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) { ImageA1 = resultSet1.getString("image1");ImageA2 = resultSet1.getString("image2");ImageA3 = resultSet1.getString("image3");ImageA4 = resultSet1.getString("image4");TitleA = resultSet1.getString("title");RubricaA = resultSet1.getString("tip");PriceA = resultSet1.getString("price");OpisA = resultSet1.getString("opis");IDA = resultSet1.getString("id"); IDUser = resultSet1.getString("userAdd");} }
    public void StuffT1() throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.stuffo WHERE userAdd<>" + id + " order by id DESC limit 1,1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) { ImageA1 = resultSet1.getString("image1");ImageA2 = resultSet1.getString("image2");ImageA3 = resultSet1.getString("image3");ImageA4 = resultSet1.getString("image4");TitleA = resultSet1.getString("title");RubricaA = resultSet1.getString("tip");PriceA = resultSet1.getString("price");OpisA = resultSet1.getString("opis");IDA = resultSet1.getString("id"); IDUser = resultSet1.getString("userAdd");} }
    public void StuffF1() throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.stuffo WHERE userAdd<>" + id + " order by id DESC limit 2, 1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) { ImageA1 = resultSet1.getString("image1");ImageA2 = resultSet1.getString("image2");ImageA3 = resultSet1.getString("image3");ImageA4 = resultSet1.getString("image4");TitleA = resultSet1.getString("title");RubricaA = resultSet1.getString("tip");PriceA = resultSet1.getString("price");OpisA = resultSet1.getString("opis");IDA = resultSet1.getString("id"); IDUser = resultSet1.getString("userAdd");} }

        public void StuffO12(String title,String rubrica, String from, String to) throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.stuffo WHERE userAdd<> " + id + " title LIKE " + ch+"%"+title+"%"+ch + " AND tip = " + ch+rubrica+ch + " AND price>= " +from+ " AND price<= " +to + " LIMIT 1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) { ImageA1 = resultSet1.getString("image1");ImageA2 = resultSet1.getString("image2");ImageA3 = resultSet1.getString("image3");ImageA4 = resultSet1.getString("image4");TitleA = resultSet1.getString("title");RubricaA = resultSet1.getString("tip");PriceA = resultSet1.getString("price");OpisA = resultSet1.getString("opis");IDA = resultSet1.getString("id"); IDUser = resultSet1.getString("userAdd");} }
    public void StuffT12(String title,String rubrica, String from, String to) throws SQLException, ClassNotFoundException {
        String SelectF1 =  "SELECT * FROM testtableo.stuffo WHERE userAdd<> " + id + " title LIKE " + ch+"%"+title+"%"+ch + " AND tip = " + ch+rubrica+ch + " AND price>= " +from+ " AND price<= " +to + " LIMIT 1,1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) { ImageA1 = resultSet1.getString("image1");ImageA2 = resultSet1.getString("image2");ImageA3 = resultSet1.getString("image3");ImageA4 = resultSet1.getString("image4");TitleA = resultSet1.getString("title");RubricaA = resultSet1.getString("tip");PriceA = resultSet1.getString("price");OpisA = resultSet1.getString("opis");IDA = resultSet1.getString("id"); IDUser = resultSet1.getString("userAdd");} }
    public void StuffF12(String title,String rubrica, String from, String to) throws SQLException, ClassNotFoundException {
        String SelectF1 =  "SELECT * FROM testtableo.stuffo WHERE userAdd<> " + id + " title LIKE " + ch+"%"+title+"%"+ch + " AND tip = " + ch+rubrica+ch + " AND price>= " +from+ " AND price<= " +to + " LIMIT 2,1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) { ImageA1 = resultSet1.getString("image1");ImageA2 = resultSet1.getString("image2");ImageA3 = resultSet1.getString("image3");ImageA4 = resultSet1.getString("image4");TitleA = resultSet1.getString("title");RubricaA = resultSet1.getString("tip");PriceA = resultSet1.getString("price");OpisA = resultSet1.getString("opis");IDA = resultSet1.getString("id"); IDUser = resultSet1.getString("userAdd");} }

//save love stuff
    public void StuffLoves() throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.stuffo WHERE id = "+ IDA;
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) { ImageQ = resultSet1.getString("image1");TitleQ = resultSet1.getString("title");RubricaQ = resultSet1.getString("tip");PriceQ = resultSet1.getString("price"); }
    }
    //masssenge of user
    public void MessangesUser() throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.userso WHERE id = "+ IDUser;
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) { ImageM = resultSet1.getString("image"); UserM = resultSet1.getString("userName"); FirstM = resultSet1.getString("firstName"); LastM = resultSet1.getString("lastName"); EmailM = resultSet1.getString("emailAddress"); phoneM = resultSet1.getString("phoneNumber");
        }}

    public void SearchStuff1(String title,String rubrica, String from, String to) throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.stuffo WHERE title LIKE " + ch+"%"+title+"%"+ch + " AND tip = " + ch+rubrica+ch + " AND price>= " +from+ " AND price<= " +to + " LIMIT 1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) {  ImageO = resultSet1.getString("image1");TitleO = resultSet1.getString("title");RubricaO = resultSet1.getString("tip");PriceO = resultSet1.getString("price");
        }}
    public void SearchStuff2(String title,String rubrica, String from, String to) throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.stuffo WHERE title LIKE " + ch+"%"+title+"%"+ch + " AND tip = " + ch+rubrica+ch + " AND price>= " +from+ " AND price<= " +to + " LIMIT 1, 1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) {  ImageT = resultSet1.getString("image1");TitleT = resultSet1.getString("title");RubricaT = resultSet1.getString("tip");PriceT = resultSet1.getString("price");
        }}
    public void SearchStuff3(String title,String rubrica, String from, String to) throws SQLException, ClassNotFoundException {
        String SelectF1 = "SELECT * FROM testtableo.stuffo WHERE title LIKE " + ch+"%"+title+"%"+ch + " AND tip = " + ch+rubrica+ch + " AND price>= " +from+ " AND price<= " +to + " LIMIT 2, 1";
        PreparedStatement prSt1 = getDbConnection().prepareStatement(SelectF1);
        ResultSet resultSet1 = prSt1.executeQuery();
        while (resultSet1.next()) {  ImageF = resultSet1.getString("image1");TitleF = resultSet1.getString("title");RubricaF = resultSet1.getString("tip");PriceF = resultSet1.getString("price");
        }}
}