package MVC;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CafeView {
    private CafeControl caCon;

    private Pane pane = new Pane();

    // Labels
    private Label lblEingabe = new Label("Eingabe");
    private Label lblAnzeige = new Label("Anzeige");
    private Label lblName = new Label("Name:");
    private Label lblOrt = new Label("Ort:");
    private Label lblBeschreibung = new Label("Beschreibung:");
    private Label lblBackwerk = new Label("Bäckerei angeschlossen:");
    private Label lblKaffeeprodukte = new Label("Kaffeeprodukte:");

    // Eingabefelder
    private TextField txtName = new TextField();
    private TextField txtOrt = new TextField();
    private TextField txtBeschreibung = new TextField();
    private TextField txtMitBackwerk = new TextField();
    private TextField txtKaffeeprodukte = new TextField();

    // Anzeige
    private TextArea txtAnzeige = new TextArea();

    // Buttons
    private Button btnEingabe = new Button("Eingabe");
    private Button btnAnzeige = new Button("Anzeige");

    // Menüleiste
    private MenuBar mnbrMenuLeiste = new MenuBar();
    private Menu mnDatei = new Menu("Datei");
    private MenuItem mnItmCsvImport = new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport = new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport = new MenuItem("csv-Export");

    public CafeView(CafeControl cafeControl, Stage primaryStage) {
        this.caCon = cafeControl;

        // Fenster
        Scene scene = new Scene(this.pane, 700, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Verwaltung von Cafe");
        primaryStage.show();

        initKomponenten();
        initListener();
    }

    private void initKomponenten() {
        // Layout für Labels
        lblEingabe.setLayoutX(20);
        lblEingabe.setLayoutY(40);
        lblEingabe.setFont(new Font("Arial", 24));
        lblEingabe.setStyle("-fx-font-weight: bold;");

        lblAnzeige.setLayoutX(400);
        lblAnzeige.setLayoutY(40);
        lblAnzeige.setFont(new Font("Arial", 24));
        lblAnzeige.setStyle("-fx-font-weight: bold;");

        lblName.setLayoutX(20);
        lblName.setLayoutY(90);
        lblOrt.setLayoutX(20);
        lblOrt.setLayoutY(130);
        lblBeschreibung.setLayoutX(20);
        lblBeschreibung.setLayoutY(170);
        lblBackwerk.setLayoutX(20);
        lblBackwerk.setLayoutY(210);
        lblKaffeeprodukte.setLayoutX(20);
        lblKaffeeprodukte.setLayoutY(250);

        pane.getChildren().addAll(lblEingabe, lblAnzeige, lblName, lblOrt, lblBeschreibung, lblBackwerk, lblKaffeeprodukte);

        // Layout für Textfelder
        txtName.setLayoutX(170);
        txtName.setLayoutY(90);
        txtName.setPrefWidth(200);

        txtOrt.setLayoutX(170);
        txtOrt.setLayoutY(130);
        txtOrt.setPrefWidth(200);

        txtBeschreibung.setLayoutX(170);
        txtBeschreibung.setLayoutY(170);
        txtBeschreibung.setPrefWidth(200);

        txtMitBackwerk.setLayoutX(170);
        txtMitBackwerk.setLayoutY(210);
        txtMitBackwerk.setPrefWidth(200);

        txtKaffeeprodukte.setLayoutX(170);
        txtKaffeeprodukte.setLayoutY(250);
        txtKaffeeprodukte.setPrefWidth(200);

        pane.getChildren().addAll(txtName, txtOrt, txtBeschreibung, txtMitBackwerk, txtKaffeeprodukte);

        // Layout für TextArea
        txtAnzeige.setEditable(false);
        txtAnzeige.setLayoutX(400);
        txtAnzeige.setLayoutY(90);
        txtAnzeige.setPrefWidth(270);
        txtAnzeige.setPrefHeight(185);

        pane.getChildren().add(txtAnzeige);

        // Layout für Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);

        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);

        pane.getChildren().addAll(btnEingabe, btnAnzeige);

        // Menüleiste
        mnDatei.getItems().addAll(mnItmCsvImport, mnItmTxtImport, new SeparatorMenuItem(), mnItmCsvExport);
        mnbrMenuLeiste.getMenus().add(mnDatei);

        pane.getChildren().add(mnbrMenuLeiste);
    }

    private void initListener() {
        btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                caCon.nehmeCafeAuf();
            }
        });

        btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                caCon.zeigeCafeAn();
            }
        });

        mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                caCon.importiereCafe("csv");
            }
        });

        mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                caCon.importiereCafe("txt");
            }
        });

        mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                caCon.exportiereCafe();
            }
        });
    }

    // Getter für Textfelder
    public String getTxtName() {
        return txtName.getText();
    }

    public String getTxtOrt() {
        return txtOrt.getText();
    }

    public String getTxtBeschreibung() {
        return txtBeschreibung.getText();
    }

    public String getTxtMitBackwerk() {
        return txtMitBackwerk.getText();
    }

    public String getTxtKaffeeprodukte() {
        return txtKaffeeprodukte.getText();
    }

    // Setter für Anzeige
    public void setTxtAnzeige(String text) {
        txtAnzeige.setText(text);
    }

    // Meldungsfenster
    public void zeigeInformationsfensterAn(String meldung) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(meldung);
        alert.showAndWait();
    }

    public void zeigeFehlermeldungsfensterAn(String meldung) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Fehler");
        alert.setContentText(meldung);
        alert.showAndWait();
    }
}

