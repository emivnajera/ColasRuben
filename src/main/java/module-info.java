module com.example.colas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.colas to javafx.fxml;
    exports com.example.colas;
}