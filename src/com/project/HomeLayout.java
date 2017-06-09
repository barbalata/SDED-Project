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
public class HomeLayout{
    static Scene sceneHome;
    static Scene sceneMenu;
    static Stage windows;



    public HomeLayout(){
        //GridPane settings
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setVgap(20);
        gridPane.setHgap(20);

        //Variables settings
        //Title
        Label labelTitle = new Label("Automate finit deterministe");
        labelTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        GridPane.setHalignment(labelTitle, HPos.CENTER);
        GridPane.setConstraints(labelTitle, 2,1,15,1);

        //Start button
        Button buttonStart = new Button("Start");
        GridPane.setHalignment(buttonStart, HPos.CENTER);
        GridPane.setConstraints(buttonStart,4,2, 10,5);
        buttonStart.setOnAction(e -> windows.setScene(sceneMenu));

        //Studenti label
        Label labelStudents = new Label("Studenti:");
        //GridPane.setHalignment(labelStudents, HPos.RIGHT);
        GridPane.setConstraints(labelStudents, 9, 6,10,6);

        //First stud label
        Label labelNameStud1 = new Label("Barbălată Cătălin-Răzvan\nDragu Isabela-Ioana");
        //GridPane.setHalignment(labelNameStud1, HPos.RIGHT);
        GridPane.setConstraints(labelNameStud1,12,6,13,6);

        //Layout HOME
        gridPane.getChildren().addAll(labelTitle,buttonStart,labelStudents,labelNameStud1);
        sceneHome = new Scene(gridPane, 400, 250);

    }

    public static Scene getSceneHome(){
        return sceneHome;
    }

    public static void putSceneMenu(Scene inPut){
        sceneMenu = inPut;
    }

    public static void putStageWindow(Stage inPut){
        windows = inPut;
    }

}
