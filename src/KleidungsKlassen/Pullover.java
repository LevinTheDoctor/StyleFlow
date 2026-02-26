package KleidungsKlassen;

public class Pullover extends Oberteil {
    private final String ausschnittArt;
    private final String strickArt;

    public Pullover(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, int aermelLaenge, String schnitt, String ausschnittArt, String strickArt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke, aermelLaenge, schnitt);
        this.ausschnittArt = ausschnittArt;
        this.strickArt = strickArt;
    }

    public Pullover(String[] StringAusJson) {
        super(StringAusJson);
        this.ausschnittArt = StringAusJson[9];
        this.strickArt = StringAusJson[10];
    }


    public String getAusschnittArt() {
        return ausschnittArt;
    }

    public String getStrickArt() {
        return strickArt;
    }
}