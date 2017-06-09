package com.project;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class PropertiesLayout {

    static Stage windows;
    static Scene sceneMenu;
    static Scene sceneConcepts;
    static Scene sceneProperties;
    static Scene sceneOperations;

    public PropertiesLayout(){
//Central content
        Group group = new Group();

        VBox centerProperties = new VBox(5);
        centerProperties.setPadding(new Insets(40,20,20,20));
        centerProperties.setMaxWidth(600);

//SCROLLPANE SETTINGS
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(centerProperties);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setMinSize(625,450);
        scrollPane.setMaxSize(625,450);

//CONTEXT SECTION
    //TITLE
        Label labelTitle = new Label("\t\t\t\t\tProprietăți");
        labelTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        centerProperties.getChildren().add(labelTitle);

    //SHORT DESCRIPTION
        Label labelText1 = new Label("\n\tUn automat finit determinist are urmatoarele proprietati: \n" +
                "\t\u2B25 Reversibilitatea\n" +
                "\t\u2B25 Blocaje\n" +
                "\t\u2B25 Accesibilitatea\n" +
                "\t\u2B25 Co-accesibilitatea\n");

    //REVERSIBILITATE
        Label labelTitle1 = new Label("\n\n\t\tReversibilitatea");
        labelTitle1.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 14));

        Label labelText2 = new Label("Definitie:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        labelText2.setTextAlignment(TextAlignment.LEFT);
        labelText2.setFont(Font.font("Arial", FontPosture.ITALIC, 12));

        Label labelText3 = new Label("Fie doua stari, qi, qj, astfel incat exista δ(qi, et) = qj.\n" +
                "Exista reversibilitate in raport cu qi si qj, daca exista un eveniment em si un δ(qj, em) = qi.\n" +
                "Altfel spus, doua stari sunt reversibile daca si numai daca exista doua evenimente ce permit trecerea " +
                "dintr-o stare in cealalta.");
        labelText3.setWrapText(true);

        Image image1 = new Image("file:image\\rev.jpg");
        System.out.println(image1.getHeight() + " " + image1.getWidth());
        ImageView imageView = new ImageView(image1);
        centerProperties.getChildren().addAll(labelText1, labelTitle1, labelText2,labelText3, imageView);

    //BLOCAJE
        Label labelTitle2 = new Label("\n\n\t\tBlocaje");
        labelTitle2.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 14));

        Label labelTextB1 = new Label("Definitie:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        labelTextB1.setTextAlignment(TextAlignment.LEFT);
        labelTextB1.setFont(Font.font("Arial", FontPosture.ITALIC, 12));

        Label labelTextB2 = new Label("\tSe numeste blocaj o stare qi care apartine multimii Q\\Q\u2098 " +
                "din care nu se mai poate ajunge in Q\u2098. Altfel spus, nu exista w care apartine ∑* astfel incat" +
                " δ(qi, w) apartine Q\u2098.\n" +
                "\tBlocajele se impart in doua categorii:\n");
        labelTextB2.setWrapText(true);

    //DEADLOCK
        Label labelTextB3 = new Label("\t\u2B25 Blocaje deadlock\n");
        labelTextB3.setFont(Font.font("Arial", FontPosture.ITALIC, 12));

        Label labelTextB4 = new Label("\t\tDefinitie: Starea qi este deadlock daca λ(qi) = ∑ (din qi sistemul " +
                "nu mai evolueaza deloc). \n\tAceasta " +
                "proprietatea apare doar pentru acele modele pentru care δ nu este complet definit. " +
                "\n\tPe scurt, daca procesul ajunge " +
                "intr-o stare din care nu poate evolua sau reveni, atunci acest \n\tfenomen se numeste deadlock.\n");
        labelTextB4.setWrapText(true);

        Button buttonDeadblocExample = new Button("Exemplu");
        buttonDeadblocExample.setOnAction(event -> {ExempleWindow ex1 = new ExempleWindow("image\\dead.png", "BLOCAJ DEADLOCK");});


        //LIVELOCK
        Label labelTextB5 = new Label("\t\u2B25 Blocaje livelock");
        labelTextB5.setFont(Font.font("Arial", FontPosture.ITALIC, 12));

        Label labelTextB6 = new Label("\t\tSe defineste o stare qi ca fiind in livelock (sau o multime de stari Q\u2091 " +
                "inclusa in Q mai putin Q\u2098) \n\tpentru care oricare w apartinand lui ∑* avem δ(qi, w) apartine lui " +
                "Q mai putin Q\u2098. Pe scurt, \n\tdaca procesul contine bucle (adica se poate repeta la nesfarsit) fara sa " +
                "existe posibilitatea de a trece \n\tintr-o stare marcata. \n");
        labelTextB6.setWrapText(true);

        Button buttonLiveblockExample = new Button("Exemplu");
        buttonLiveblockExample.setOnAction(event -> {ExempleWindow ex1 = new ExempleWindow("image\\live.png", "BLOCAJ LIVEBLOCK");});


        Label labelTextB7 = new Label("\t\tDe asemenea, exista si posibilitatea ca un proces sa intalneasca " +
                "livedeadlock adica poate \n\tajunge intr-un punct din care nu mai poate evolua deloc. Fie este un deadlock " +
                "sau poate ajunge \n\tintr-o stare in care exista o bucla si nu poate ajunge intr-o alta stare marcata.\n");
        labelTextB7.setWrapText(true);

        centerProperties.getChildren().addAll(labelTitle2, labelTextB1,labelTextB2, labelTextB3, labelTextB4, buttonDeadblocExample, labelTextB5, labelTextB6, buttonLiveblockExample, labelTextB7);

    //ACCESIBILITATE
        Label labelTitle4 = new Label("\n\n\t\tAccesibilitatea");
        labelTitle4.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 14));

        Label labelTextA1 = new Label("\tO stare qi apartinand lui Q este accesibila daca exista cel putin un sir " +
                "w apartinand lui ∑* astfel incat δ(q\u2092, w) = qi. \n\tIn contextul unei perechi de stari qi si qj " +
                "se spune ca o stare qi este accesibila din qj daca exista w apartinand ∑* astfel incat δ(qj, w) " +
                "= qi . Din definitiile limbajului generat si limbajului marcat se poate observa faptul ca se pot " +
                "elimina din G toate starile care nu sunt accesibile din qo fara a afecta limbajul generat si marcat. " +
                "Atunci cand ‚se sterge’ o stare, se sterg si tranzitiile acesteia. \n\tAceasta stergere se poate executa " +
                "cu ajutorul componentei accesibile." +
                "apasati aici ");
        labelTextA1.setWrapText(true);

        Button buttonAcc = new Button("Modul de obtinere a unui automat accesibil");
        buttonAcc.setOnAction(event -> {windows.setScene(sceneOperations);});

        centerProperties.getChildren().addAll(labelTitle4, labelTextA1, buttonAcc);


    //CO-ACCESIBILITATE
        Label labelTitle5 = new Label("\n\n\t\tCo-accesibilitatea");
        labelTitle5.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 14));

        Label labelTextC1 = new Label("\tO stare q este co-accesibila daca procesul poate evolua din aceasta stare " +
                "intr-o stare marcata. O stare qi apartinand lui Q mai putin Qm este co-accesibila daca exista un " +
                "sir w apartinand lui ∑* astfel incat δ(qo, w) apartine lui Q\u2098 . \n\tSe pot astfel \"sterge\" starile " +
                "care nu sunt co-accesibile. Prin aceasta operatie se poate modifica limbajul generat pentru ca " +
                "se pot sterge stari care sunt accesibile din q\u2080. Totusi, aceasta operatie nu afecteaza limbajul " +
                "generat.");
        labelTextC1.setWrapText(true);

        Button buttonCo = new Button("Modul de obtinere a unui automat co-accesibil");
        buttonCo.setOnAction(event -> {windows.setScene(sceneOperations);});

        centerProperties.getChildren().addAll(labelTitle5, labelTextC1, buttonCo);


//
        group.getChildren().addAll(centerProperties, scrollPane);

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

                    if(newValue.intValue() == 3){
                        windows.setScene(sceneOperations);
                    }
                });


        StackPane layoutTree = new StackPane();
        layoutTree.getChildren().add(tree);
        layoutTree.setMaxWidth(125);


//Bottom space from Properties' Window
        GridPane bottomProperties = new GridPane();
        bottomProperties.setPadding(new Insets(10, 10, 10, 10));
        bottomProperties.setHgap(5);
        bottomProperties.setVgap(10);

        //Button back
        Button buttonBack = new Button("Back");
        buttonBack.setOnAction(e -> windows.setScene(sceneMenu));
        GridPane.setHalignment(buttonBack, HPos.RIGHT);
        bottomProperties.add(buttonBack, 1, 1);

        //Layout
        BorderPane screen = new BorderPane();
        screen.setLeft(layoutTree);
        screen.setCenter(group);
        screen.setBottom(bottomProperties);

        sceneProperties = new Scene(screen, 750, 500);
}

    public TreeItem<String> makeBranch (String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public static Scene getSceneProperties() {
        return sceneProperties;
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

    public static void putSceneConcepts(Scene inputConcepts) {
        sceneConcepts = inputConcepts;
    }
}
