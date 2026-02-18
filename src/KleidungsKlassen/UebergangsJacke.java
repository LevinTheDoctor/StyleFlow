package KleidungsKlassen;

public class UebergangsJacke extends Jacke {

    public UebergangsJacke(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, String verschlussArt, boolean istWasserdicht, String futterMaterial) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt, verschlussArt, istWasserdicht, futterMaterial);
    }

    public UebergangsJacke(String[] StringAusJson) {
        super(StringAusJson);
    }
}