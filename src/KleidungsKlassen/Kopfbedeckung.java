package KleidungsKlassen;

public abstract class Kopfbedeckung extends Kleidungsstueck {

    public Kopfbedeckung(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke);
    }

    public Kopfbedeckung(String[] StringAusJson) {
        super(StringAusJson);
    }
}