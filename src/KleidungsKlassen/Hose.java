package KleidungsKlassen;

public class Hose extends Unterteil {
    private boolean hatLoecher;
    private String weite;
    private String waschung;
    private String besonderheiten;
    private final String artDerHose;

    public Hose(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int laenge, int anzahlTaschen, boolean hatLoecher, String weite, String waschung, String besonderheiten, String artDerHose) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, laenge, anzahlTaschen);
        this.hatLoecher = hatLoecher;
        this.weite = weite;
        this.waschung = waschung;
        this.besonderheiten = besonderheiten;
        this.artDerHose = artDerHose;
    }

    public Hose(String[] StringAusJson) {
        super(StringAusJson);
        this.hatLoecher = Boolean.parseBoolean(StringAusJson[8]);
        this.weite = StringAusJson[9];
        this.waschung = StringAusJson[10];
        this.besonderheiten = StringAusJson[11];
        this.artDerHose = StringAusJson[12];
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

    public String getArtDerHose() {
        return artDerHose;
    }
}