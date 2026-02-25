package KleidungsKlassen;

public class Hose extends Unterteil {
    private boolean hatLoecher;
    private String weite;
    private String waschung;
    private String besonderheiten;
    private final String artHose;

    public Hose(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String marke,int laenge, int anzahlTaschen, boolean hatLoecher, String weite, String waschung, String besonderheiten, String artHose) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke, laenge, anzahlTaschen);
        this.hatLoecher = hatLoecher;
        this.weite = weite;
        this.waschung = waschung;
        this.besonderheiten = besonderheiten;
        this.artHose = artHose;
    }

    public Hose(String[] StringAusJson) {
        super(StringAusJson);
        this.hatLoecher = Boolean.parseBoolean(StringAusJson[8]);
        this.weite = StringAusJson[9];
        this.waschung = StringAusJson[10];
        this.besonderheiten = StringAusJson[11];
        this.artHose = StringAusJson[12];
    }


    public void setHatLoecher(boolean hatLoecher) {
        this.hatLoecher = hatLoecher;
    }

    public void setWeite(String weite) {
        this.weite = weite;
    }

    public void setWaschung(String waschung) {
        this.waschung = waschung;
    }

    public void setBesonderheiten(String besonderheiten) {
        this.besonderheiten = besonderheiten;
    }


    public boolean isHatLoecher() {
        return hatLoecher;
    }

    public String getWeite() {
        return weite;
    }

    public String getWaschung() {
        return waschung;
    }

    public String getBesonderheiten() {
        return besonderheiten;
    }

    public String getArtHose() {
        return artHose;
    }
}