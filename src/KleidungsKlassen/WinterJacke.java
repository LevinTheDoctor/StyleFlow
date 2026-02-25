package KleidungsKlassen;

public class WinterJacke extends Jacke {

    public WinterJacke(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, int aermelLaenge, String schnitt, String verschlussArt, boolean istWasserdicht, String futterMaterial) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke, aermelLaenge, schnitt, verschlussArt, istWasserdicht, futterMaterial);
    }

    public WinterJacke(String[] StringAusJson) {
        super(StringAusJson);
    }
}