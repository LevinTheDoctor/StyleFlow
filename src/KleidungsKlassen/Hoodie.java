package KleidungsKlassen;

public class Hoodie extends Oberteil {
    private final boolean hatTasche;

    public Hoodie(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, int aermelLaenge, String schnitt, boolean hatTasche) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, marke,aermelLaenge, schnitt);
        this.hatTasche = hatTasche;
    }

    public Hoodie(String[] StringAusJson) {
        super(StringAusJson);
        this.hatTasche = Boolean.parseBoolean(StringAusJson[8]);
    }


    public boolean isHatTasche() {
        return hatTasche;
    }
}