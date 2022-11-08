package com.example.medicalfx.controllers;

import com.example.medicalfx.DbConnection;
import com.example.medicalfx.HelloApplication;
import com.example.medicalfx.models.Pharmacy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PharCreateViewController extends ViewController<Pharmacy> {

    @FXML
    public TextField number;
    @FXML
    public TextField name;
    @FXML
    public TextField phone;
    @FXML
    public TextField address;
    @FXML
    public Button btn;

    private Pharmacy pharmacy;
    private boolean created = true;

    public void init(Pharmacy pharmacy) {
        if (pharmacy == null){
            this.pharmacy = new Pharmacy();
        }
        else {
            this.pharmacy = pharmacy;
            btn.setText("Обновить");
            created = false;
        }

        number.setText(this.pharmacy.getNumber());
        name.setText(this.pharmacy.getName());
        phone.setText(this.pharmacy.getPhone());
        address.setText(this.pharmacy.getAddress());
    }

    public void click(ActionEvent actionEvent) throws IOException {
        DbConnection connection = DbConnection.getInstance();

        pharmacy.setName(name.getText());
        pharmacy.setAddress(address.getText());
        pharmacy.setPhone(phone.getText());
        pharmacy.setNumber(number.getText());

        if (created)
            connection.insert(pharmacy);
        else
            connection.update(pharmacy);

        HelloApplication.showMain();
    }
}
