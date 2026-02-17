package KleidungsKlassen;

public class Kleid extends Einteiler {
    
    public Kleid(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String ausschnittArt, String weite, int laenge, boolean hatAermel) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, ausschnittArt, weite, laenge, hatAermel);
    }

    public Kleid(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, String ausschnittArt, String weite, int laenge, boolean hatAermel) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, ausschnittArt, weite, laenge, hatAermel);
    }
}