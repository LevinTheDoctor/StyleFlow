package KleidungsKlassen;

public class Hose extends Unterteil {
    private final boolean hatLoecher;
    private final String weite;
    private final String waschung;
    private final String besonderheiten;
    private final String artDerHose;

    public Hose(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int laenge, int anzahlTaschen, boolean hatLoecher, String weite, String waschung, String besonderheiten, String artDerHose) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, laenge, anzahlTaschen);
        this.hatLoecher = hatLoecher;
        this.weite = weite;
        this.waschung = waschung;
        this.besonderheiten = besonderheiten;
        this.artDerHose = artDerHose;
    }

    public Hose(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, int laenge, int anzahlTaschen, boolean hatLoecher, String weite, String waschung, String besonderheiten, String artDerHose) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, laenge, anzahlTaschen);
        this.hatLoecher = hatLoecher;
        this.weite = weite;
        this.waschung = waschung;
        this.besonderheiten = besonderheiten;
        this.artDerHose = artDerHose;
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