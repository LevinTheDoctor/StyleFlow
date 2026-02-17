package KleidungsKlassen;

public class TShirt extends Oberteil {
    private final String ausschnittArt;

    public TShirt(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, String ausschnittArt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt);
        this.ausschnittArt = ausschnittArt;
    }

    public TShirt(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, int aermelLaenge, String schnitt, String ausschnittArt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, aermelLaenge, schnitt);
        this.ausschnittArt = ausschnittArt;
    }

    public String getAusschnittArt() {
        return ausschnittArt;
    }
}