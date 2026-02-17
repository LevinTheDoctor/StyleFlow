package KleidungsKlassen;

public class Sneaker extends Schuhe {
    private final String technologie;

    public Sneaker(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String absatzHoehe, String verschlussArt, String technologie) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, absatzHoehe, verschlussArt);
        this.technologie = technologie;
    }

    public Sneaker(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, String absatzHoehe, String verschlussArt, String technologie) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, absatzHoehe, verschlussArt);
        this.technologie = technologie;
    }

    public String getTechnologie() {
        return technologie;
    }
}