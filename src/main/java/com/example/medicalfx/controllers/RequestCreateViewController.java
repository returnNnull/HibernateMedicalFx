package com.example.medicalfx.controllers;

import com.example.medicalfx.DbConnection;
import com.example.medicalfx.HelloApplication;
import com.example.medicalfx.models.Request;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RequestCreateViewController extends ViewController<Request> {



    @FXML
    public Button btn;
    @FXML
    public TextField closeDate;
    @FXML
    public TextField pharNum;
    @FXML
    public TextField createDate;
    @FXML
    public TextField num;

    private Request request;
    private boolean created = true;

    @Override
    public void init(Request obj) {
        if (obj == null){
            this.request = new Request();
        }
        else {
            this.request = obj;
            btn.setText("Обновить");
            created = false;
        }

        num.setText(request.getNum());
        pharNum.setText(request.getPharmacyNum());
        createDate.setText(request.getCreateDate());
        closeDate.setText(request.getCloseDate());

    }

    public void click(ActionEvent actionEvent) throws IOException {
        DbConnection connection = DbConnection.getInstance();

        request.setNum(num.getText());
        request.setPharmacyNum(pharNum.getText());
        request.setCreateDate(createDate.getText());
        request.setCloseDate(closeDate.getText());

        if (created)
            connection.insert(request);
        else
            connection.update(request);

        HelloApplication.showMain();
    }
}
