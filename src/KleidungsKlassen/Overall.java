package KleidungsKlassen;

public class Overall extends Einteiler {

    public Overall(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, String ausschnittArt, String weite, int laenge, boolean hatAermel) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, marke,ausschnittArt, weite, laenge, hatAermel);
    }

    public Overall(String[] StringAusJson) {
        super(StringAusJson);
    }
}