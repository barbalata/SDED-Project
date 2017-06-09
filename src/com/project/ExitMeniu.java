package com.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

/**
 * Created by Barbalata-PC on 22.05.2017.
 */
public class ExitMeniu{

    static boolean answer;

    public static boolean display (){
        Stage windows = new Stage();

        //Configurarea paginii
        windows.initModality(Modality.APPLICATION_MODAL); //Nu permite primirea altor actiuni de pe alte ferestre
        windows.setTitle("Exit");
        windows.setMinWidth(250);
        windows.setMinHeight(200);


        //Continutul ferestrei
        Label label = new Label("Sigur doriti sa iesiti?");
        Button buttonYes = new Button("Da.");
        Button buttonNo = new Button("Nu.");

        //Actiunile pentru fiecare buton
        buttonYes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                answer = true;
                windows.close();
            }
        });

        buttonNo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                answer = false;
                windows.close();
            }
        });

        //Crearea fizica a ferestrei
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,buttonYes,buttonNo);
        layout.setAlignment(Pos.CENTER);

        //Aplicarea layoutului creat peste fereastra
        Scene scene = new Scene(layout);

        windows.setScene(scene);    //aplicarea efectiva
        windows.showAndWait();  //Se afisează pagina si o face sa astepte comenzi.

        return answer;
    }
}
