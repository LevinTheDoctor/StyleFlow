package KleidungsKlassen;

public class Top extends Oberteil {
    private final String ausschnittArt;
    private final String traegerArt;

    public Top(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, int aermelLaenge, String schnitt, String ausschnittArt, String traegerArt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke, aermelLaenge, schnitt);
        this.ausschnittArt = ausschnittArt;
        this.traegerArt = traegerArt;
    }

    public Top(String[] StringAusJson) {
        super(StringAusJson);
        this.ausschnittArt = StringAusJson[9];
        this.traegerArt = StringAusJson[10];
    }


    public String getAusschnittArt() {
        return ausschnittArt;
    }

    public String getTraegerArt() {
        return traegerArt;
    }
}