package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class App1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField MyAppPassword;

    @FXML
    private Button MyAppEnter;

    @FXML
    private TextField Name;

    @FXML
    private TextField Country;

    @FXML
    private TextField Surname;

    @FXML
    private TextField MyAppLogin4;

    @FXML
    private CheckBox Male;

    @FXML
    private CheckBox Female;

    @FXML
    void initialize() {
        MyAppEnter.setOnAction(event -> {

            NewUser();
        });
    }

    private void NewUser() {
        DataBase dbHandler = new DataBase();

        String firstName = Name.getText();
        String lastName = Surname.getText();
        String userName = MyAppLogin4.getText();
        String password = MyAppPassword.getText();
        String location = Country.getText();
        String geder = "";
        if (Male.isSelected())
            geder = "Мужской";
        else
            geder = "Женский";

        User user = new User(firstName, lastName, userName, password, location, geder);

        dbHandler.singUser(user);
    }
}
