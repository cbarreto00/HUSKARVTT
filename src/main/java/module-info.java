module VTTproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires ormlite.core;
    requires ormlite.jdbc;

    exports org.example;
    opens org.example to javafx.fxml;

    exports org.example.controller;
    opens org.example.controller to javafx.fxml;

    exports org.example.view;
    opens org.example.view to javafx.fxml, javafx.graphics, ormlite.core, ormlite.jdbc;

    exports org.example.model;
    opens org.example.model;

    exports org.example.repository;
    opens org.example.repository;
}