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


public class Main extends Application{

    static Stage windows;
    Scene sceneHome, sceneMenu, sceneProperties, sceneConcepts, sceneOperations;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Stage settings
        windows = primaryStage;
        primaryStage.setTitle("Automate finit deterministe (AFD)");


        HomeLayout homeLayout = new HomeLayout();
        sceneHome = homeLayout.getSceneHome();

        MenuLayout menuLayout = new MenuLayout();
        sceneMenu = menuLayout.getSceneMenu();

        ConceptsLayout conceptsLayout = new ConceptsLayout();
        sceneConcepts = conceptsLayout.getSceneConcepts();

        PropertiesLayout propertiesLayout = new PropertiesLayout();
        sceneProperties = propertiesLayout.getSceneProperties();

        OperationsLayout operationsLayout = new OperationsLayout();
        sceneOperations = operationsLayout.getSceneOperations();

        homeLayout.putSceneMenu(sceneMenu);
        homeLayout.putStageWindow(windows);

        menuLayout.putWindow(windows);
        menuLayout.putSceneHome(sceneHome);
        menuLayout.putConcepts(sceneConcepts);
        menuLayout.putProperties(sceneProperties);
        menuLayout.putOperations(sceneOperations);

        conceptsLayout.putWindow(windows);
        conceptsLayout.putSceneMenu(sceneMenu);
        conceptsLayout.putSceneProperties(sceneProperties);
        conceptsLayout.putSceneOperations(sceneOperations);

        propertiesLayout.putWindow(windows);
        propertiesLayout.putSceneConcepts(sceneConcepts);
        propertiesLayout.putSceneMenu(sceneMenu);
        propertiesLayout.putSceneOperations(sceneOperations);

        operationsLayout.putWindow(windows);
        operationsLayout.putSceneMenu(sceneMenu);
        operationsLayout.putSceneConcepts(sceneConcepts);
        operationsLayout.putSceneProperties(sceneProperties);



        //EXIT APPLICATION
        windows.setOnCloseRequest(e ->{
            e.consume();
            closeWindow();

        });

        windows.setScene(sceneHome);
        windows.show();

    }

    private void closeApp(Main main) {
    }

    static public void closeWindow(){
        boolean answer = ExitMeniu.display();
        if(answer) {
            windows.close();
        }
    }
}
