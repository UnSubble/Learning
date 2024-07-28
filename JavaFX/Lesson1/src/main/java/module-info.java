module com.unsubble.lesson1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unsubble.lesson1 to javafx.fxml;
    exports com.unsubble.lesson1;
}