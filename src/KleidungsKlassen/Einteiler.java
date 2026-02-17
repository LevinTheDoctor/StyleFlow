package KleidungsKlassen;

public abstract class Einteiler extends Kleidungsstueck {
    private String ausschnittArt;
    private String weite;
    private int laenge;
    private boolean hatAermel;

    // Konstruktor für neue Kleidungsstücke
    public Einteiler(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String ausschnittArt, String weite, int laenge, boolean hatAermel) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad);
        this.ausschnittArt = ausschnittArt;
        this.weite = weite;
        this.laenge = laenge;
        this.hatAermel = hatAermel;
    }

    // Konstruktor zum Abrufen aus Dateien
    public Einteiler(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, String ausschnittArt, String weite, int laenge, boolean hatAermel) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID);
        this.ausschnittArt = ausschnittArt;
        this.weite = weite;
        this.laenge = laenge;
        this.hatAermel = hatAermel;
    }

    public String getAusschnittArt() {
        return ausschnittArt;
    }

    public void setAusschnittArt(String ausschnittArt) {
        this.ausschnittArt = ausschnittArt;
    }

    public String getWeite() {
        return weite;
    }

    public void setWeite(String weite) {
        this.weite = weite;
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public boolean isHatAermel() {
        return hatAermel;
    }

    public void setHatAermel(boolean hatAermel) {
        this.hatAermel = hatAermel;
    }
}