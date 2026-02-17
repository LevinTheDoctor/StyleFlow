package KleidungsKlassen;

public class Pullover extends Oberteil {
    private final String ausschnittArt;
    private final String strickArt;

    public Pullover(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, String ausschnittArt, String strickArt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt);
        this.ausschnittArt = ausschnittArt;
        this.strickArt = strickArt;
    }

    public Pullover(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, int aermelLaenge, String schnitt, String ausschnittArt, String strickArt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, aermelLaenge, schnitt);
        this.ausschnittArt = ausschnittArt;
        this.strickArt = strickArt;
    }

    public String getAusschnittArt() {
        return ausschnittArt;
    }

    public String getStrickArt() {
        return strickArt;
    }
}