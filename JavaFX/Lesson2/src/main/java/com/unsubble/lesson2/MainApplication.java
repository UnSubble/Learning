package com.unsubble.lesson2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainScene.fxml"));
        String css = Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm();
        Parent ro = loader.load();
        Scene scene = new Scene(ro, 600, 600);
        scene.setFill(Color.rgb(50,50,50));

        scene.getStylesheets().add(css);

        Image icon = new Image(Objects.requireNonNull(
                getClass().getClassLoader().getResource("Free.png")).toString());
        stage.getIcons().add(icon);

        Line line = new Line();
        line.setStartX(100);
        line.setStartY(100);
        line.setEndX(25);
        line.setEndY(50);
        line.setStroke(Color.CYAN);
        line.setStrokeWidth(3);
        // ro.getChildren().add(line);

        Polygon triangle = new Polygon(200,200, 200,300, 300,300);
        triangle.setStrokeWidth(3);
        triangle.setStroke(Color.KHAKI);
        triangle.setFill(Color.WHEAT);
        // ro.getChildren().add(triangle);

        Image image = new Image(Objects.requireNonNull(
                getClass().getClassLoader().getResource("emoji.png")).toString());
        ImageView imageView = new ImageView(image);
        imageView.setX(-650);
        imageView.setY(-650);
        imageView.setScaleX(0.07);
        imageView.setScaleY(0.07);
        // ro.getChildren().add(imageView);

        stage.setTitle("Lesson 2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}