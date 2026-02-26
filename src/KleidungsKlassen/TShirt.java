package KleidungsKlassen;

public class TShirt extends Oberteil {
    private final String ausschnittArt;

    public TShirt(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String marke,int aermelLaenge, String schnitt, String ausschnittArt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke, aermelLaenge, schnitt);
        this.ausschnittArt = ausschnittArt;
    }

    public TShirt(String[] StringAusJson) {
        super(StringAusJson);
        this.ausschnittArt = StringAusJson[9];
    }


    public String getAusschnittArt() {
        return ausschnittArt;
    }
}