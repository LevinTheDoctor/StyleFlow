package KleidungsKlassen;

public class Anzug extends Einteiler
{
    public Anzug(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String ausschnittArt, String weite, int laenge, boolean hatAermel) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, ausschnittArt, weite, laenge, hatAermel);
    }

    public Anzug(String[] StringAusJson) {
        super(StringAusJson);
    }
}