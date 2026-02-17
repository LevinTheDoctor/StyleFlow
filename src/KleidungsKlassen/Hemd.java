package KleidungsKlassen;

public class Hemd extends Oberteil {
    private final String kragenArt;
    private final boolean hatMuster;

    public Hemd(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, String kragenArt, boolean hatMuster) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt);
        this.kragenArt = kragenArt;
        this.hatMuster = hatMuster;
    }

    public Hemd(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, int aermelLaenge, String schnitt, String kragenArt, boolean hatMuster) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, aermelLaenge, schnitt);
        this.kragenArt = kragenArt;
        this.hatMuster = hatMuster;
    }

    public String getKragenArt() {
        return kragenArt;
    }

    public boolean isHatMuster() {
        return hatMuster;
    }
}