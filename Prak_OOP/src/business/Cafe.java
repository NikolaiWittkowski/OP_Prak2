package business;

public class Cafe {
    private String name;
    private String ort;
    private String beschreibung;
    private boolean mitBackwerk;
    private String[] kaffeeprodukte;

    public Cafe(String name, String ort, String beschreibung, boolean mitBackwerk, String[] kaffeeprodukte) {
        this.name = name;
        this.ort = ort;
        this.beschreibung = beschreibung;
        this.mitBackwerk = mitBackwerk;
        this.kaffeeprodukte = kaffeeprodukte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public boolean isMitBackwerk() {
        return mitBackwerk;
    }

    public void setMitBackwerk(boolean mitBackwerk) {
        this.mitBackwerk = mitBackwerk;
    }

    public String[] getKaffeeprodukte() {
        return kaffeeprodukte;
    }

    public void setKaffeeprodukte(String[] kaffeeprodukte) {
        this.kaffeeprodukte = kaffeeprodukte;
    }

    public String getKaffeeProdukteAlsString(char trenner) {
        StringBuilder ergebnis = new StringBuilder();
        for (int i = 0; i < this.kaffeeprodukte.length - 1; i++) {
            ergebnis.append(this.kaffeeprodukte[i]).append(trenner);
        }
        return ergebnis.append(this.kaffeeprodukte[this.kaffeeprodukte.length - 1]).toString();
    }

    public String gibCafeZurueck(char trenner) {
        return this.getName() + trenner 
             + this.getOrt() + trenner
             + this.getBeschreibung() + trenner
             + this.isMitBackwerk() + trenner + "\n"
             + this.getKaffeeProdukteAlsString(trenner) + "\n";
    }
}

