package KleidungsKlassen;

public class Mantel extends Jacke {

    public Mantel(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, String verschlussArt, boolean istWasserdicht, String futterMaterial) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt, verschlussArt, istWasserdicht, futterMaterial);
    }

    public Mantel(String[] StringAusJson) {
        super(StringAusJson);
    }
}