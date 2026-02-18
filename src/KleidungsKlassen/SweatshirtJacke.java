package KleidungsKlassen;

public class SweatshirtJacke extends Jacke {

    public SweatshirtJacke(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, String verschlussArt, boolean istWasserdicht, String futterMaterial) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt, verschlussArt, istWasserdicht, futterMaterial);
    }

    public SweatshirtJacke(String[] StringAusJson) {
        super(StringAusJson);
    }
}