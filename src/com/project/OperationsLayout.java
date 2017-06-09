package com.project;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Created by Barbalata-PC on 24.05.2017.
 */
public class OperationsLayout {

    static Stage windows;
    static Scene sceneMenu;
    static Scene sceneConcepts;
    static Scene sceneProperties;
    static Scene sceneOperations;

    public OperationsLayout(){
//Central content
        Group group = new Group();

        VBox centerOperations = new VBox(10);
        centerOperations.setPadding(new Insets(40,20,20,20));
        centerOperations.setMaxWidth(600);
        centerOperations.setAlignment(Pos.TOP_LEFT);

    //SCROLLPANE SETTING
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(centerOperations);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setMinSize(625,450);
        scrollPane.setMaxSize(625,450);

    //CONTEXT SECTION
    //Componenta accesibila
        Label labelTitleAcc = new Label("\t\tOperatia de construire a componentei accesibile");
        labelTitleAcc.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        labelTitleAcc.setWrapText(true);

        Label labelContentAcc1 = new Label("Definitie");
        labelContentAcc1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,12));

        Label labelContentAcc2 = new Label("\tOperatie de construire a componentei accesibile se noteaza Acc(G) " +
                ":= (Q’acc, ∑,δacc, q\u2080, Q\u2098acc ) unde Q’acc este inclus in Q, δacc  este o proiectie a lui δ pe  Q’acc " +
                "x ∑ , Qmacc este inclus in Q\u2098 . \n"+
                "\tOperatia de accesibilitate nu afecteaza limbajul generat sau limbajul marcat. \n");
        labelContentAcc2.setWrapText(true);

        Button buttonExampleAcc = new Button("Exemplu");
        buttonExampleAcc.setOnAction(event -> {ExempleWindow ex1 = new ExempleWindow("image\\acc.jpg", "Componenta accesibila");});

        centerOperations.getChildren().addAll(labelTitleAcc, labelContentAcc1,labelContentAcc2, buttonExampleAcc);

    //Componenta co-accesibila
        Label labelTitleCo = new Label("\t\tOperatia de construire a componentei co-accesibile");
        labelTitleCo.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        labelTitleCo.setWrapText(true);

        Label labelContentCo1 = new Label("Definitie");
        labelContentCo1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,12));

        Label labelContentCo2 = new Label("\tOperatie de construire a componentei accesibile se noteaza CoAcc(G) " +
                " := (Q’coacc, ∑, δcoacc, q\u2080coac, Q\u2098)."+
                "\n\tPrin Co-Accesibilitate se pot elimina blocajele de tip livelock sau deadlock.");
        labelContentCo2.setWrapText(true);

        Button buttonExampleCo = new Button("Exemplu");
        buttonExampleCo.setOnAction(event -> {ExempleWindow ex1 = new ExempleWindow("image\\co.jpg", "Componenta co-accesibila");});

        centerOperations.getChildren().addAll(labelTitleCo, labelContentCo1, labelContentCo2, buttonExampleCo);

    //Automatul Trim
        Label labelTitleTrim = new Label("\t\tOperatia de construire a automatului Trim");
        labelTitleTrim.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        labelTitleTrim.setWrapText(true);

        Label labelContentTrim1 = new Label("\tUn automat care este si accesibil si co-accesibil se numeste automat " +
                "Trim. Se defineste operatia Trim(G) = Acc(CoAcc(G)) = CoAcc(Acc(G)). \n" +
                "\tPrin aceasta operatie se reduce modelul de tip G la un submodel mai \"lucrativ\". Totusi, prin operatia " +
                "Trim se poate pierde starea initiala q\u2080 a modelului initial. Daca se intampla acest lucru, " +
                "atunci trebuie definita o noua stare initiala q\u2080Trim.");
        labelContentTrim1.setWrapText(true);

        Button buttonExampleTrim = new Button("Exemplu");
        buttonExampleTrim.setOnAction(event -> {ExempleWindow ex1 = new ExempleWindow("image\\trim.jpg", "Automatul Trim");});


        centerOperations.getChildren().addAll(labelTitleTrim, labelContentTrim1, buttonExampleTrim);


    //Complementul automatului
        Label labelTitleComp = new Label("\t\tOperatia de construire a complementului unui automat ");
        labelTitleComp.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        labelTitleComp.setWrapText(true);

        Label labelContentComp = new Label("\tPresupunand existenta unui automat G (Q, Σ, δ, q\u2080, Q\u2098) " +
                "se doreste aflarea complementului acestui automat G'. Acest nou automat are ca elemente marcate " +
                "sirurile nemarcate din G. \n" +
                "\tPentru a construi complementul unui automat este nevoie de 2 etape de constructie: \n" +
                "\t\t1. Aceasta etapa este necesara numai daca exista  λ definit pentru G (adica L ≠ Σ*) : \n" +
                "\t\t\t\u27B6 se completeaza G astfel incat limbajul marcat sa ramana acelasi si L = Σ*\n" +
                "\t\t\t\u27B6 pentru fiecare pereche qi si ej apartinand lui  λ(qi) se introduce δ(qi, ej) = qd," +
                "\n\t\tUnde qd este o stare noua, nemarcata care se adauga multimii starilor Q care deseori este " +
                "\n\t\t\tnumita o stare \"moarta\".\n" +
                "\t\t2. Pe automatul complet G se face urmatoarea schimbare : toate starile care erau marcate " +
                "devin nemarcate si toate starile care erau nemarcate devin marcate.\n");
        labelContentComp.setWrapText(true);

        centerOperations.getChildren().addAll(labelTitleComp, labelContentComp);


    //
        group.getChildren().addAll(centerOperations, scrollPane);

