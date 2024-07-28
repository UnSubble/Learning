module com.unsubble.lesson2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unsubble.lesson2 to javafx.fxml;
    exports com.unsubble.lesson2;
}