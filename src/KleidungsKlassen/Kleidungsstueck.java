package KleidungsKlassen;
import static Logik.ProgrammLogik.BildBewegen;

public abstract class Kleidungsstueck
{
	private final String bezeichnung;
    private final String bedecktesKoerperteil;
    private final int kleidungsID;
    private static int anzahlProKlasse; // muss noch definiert werden
    private static int gesamtAnzahl;

    private String[] farben;
    private String wettereignung;
    private String bildDateiPfad;
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
        this.bildDateiPfad = BildBewegen(bildDateiPfad);
        gesamtAnzahl += 1;
        this.kleidungsID = gesamtAnzahl;
    }

    // Konstruktor zum Abrufen aus den Dateien
    public Kleidungsstueck(String [] StringAusJson) {
        this.bezeichnung = StringAusJson[0];
        this.farben = StringAusJson[1].split(",");
        this.bedecktesKoerperteil = StringAusJson[2];
        this.wettereignung = StringAusJson[3];
        this.bildDateiPfad = StringAusJson[4];
        this.kleidungsID = Integer.parseInt(StringAusJson[5]);
        gesamtAnzahl += 1;
    }
    

    // Setter für optionale Felder
    public void setFarben(String[] farben) {
        this.farben = farben;
    }

    public void setWettereignung(String wettereignung) {
        this.wettereignung = wettereignung;
    }

    public void setBildDateiPfad(String bildDateiPfad) {
        this.bildDateiPfad = bildDateiPfad;
    }
    
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