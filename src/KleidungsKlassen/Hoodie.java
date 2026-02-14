package KleidungsKlassen;

public class Hoodie extends Oberteil
{
    private boolean HatTasche;

    public Hoodie(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int aermelLaenge, String schnitt, boolean hatTasche) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, aermelLaenge, schnitt);
        HatTasche = hatTasche;
    }

    public Hoodie(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String bildDateiPfad, int kleidungsID, int aermelLaenge, String schnitt, boolean hatTasche) {
        super(name, farbe, groesse, material, marke, anlass, wetter, bildDateiPfad, kleidungsID, aermelLaenge, schnitt);
        HatTasche = hatTasche;
    }

    public boolean isHatTasche() {
        return HatTasche;
    }

    public void setHatTasche(boolean hatTasche) {
        HatTasche = hatTasche;
    }
}
