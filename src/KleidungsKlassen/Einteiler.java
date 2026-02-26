package KleidungsKlassen;

public abstract class Einteiler extends Kleidungsstueck {
    private String ausschnittArt;
    private String weite;
    private int laenge;
    private final boolean hatAermel;

    public Einteiler(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String marke,String ausschnittArt, String weite, int laenge, boolean hatAermel) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke);
        this.ausschnittArt = ausschnittArt;
        this.weite = weite;
        this.laenge = laenge;
        this.hatAermel = hatAermel;
    }

    public Einteiler(String[] StringAusJson) {
        super(StringAusJson);
        this.ausschnittArt = StringAusJson[7];
        this.weite = StringAusJson[8];
        this.laenge = Integer.parseInt(StringAusJson[9]);
        this.hatAermel = Boolean.parseBoolean(StringAusJson[10]);
    }


    public void setAusschnittArt(String ausschnittArt) {
        this.ausschnittArt = ausschnittArt;
    }

    public void setWeite(String weite) {
        this.weite = weite;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }


    public String getAusschnittArt() {
        return ausschnittArt;
    }

    public String getWeite() {
        return weite;
    }

    public int getLaenge() {
        return laenge;
    }

    public boolean isHatAermel() {
        return hatAermel;
    }
}