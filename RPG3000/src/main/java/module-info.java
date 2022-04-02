module com.example.rpg3000 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.isep.systems to javafx.fxml;
    exports com.isep.systems;
}