//LEFT BOX
        TreeView<String> tree;
        TreeItem<String> root, itemConcepts, itemProperties, itemOperations;

        //Root
        root = new TreeItem<>("Cuprins");
        root.setExpanded(true);

        //item
        itemConcepts = makeBranch("Concepts", root);
        itemProperties = makeBranch ("Proprietăti", root);
        itemOperations = makeBranch ("Operatii", root);


        //Create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(true);
        tree.getSelectionModel().selectedIndexProperty()
                .addListener((v, oldValue, newValue) -> {
                    if(newValue.intValue() == 0){
                        windows.setScene(sceneMenu);
                    }

                    if(newValue.intValue() == 1){
                        windows.setScene(sceneConcepts);
                    }


                    if(newValue.intValue() == 2){
                        windows.setScene(sceneProperties);
                    }
                });


        StackPane layoutTree = new StackPane();
        layoutTree.getChildren().add(tree);
        layoutTree.setMaxWidth(125);


//Bottom space from Operations' Window
        GridPane bottomOperations = new GridPane();
        bottomOperations.setPadding(new Insets(10, 10, 10, 10));
        bottomOperations.setHgap(5);
        bottomOperations.setVgap(10);

        //Button back
        Button buttonBack = new Button("Back");
        buttonBack.setOnAction(e -> windows.setScene(sceneMenu));
        GridPane.setHalignment(buttonBack, HPos.RIGHT);
        bottomOperations.add(buttonBack, 1, 1);

        //Layout
        BorderPane screen = new BorderPane();
        screen.setLeft(layoutTree);
        screen.setCenter(group);
        screen.setBottom(bottomOperations);

        sceneOperations = new Scene(screen, 750, 500);
    }

    public TreeItem<String> makeBranch (String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public static Scene getSceneOperations() {
        return sceneOperations;
    }

    public static void putWindow(Stage inputWindow) {
        windows = inputWindow;
    }

    public static void putSceneMenu (Scene inputMenu) {
        sceneMenu = inputMenu;
    }

    public static void putSceneProperties(Scene inputProperties) {
        sceneProperties = inputProperties;
    }

    public static void putSceneConcepts(Scene inputConcepts) {
        sceneConcepts = inputConcepts;
    }
}
