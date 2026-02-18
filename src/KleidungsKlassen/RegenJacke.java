package KleidungsKlassen;

public class RegenJacke extends Jacke {

	public RegenJacke(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, String verschlussArt, String futterMaterial) {
	    super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt, verschlussArt, true, futterMaterial);
	}

    public RegenJacke(String[] StringAusJson) {
        super(StringAusJson);
    }
}