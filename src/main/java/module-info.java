module com.example.motorcycle {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens com.example.motorcycle to javafx.fxml;
    exports com.example.motorcycle;
}