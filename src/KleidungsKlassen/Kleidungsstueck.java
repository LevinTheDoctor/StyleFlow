package KleidungsKlassen;

public abstract class Kleidungsstueck
{
    private final String bezeichnung;
    private final String[] farben;
    private final String wettereignung;
    private final String bedecktesKoerperteil;
    private final String bildDateiPfad;
    private final int kleidungsID;
    private static int anzahlProKlasse; // muss noch definiert werden
    private static int gesamtAnzahl;

    private String[] material;
    private String[] style;
    private String marke;
    private String anmerkung;

    // Konstruktor für neue Kleidungsstücke
    public Kleidungsstueck(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad) {
        this.bezeichnung = bezeichnung;
        this.farben = farben;
        this.bedecktesKoerperteil = bedecktesKoerperteil;
        this.wettereignung = wettereignung;
        this.bildDateiPfad = bildDateiPfad;
        gesamtAnzahl += 1;
        this.kleidungsID = gesamtAnzahl;
    }

    // Konstruktor zum Abrufen aus den Dateien
    public Kleidungsstueck(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID) {
        this.bezeichnung = bezeichnung;
        this.farben = farben;
        this.bedecktesKoerperteil = bedecktesKoerperteil;
        this.wettereignung = wettereignung;
        this.bildDateiPfad = bildDateiPfad;
        this.kleidungsID = kleidungsID;
        gesamtAnzahl += 1;
    }

    // Setter für optionale Felder
    public void setMarke(String marke) {
        this.marke = marke;
    }

    public void setStyle(String[] style) {
        this.style = style;
    }

    public void setMaterial(String[] material) {
        this.material = material;
    }

    public void setAnmerkung(String anmerkung) {
        this.anmerkung = anmerkung;
    }

    // Getter
    public String getBezeichnung() {
        return bezeichnung;
    }

    public String[] getFarben() {
        return farben;
    }

    public String[] getMaterial() {
        return material;
    }

    public String getMarke() {
        return marke;
    }

    public String[] getStyle() {
        return style;
    }

    public String getBedecktesKoerperteil() {
        return bedecktesKoerperteil;
    }

    public String getWettereignung() {
        return wettereignung;
    }

    public String getBildDateiPfad() {
        return bildDateiPfad;
    }

    public String getAnmerkung() {
        return anmerkung;
    }

    public int getKleidungsID() {
        return kleidungsID;
    }

    public static int getGesamtAnzahl() {
        return gesamtAnzahl;
    }

    public static int getAnzahlProKlasse() {
        return anzahlProKlasse;
    }
}