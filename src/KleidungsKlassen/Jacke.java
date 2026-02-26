package KleidungsKlassen;

public abstract class Jacke extends Oberteil {
    private final String verschlussArt;
    private final boolean istWasserdicht;
    private String futterMaterial;

    public Jacke(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String marke,int aermelLaenge, String schnitt, String verschlussArt, boolean istWasserdicht, String futterMaterial) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, marke,aermelLaenge, schnitt);
        this.verschlussArt = verschlussArt;
        this.istWasserdicht = istWasserdicht;
        this.futterMaterial = futterMaterial;
    }

    public Jacke(String[] StringAusJson) {
        super(StringAusJson);
        this.verschlussArt = StringAusJson[9];
        this.istWasserdicht = Boolean.parseBoolean(StringAusJson[10]);
        this.futterMaterial = StringAusJson[11];
    }


    public void setFutterMaterial(String futterMaterial) {
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