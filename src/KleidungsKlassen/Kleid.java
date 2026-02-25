package KleidungsKlassen;

public class Kleid extends Einteiler {

    public Kleid(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, String ausschnittArt, String weite, int laenge, boolean hatAermel) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke, ausschnittArt, weite, laenge, hatAermel);
    }

    public Kleid(String[] StringAusJson) {
        super(StringAusJson);
    }
}