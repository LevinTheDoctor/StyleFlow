public class Sweatshirt extends Oberteil{
    private final boolean hatKaputze;
    private final boolean hatTasche;

    public Sweatshirt(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int aermelLaenge, String schnitt, boolean hatKaputze, boolean hatTasche) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, aermelLaenge, schnitt);
        this.hatKaputze = hatKaputze;
        this.hatTasche = hatTasche;
    }

    public boolean isHatKaputze() {
        return hatKaputze;
    }

    public boolean isHatTasche() {
        return hatTasche;
    }
}
