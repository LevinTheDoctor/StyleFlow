package KleidungsKlassen;

public class Top extends Oberteil {
    private final String ausschnittArt;
    private final String traegerArt;

    public Top(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, String ausschnittArt, String traegerArt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt);
        this.ausschnittArt = ausschnittArt;
        this.traegerArt = traegerArt;
    }

    public Top(String[] StringAusJson) {
        super(StringAusJson);
        this.ausschnittArt = StringAusJson[8];
        this.traegerArt = StringAusJson[9];
    }


    public String getAusschnittArt() {
        return ausschnittArt;
    }

    public String getTraegerArt() {
        return traegerArt;
    }
}