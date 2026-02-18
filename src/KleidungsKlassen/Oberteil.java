package KleidungsKlassen;

public abstract class Oberteil extends Kleidungsstueck {
    private int aermelLaenge;
    private String schnitt;

    public Oberteil(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad);
        this.aermelLaenge = aermelLaenge;
        this.schnitt = schnitt;
    }

    public Oberteil(String[] StringAusJson) {
        super(StringAusJson);
        this.aermelLaenge = Integer.parseInt(StringAusJson[6]);
        this.schnitt = StringAusJson[7];
    }


    public void setAermelLaenge(int aermelLaenge) {
        this.aermelLaenge = aermelLaenge;
    }

    public void setSchnitt(String schnitt) {
        this.schnitt = schnitt;
    }


    public int getAermelLaenge() {
        return aermelLaenge;
    }

    public String getSchnitt() {
        return schnitt;
    }
}