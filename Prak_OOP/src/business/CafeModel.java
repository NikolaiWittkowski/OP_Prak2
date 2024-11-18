package business;

import factory.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CafeModel {
    private Cafe cafe;

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }


    public void leseAusDatei(String typ) throws IOException {
        Creator creator = new ConcreteCreator();
        Product reader = creator.createCr(typ);
        
        String[] zeile = reader.leseAusDatei();
        this.cafe = new Cafe(zeile[0], zeile[1], zeile[2], Boolean.parseBoolean(zeile[3]), zeile[4].split(";"));
        
        reader.schliesseDatei(); 
    }


    public void schreibeCafeInCsvDatei() throws IOException {
        if (this.cafe != null) {
            try (BufferedWriter aus = new BufferedWriter(new FileWriter("CafeAusgabe.csv", true))) {
                aus.write(cafe.gibCafeZurueck(';'));
                aus.newLine(); 
            }
        } else {
            throw new IllegalStateException("Kein Cafe gespeichert.");
        }
    }
}
