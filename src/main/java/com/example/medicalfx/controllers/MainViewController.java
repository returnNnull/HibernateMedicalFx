package com.example.medicalfx.controllers;

import com.example.medicalfx.DbConnection;
import com.example.medicalfx.HelloApplication;
import com.example.medicalfx.models.Medicines;
import com.example.medicalfx.models.Pharmacy;
import com.example.medicalfx.models.Purchase;
import com.example.medicalfx.models.Request;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.util.List;

public class MainViewController {

    @FXML
    public TableColumn<Medicines, Integer> code;
    @FXML
    public TableColumn<Medicines, String> name;
    @FXML
    public TableColumn<Medicines, Integer> price;
    @FXML
    public TableColumn<Medicines, String> manufact;
    @FXML
    public TableView<Medicines> table;
    @FXML
    public TableView<Pharmacy> pharTable;
    @FXML
    public TableView<Purchase> purTable;
    @FXML
    public TableView<Request> requestTable;
    public Button deleteBtn;
    public Button createBtn;

    private TableView<?> selectedTable;

    public MainViewController() {


    }

    @FXML
    public void pharmacySelected(Event event) {
        selectedTable = pharTable;

        pharTable.getItems().addListener((ListChangeListener<Pharmacy>) change
                -> DbConnection.getInstance().update(change));
        setEditable(pharTable);
        List<Pharmacy> pharmacies = DbConnection.getInstance().getAll(Pharmacy.class);
        ObservableList<TableColumn<Pharmacy, ?>> columns = pharTable.getColumns();
        columns.get(0).setCellValueFactory(new PropertyValueFactory<>("number"));
        columns.get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        columns.get(2).setCellValueFactory(new PropertyValueFactory<>("phone"));
        columns.get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        pharTable.setItems(FXCollections.observableList(pharmacies));

    }


    public void medicalSelected(Event event) {
        selectedTable = table;
        setEditable(table);
        List<Medicines> medicines = DbConnection.getInstance().getAll(Medicines.class);
        ObservableList<TableColumn<Medicines, ?>> columns = table.getColumns();
        columns.get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        columns.get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        columns.get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
        columns.get(3).setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        table.setItems(FXCollections.observableList(medicines));
    }

    private <T> void setEditable(TableView<T> tableView) {
        tableView.setEditable(true);
        tableView.getColumns().forEach(c -> {
            TableColumn<T, String> column = (TableColumn<T, String>) c;
            column.setCellFactory(TextFieldTableCell.forTableColumn());
        });


    }


    public void requestSelected(Event event) {
        selectedTable = requestTable;
        setEditable(requestTable);
        List<Request> pharmacies = DbConnection.getInstance().getAll(Request.class);

        ObservableList<TableColumn<Request, ?>> columns = requestTable.getColumns();
        columns.get(0).setCellValueFactory(new PropertyValueFactory<>("num"));
        columns.get(1).setCellValueFactory(new PropertyValueFactory<>("createDate"));
        columns.get(2).setCellValueFactory(new PropertyValueFactory<>("pharmacyNum"));
        columns.get(3).setCellValueFactory(new PropertyValueFactory<>("closeDate"));
        requestTable.setItems(FXCollections.observableList(pharmacies));
    }

    public void purchaseSelected(Event event) {
        selectedTable = purTable;
        setEditable(purTable);
        List<Purchase> pharmacies = DbConnection.getInstance().getAll(Purchase.class);

        ObservableList<TableColumn<Purchase, ?>> columns = purTable.getColumns();

        columns.get(0).setCellValueFactory(new PropertyValueFactory<>("requestNum"));
        columns.get(1).setCellValueFactory(new PropertyValueFactory<>("medicinesCode"));
        columns.get(2).setCellValueFactory(new PropertyValueFactory<>("count"));
        purTable.setItems(FXCollections.observableList(pharmacies));
    }

    public void delete() {
        Object object = selectedTable.getSelectionModel().getSelectedItem();
        selectedTable.getItems().remove(object);
        DbConnection.getInstance().delete(object);
    }

    public void create(ActionEvent mouseEvent) throws IOException {
       showEditableWindow(false);
    }

    public void update(ActionEvent actionEvent) throws IOException {
       showEditableWindow(true);
    }

    private void  showEditableWindow(boolean update) throws IOException {
        Object obj = null;
        if (update){
            obj = selectedTable.getSelectionModel().getSelectedItem();
        }
        switch (selectedTable.getId()) {
            case "table": {
                HelloApplication.showEditable("med-create-view.fxml", "Лекарство,", (Medicines) obj);
                break;
            }
            case "pharTable": {
                HelloApplication.showEditable("phar-create-view.fxml", "Аптеки", (Pharmacy) obj);
                break;
            }
            case "requestTable": {
                HelloApplication.showEditable("request-create-view.fxml", "Заявки", (Request) obj);
                break;
            }
        }
    }


}
