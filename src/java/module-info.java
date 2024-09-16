module cryptoapp {
    requires javafx.fxml;
    requires javafx.controls;


    exports cryptoapp;
    opens cryptoapp to javafx.fxml;
    exports cryptoapp.controller;
    opens cryptoapp.controller to javafx.fxml;
}