package KleidungsKlassen;

public class Sneaker extends Schuhe {
    private final String technologie;

    public Sneaker(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, String absatzHoehe, String verschlussArt, String technologie) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke, absatzHoehe, verschlussArt);
        this.technologie = technologie;
    }

    public Sneaker(String[] StringAusJson) {
        super(StringAusJson);
        this.technologie = StringAusJson[9];
    }


    public String getTechnologie() {
        return technologie;
    }
}