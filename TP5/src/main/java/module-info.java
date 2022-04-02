module com.example.tp5 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.tp5 to javafx.fxml;
    exports com.example.tp5;
}