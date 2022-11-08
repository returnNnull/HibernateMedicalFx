package com.example.medicalfx;

import com.example.medicalfx.controllers.ViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Stage stage;
    private static FXMLLoader fxmlLoader;

    public static FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public static void setFxmlLoader(FXMLLoader fxmlLoader) {
        HelloApplication.fxmlLoader = fxmlLoader;
    }

    public static void showAuth() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        setFxmlLoader(fxmlLoader);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Авторизация");
        stage.setScene(scene);
        stage.show();
    }

    public static void showMain() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        setFxmlLoader(fxmlLoader);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Авторизация");
        stage.setScene(scene);
        stage.show();
    }

    public static void showCreate() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("medic-med-create-view.fxml"));
        setFxmlLoader(fxmlLoader);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Авторизация");
        stage.setScene(scene);
        stage.show();
    }

    public static <T> void showEditable(String xml, String title, T obj) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(xml));
        setFxmlLoader(fxmlLoader);
        Scene scene = new Scene(fxmlLoader.load());
        ViewController<T> controller = fxmlLoader.getController();
        controller.init(obj);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        HelloApplication.stage = stage;
        showAuth();
    }
}