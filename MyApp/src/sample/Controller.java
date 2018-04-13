package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animations.Shuke;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField MyAppLogin;

    @FXML
    private PasswordField MyAppPassword;

    @FXML
    private Button MyAppEnter;

    @FXML
    private Button MyAppRegLogin;

    @FXML
    void initialize() {
        MyAppEnter.setOnAction(event -> {
            String loginText = MyAppLogin.getText().trim();
            String loginPassword = MyAppPassword.getText().trim();
            
            if (!loginText.equals("") && !loginPassword.equals("")){
                loginUser(loginText, loginPassword);
            } else {
                System.out.println("Error!");
            }
        });
        MyAppRegLogin.setOnAction(event -> {
            NewScene("/sample/App1.fxml");
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DataBase DB = new DataBase();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = DB.getUser(user);

        int counter = 0;

        try {
            while (result.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (counter >= 1) {
            NewScene("/sample/App.fxml");
            /*MyAppRegLogin.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/App.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();*/
        } else {
            Shuke userLoginAnim = new Shuke(MyAppLogin);
            Shuke userPassAnim = new Shuke(MyAppPassword);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }

    public void NewScene(String window){
        MyAppRegLogin.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}

