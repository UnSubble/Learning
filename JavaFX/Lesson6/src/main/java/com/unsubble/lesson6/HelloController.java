package com.unsubble.lesson6;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ColorPicker colorStyle;
    @FXML
    private Pane pane;
    @FXML
    private ComboBox<Object> box;
    @FXML
    private Label label, label2;
    @FXML
    private Slider slider;
    private int temp;


    Object[] values = {"test 1","test 2","test 3"};

    @FXML
    protected void changeColor(ActionEvent event) {
        pane.setBackground(Background.fill(colorStyle.getValue()));
    }

    @FXML
    protected void changeLabel(ActionEvent event) {
        label.setText(box.getValue().toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        box.getItems().addAll(Arrays.asList(values));
        box.setValue(values[0]);

        slider.valueProperty().addListener((observable, num, t1) -> {
            temp = t1.intValue();
            label2.setText(String.valueOf(temp));
        });
    }
}