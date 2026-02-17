package KleidungsKlassen;

public class Hoodie extends Oberteil {
    private boolean hatTasche;

    public Hoodie(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, boolean hatTasche) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt);
        this.hatTasche = hatTasche;
    }

    public Hoodie(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, int aermelLaenge, String schnitt, boolean hatTasche) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, aermelLaenge, schnitt);
        this.hatTasche = hatTasche;
    }

    public boolean isHatTasche() {
        return hatTasche;
    }

    public void setHatTasche(boolean hatTasche) {
        this.hatTasche = hatTasche;
    }
}