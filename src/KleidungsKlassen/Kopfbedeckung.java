package KleidungsKlassen;

public abstract class Kopfbedeckung extends Kleidungsstueck {

    public Kopfbedeckung(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad);
    }

    public Kopfbedeckung(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID);
    }
}