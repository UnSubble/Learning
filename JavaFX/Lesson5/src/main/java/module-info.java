module com.unsubble.lesson5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unsubble.lesson5 to javafx.fxml;
    exports com.unsubble.lesson5;
}