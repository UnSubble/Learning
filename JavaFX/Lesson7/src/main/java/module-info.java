module com.unsubble.lesson7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unsubble.lesson7 to javafx.fxml;
    exports com.unsubble.lesson7;
}