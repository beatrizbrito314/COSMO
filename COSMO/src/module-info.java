module COSMO {
    exports service;
    exports view;
    exports application;
    exports model;

    opens view to javafx.fxml;

    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires com.google.gson;
}
