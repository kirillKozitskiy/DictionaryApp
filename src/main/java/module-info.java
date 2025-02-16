module org.example.dictionaryApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.dictionaryApp to javafx.fxml;
    //exports org.example.dictionaryApp;
    exports org.example.dictionaryApp.controller;
    opens org.example.dictionaryApp.controller to javafx.fxml;
    exports org.example.dictionaryApp.model;
    opens org.example.dictionaryApp.model to javafx.fxml;
}