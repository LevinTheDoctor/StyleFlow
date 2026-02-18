package KleidungsKlassen;

public class WinterJacke extends Jacke {

    public WinterJacke(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, String verschlussArt, boolean istWasserdicht, String futterMaterial) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt, verschlussArt, istWasserdicht, futterMaterial);
    }

    public WinterJacke(String[] StringAusJson) {
        super(StringAusJson);
    }
}