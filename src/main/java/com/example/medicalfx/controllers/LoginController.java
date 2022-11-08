package com.example.medicalfx.controllers;

import com.example.medicalfx.DbConnection;
import com.example.medicalfx.HelloApplication;
import com.example.medicalfx.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LoginController {
    @FXML
    public TextField login;
    @FXML
    public PasswordField pass;
    @FXML
    public Label error;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

        User user = new User();
        user.setLogin("admin");
        user.setPass("12345");

        DbConnection connection = DbConnection.getInstance();
        connection.insert(user);
        User user2 = connection.getById(0, User.class);
        connection.delete(user2);

        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onClick(MouseEvent mouseEvent) throws IOException {
        DbConnection dbConnection = DbConnection.getInstance();
        User user = dbConnection.getByLogin(login.getText());

        if (user != null && user.getPass().equals(pass.getText())){
            HelloApplication.showMain();
        }
        else {
            error.setVisible(true);
            error.setText("Пользователь не найден");
        }
    }
}