module VTTproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports org.example;
    opens org.example to javafx.fxml;

    exports org.example.controller;
    opens org.example.controller to javafx.fxml;

    exports org.example.view;
    opens org.example.view to javafx.fxml, javafx.graphics;

    exports org.example.model;
    opens org.example.model to javafx.graphics, javafx.fxml;
}