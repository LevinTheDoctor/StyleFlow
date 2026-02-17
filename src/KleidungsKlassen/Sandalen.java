package KleidungsKlassen;

public class Sandalen extends Schuhe {
    private final boolean istOffen;
    private final int almanFaktor;

    public Sandalen(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String absatzHoehe, String verschlussArt, boolean istOffen, int almanFaktor) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, absatzHoehe, verschlussArt);
        this.istOffen = istOffen;
        this.almanFaktor = almanFaktor;
    }

    public Sandalen(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, String absatzHoehe, String verschlussArt, boolean istOffen, int almanFaktor) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, absatzHoehe, verschlussArt);
        this.istOffen = istOffen;
        this.almanFaktor = almanFaktor;
    }

    public boolean isistOffen() {
        return istOffen;
    }

    public int getAlmanFaktor() {
        return almanFaktor;
    }
}