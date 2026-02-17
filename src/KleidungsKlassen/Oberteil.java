package KleidungsKlassen;

public abstract class Oberteil extends Kleidungsstueck {
    private final int aermelLaenge;
    private final String schnitt;

    public Oberteil(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad);
        this.aermelLaenge = aermelLaenge;
        this.schnitt = schnitt;
    }

    public Oberteil(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, int aermelLaenge, String schnitt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID);
        this.aermelLaenge = aermelLaenge;
        this.schnitt = schnitt;
    }

    public int getAermelLaenge() {
        return aermelLaenge;
    }

    public String getSchnitt() {
        return schnitt;
    }
}