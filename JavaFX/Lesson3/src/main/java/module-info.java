module com.unsubble.lesson3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unsubble.lesson3 to javafx.fxml;
    exports com.unsubble.lesson3;
}