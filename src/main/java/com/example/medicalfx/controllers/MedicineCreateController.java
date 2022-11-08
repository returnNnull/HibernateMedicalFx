package com.example.medicalfx.controllers;

import com.example.medicalfx.DbConnection;
import com.example.medicalfx.HelloApplication;
import com.example.medicalfx.models.Medicines;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MedicineCreateController extends ViewController<Medicines> {

    @FXML
    public TextField code;
    @FXML
    public TextField name;
    @FXML
    public TextField man;
    @FXML
    public TextField price;
    @FXML
    public Button btn;

    private  Medicines medicines;
    private boolean created = true;



    public void init(Medicines medicines) {
        if (medicines == null){
            this.medicines = new Medicines();
        }
        else {
            this.medicines = medicines;
            btn.setText("Обновить");
            created = false;
        }

        code.setText(this.medicines.getCode());
        name.setText(this.medicines.getName());
        man.setText(this.medicines.getManufacturer());
        price.setText(this.medicines.getPrice());
    }

    public void click(ActionEvent mouseEvent) throws IOException {
        DbConnection connection = DbConnection.getInstance();
        medicines.setCode(code.getText());
        medicines.setName(name.getText());
        medicines.setManufacturer(man.getText());
        medicines.setPrice(price.getText());

        if (created)
            connection.insert(medicines);
        else
            connection.update(medicines);

        HelloApplication.showMain();
    }

}
