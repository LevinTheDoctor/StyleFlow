package KleidungsKlassen;

public class RegenJacke extends Jacke {

	public RegenJacke(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, int aermelLaenge, String schnitt, String verschlussArt, String futterMaterial) {
	    super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, marke,aermelLaenge, schnitt, verschlussArt, true, futterMaterial);
	}

    public RegenJacke(String[] StringAusJson) {
        super(StringAusJson);
    }
}