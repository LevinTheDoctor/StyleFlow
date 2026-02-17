package KleidungsKlassen;

public abstract class Jacke extends Oberteil {
    private final String verschlussArt;
    private final boolean istWasserdicht;
    private final String futterMaterial;

    public Jacke(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, String verschlussArt, boolean istWasserdicht, String futterMaterial) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt);
        this.verschlussArt = verschlussArt;
        this.istWasserdicht = istWasserdicht;
        this.futterMaterial = futterMaterial;
    }

    public Jacke(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, int aermelLaenge, String schnitt, String verschlussArt, boolean istWasserdicht, String futterMaterial) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, aermelLaenge, schnitt);
        this.verschlussArt = verschlussArt;
        this.istWasserdicht = istWasserdicht;
        this.futterMaterial = futterMaterial;
    }

    public String getVerschlussArt() {
        return verschlussArt;
    }

    public boolean isIstWasserdicht() {
        return istWasserdicht;
    }

    public String getFutterMaterial() {
        return futterMaterial;
    }
}