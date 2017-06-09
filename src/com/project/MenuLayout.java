package com.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.WindowEvent;

import javax.swing.*;

import static javafx.geometry.Pos.*;

import javafx.stage.Stage;

/**
 * Created by Barbalata-PC on 23.05.2017.
 */
public class MenuLayout {

    static Scene sceneMenu;
    static Stage windows;
    static Scene sceneHome;
    static Scene sceneProperties;
    static Scene sceneConcepts;
    static Scene sceneOperations;


    public MenuLayout() {
        VBox centralMenu = new VBox(10);
        centralMenu.setAlignment(Pos.CENTER);

        //Description label
        Label labelIntro = new Label("Alegeți secțiunea pe care doriți să o accesați.");

        //Button Concepts
        Button buttonConcepts = new Button("Concepte");
        buttonConcepts.setMinWidth(100);
        buttonConcepts.setOnAction(e -> windows.setScene(sceneConcepts));

        //Button Properties
        Button buttonProperties = new Button("Proprietăți");
        buttonProperties.setMinWidth(100);
        buttonProperties.setOnAction(e -> windows.setScene(sceneProperties));

        //Button Operations
        Button buttonOperations = new Button("Operații");
        buttonOperations.setMinWidth(100);
        buttonOperations.setOnAction(e -> windows.setScene(sceneOperations));

        centralMenu.getChildren().addAll(labelIntro, buttonConcepts, buttonProperties, buttonOperations);

        GridPane bottomMenu = new GridPane();
        bottomMenu.setPadding(new Insets(10, 10, 10, 10));
        bottomMenu.setHgap(5);
        bottomMenu.setVgap(10);

        //Button back
        Button buttonBack = new Button("Back");
        buttonBack.setOnAction(e -> windows.setScene(sceneHome));
        GridPane.setHalignment(buttonBack, HPos.RIGHT);
        bottomMenu.add(buttonBack, 1, 1);

        //Layout2
        BorderPane screen2 = new BorderPane();
        screen2.setCenter(centralMenu);
        screen2.setBottom(bottomMenu);


        sceneMenu = new Scene(screen2, 400, 250);
    }


    public static Scene getSceneMenu() {
        return sceneMenu;
    }

    public static void putWindow(Stage inputWindow) {
        windows = inputWindow;
    }

    public static void putSceneHome (Scene inputHome) {
        sceneHome = inputHome;
    }

    public static void putProperties(Scene inputProperties) {
        sceneProperties = inputProperties;
    }

    public static void putConcepts(Scene inputConcepts) {
        sceneConcepts = inputConcepts;
    }

    public static void putOperations(Scene inputOperations) {
        sceneOperations = inputOperations;
    }
}