module com.unsubble.lesson6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unsubble.lesson6 to javafx.fxml;
    exports com.unsubble.lesson6;
}