package KleidungsKlassen;

public class HighHeels extends Schuhe {
    private final boolean istOffen;

    public HighHeels(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String absatzHoehe, String verschlussArt, boolean istOffen) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, absatzHoehe, verschlussArt);
        this.istOffen = istOffen;
    }

    public HighHeels(String[] StringAusJson) {
        super(StringAusJson);
        this.istOffen = Boolean.parseBoolean(StringAusJson[8]);
    }


    public boolean isIstOffen() {
        return istOffen;
    }
}