module com.example.medicalfx {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.naming;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;



    opens com.example.medicalfx to javafx.fxml;
    exports com.example.medicalfx;
    exports com.example.medicalfx.models;
    opens com.example.medicalfx.models to javafx.fxml;
    exports com.example.medicalfx.controllers;
    opens com.example.medicalfx.controllers to javafx.fxml;
}