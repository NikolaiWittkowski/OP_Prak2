package MVC;

import business.Cafe;
import business.CafeModel;
import javafx.stage.Stage;

public class CafeControl {
    private CafeView caView;
    private CafeModel caMod;

    public CafeControl(Stage primaryStage) {
        this.caMod = new CafeModel();
        this.caView = new CafeView(this, primaryStage);
    }

    public void nehmeCafeAuf() {
        try {
            Cafe cafe = new Cafe(
                caView.getTxtName(), 
                caView.getTxtOrt(),
                caView.getTxtBeschreibung(),
                Boolean.parseBoolean(caView.getTxtMitBackwerk()),
                caView.getTxtKaffeeprodukte().split(";")
            );
            caMod.setCafe(cafe);
            caView.zeigeInformationsfensterAn("Das Cafe wurde aufgenommen!");
        } catch (Exception e) {
            caView.zeigeFehlermeldungsfensterAn("Fehler: " + e.getMessage());
        }
    }

    public void zeigeCafeAn() {
        Cafe cafe = caMod.getCafe();
        if (cafe != null) {
            caView.setTxtAnzeige(cafe.gibCafeZurueck(';'));
        } else {
            caView.zeigeInformationsfensterAn("Kein Cafe verfügbar.");
        }
    }

    public void importiereCafe(String typ) {
        try {
            caMod.leseAusDatei(typ);
            zeigeCafeAn();
            caView.zeigeInformationsfensterAn("Daten erfolgreich importiert.");
        } catch (Exception e) {
            caView.zeigeFehlermeldungsfensterAn("Fehler: " + e.getMessage());
        }
    }

    public void exportiereCafe() {
        try {
            caMod.schreibeCafeInCsvDatei();
            caView.zeigeInformationsfensterAn("Daten erfolgreich exportiert.");
        } catch (Exception e) {
            caView.zeigeFehlermeldungsfensterAn("Fehler: " + e.getMessage());
        }
    }
}

