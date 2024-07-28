package com.unsubble.lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField ltext;

    @FXML
    protected void tryLogin(ActionEvent event) throws IOException {
        if (ltext.getText().equalsIgnoreCase("unsubble")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserPanel.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 300, 300);
            stage.setScene(scene);
            LoginCheckerController controller = (LoginCheckerController)(loader.getController());
            controller.setName(ltext.getText());
//            ((Label)(root.getChildrenUnmodifiable().stream()
//                    .filter(x -> x.getClass() == Label.class).findFirst().get()))
//                    .setText("hello " + ltext.getText());
        }
    }
}