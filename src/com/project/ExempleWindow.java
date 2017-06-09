package com.project;


import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Barbalata-PC on 24.05.2017.
 */
public class ExempleWindow {

    public ExempleWindow(String source, String stringTitle){
        Image image = new Image("file:" + source);

        Stage windows = new Stage();


        windows.setTitle("Exemplu: " + stringTitle);
        windows.setMinWidth(image.getWidth());
        windows.setMinHeight(image.getHeight());

        ImageView img = new ImageView(image);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(img);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);


        windows.setScene(scene);
        windows.showAndWait();
    }
}
