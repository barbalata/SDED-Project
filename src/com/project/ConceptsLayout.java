package com.project;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;


/**
 * Created by Barbalata-PC on 23.05.2017.
 */
public class ConceptsLayout {
    static Stage windows;
    static Scene sceneMenu;
    static Scene sceneConcepts;
    static Scene sceneProperties;
    static Scene sceneOperations;

    public ConceptsLayout(){

//Central content
        Group group = new Group();

        VBox centerConcepts = new VBox(5);
        centerConcepts.setPadding(new Insets(40,20,20,20));
        centerConcepts.setMaxWidth(600);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(centerConcepts);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setMinSize(625,450);
        scrollPane.setMaxSize(625,450);

        Label labelTitle = new Label("Concept");
        labelTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        centerConcepts.getChildren().add(labelTitle);
        centerConcepts.setAlignment(Pos.TOP_CENTER);


        Label labelFirst = new Label("\tOrice sistem cu evenimente discrete G (Q, ∑, δ, q\u2080) al carui limbaj generat " +
                "este regulat, poate fi reprezentat ca Automat Finit Determinist Gd = (Q, ∑, δ, q\u2080 , q\u2098)."+
                        "\n \tUn automat finit determinist este format din"+
                        "\n \t\t \u25B6 Un numar finit de stari (Q)" +
                        "\n \t\t \u25B6 Un alfabet de evenimente (∑)" +
                        "\n \t\t \u25B6 Stare initiala (q\u2080)" +
                        "\n \t\t \u25B6 Functia de tranzitie (δ)" +
                        "\n \t\t \u25B6 Multimea starilor marcate (Q\u2098)" +
                        "\n\t Acesta se reprezinta cu ajutorul urmatoarelor figuri:");
        labelFirst.setWrapText(true);
        labelFirst.setTextAlignment(TextAlignment.LEFT);
        centerConcepts.getChildren().add(labelFirst);

        Image image1 = new Image("file:image\\1.png", true);
        ImageView imageView = new ImageView(image1);
        centerConcepts.getChildren().addAll(imageView);


        Label labelTitle1 = new Label("Cum proceseaza un AFD intrarile?");
        labelTitle1.setFont(Font.font("Arial", FontPosture.ITALIC, 14));
        centerConcepts.getChildren().add(labelTitle1);

        Label labelText2 = new Label("\tProblema care apare este daca un sir apartine sau nu unui limbaj. " +
                "De exemplu, analizorul lexical care intra in componenta unui compilator trebuie sa decida daca " +
                "programul sursa contine cuvinte (siruri) nepermise de limbaj. De fapt multe probleme se pot reduce" +
                " la probleme de apartenenta a sirurilor la limbaje. Sa presupunem ca pe banda de intrare a " +
                "unui AFD se afla urmatoarea succesiune de simboli: a\u2081,a\u2082,...,a\u2099 aceste intrari. Automatul are " +
                "starea initiala q\u2080. Pentru a afla starea in care trece automatul dupa procesarea simbolului a\u2081, " +
                "inspectam functia de tranzitie δ. Sa presupunem ca δ (q\u2080, a\u2081) = q\u2081. Deci q\u2081 va fi starea in care se " +
                "afla automatul dupa procesarea lui a1. Urmatoarea stare in care va trece automatul este q\u2082 = δ(q\u2081, a\u2082)." +
                " Se continua in aceeasi maniera, automatul ajungand in final starea q\u2099. In acest moment nu mai " +
                "exista nici un simbol de procesat si putem afirma ca sirul este acceptat daca qn reprezinta o stare " +
                "finala sau ca nu este acceptat daca q\u2099 nu este finala. AFD-urile sunt folosite, la fel ca si expresiile " +
                "regulate de altfel, pentru a defini un limbaj (multimea tuturor sirurilor care procesate lasa automatul " +
                "intr-o stare finala).");
        labelText2.setWrapText(true);
        labelText2.setTextAlignment(TextAlignment.LEFT);
        centerConcepts.getChildren().add(labelText2);

        Label labelTitle2 = new Label("Reprezentarea unui AFD");
        labelTitle2.setFont(Font.font("Arial", FontPosture.ITALIC, 14));
        centerConcepts.getChildren().add(labelTitle2);

        Label labelText3 = new Label("Un AFD se poate reprezinta in doua moduri: \n" +
                "\t1. printr-o diagrama de tranzitii\n" +
                "\t2. printr-un tabel de tranzitii\n" +
                "\n\tObservatii:\n" +
                "\t\u2B23 Automatele finite deterministe pentru care Q\u2098 ≠ ᴓ se numesc acceptoare pentru ca orice sir w " +
                "∈ ∑* astfel incat ∃ δ(q\u2080, w) ∈ Qm se numeste acceptat\n"+
                "\t\u2B23 Un limbaj este o multime de cuvinte ale aceluiasi alfabet. Limbajul generat de un system cu " +
                "evenimente discrete G (Q, ∑, δ, q\u2080) este multimea L = { w ∈ \u03A3* | ∃ δ(q\u2080,w)ϵ Q}. \n" +
                "\t\u2B23 Daca multimea starilor marcate (Q\u2098) este diferita de multimea vida, atunci se poate defini " +
                "limbajul marcat al unui sistem cu evenimente discrete G care se noteaza L\u2098 = {w ∈ L | ∃ δ(q\u2080,w)ϵ Q\u2098}");
        labelText3.setWrapText(true);
        labelText3.setTextAlignment(TextAlignment.LEFT);
        centerConcepts.getChildren().add(labelText3);

        group.getChildren().addAll(centerConcepts, scrollPane);
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


                    if(newValue.intValue() == 2){
                        windows.setScene(sceneProperties);
                    }

                    if(newValue.intValue() == 3){
                        windows.setScene(sceneOperations);
                    }
                });


        StackPane layoutTree = new StackPane();
        layoutTree.getChildren().add(tree);
        layoutTree.setMaxWidth(125);


//Bottom space from Concepts' Window
        GridPane bottomConcepts = new GridPane();
        bottomConcepts.setPadding(new Insets(10, 10, 10, 10));
        bottomConcepts.setHgap(5);
        bottomConcepts.setVgap(10);

        //Button back
        Button buttonBack = new Button("Back");
        buttonBack.setOnAction(e -> windows.setScene(sceneMenu));
        GridPane.setHalignment(buttonBack, HPos.RIGHT);
        bottomConcepts.add(buttonBack, 1, 1);

        //Layout
        BorderPane screen = new BorderPane();
        screen.setLeft(layoutTree);
        screen.setCenter(group);
        screen.setBottom(bottomConcepts);

        sceneConcepts = new Scene(screen, 750, 500);
    }

    public TreeItem<String> makeBranch (String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public static Scene getSceneConcepts() {
        return sceneConcepts;
    }

    public static void putWindow(Stage inputWindow) {
        windows = inputWindow;
    }

    public static void putSceneMenu (Scene inputMenu) {
        sceneMenu = inputMenu;
    }

    public static void putSceneOperations(Scene inputOperations) {
        sceneOperations = inputOperations;
    }

    public static void putSceneProperties(Scene inputProperties) {
        sceneProperties = inputProperties;
    }


}
