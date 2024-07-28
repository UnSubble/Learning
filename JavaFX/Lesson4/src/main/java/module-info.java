module com.unsubble.lesson4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unsubble.lesson4 to javafx.fxml;
    exports com.unsubble.lesson4;
}