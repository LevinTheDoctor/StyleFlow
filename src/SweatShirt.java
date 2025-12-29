public class SweatShirt extends Oberteil{
    private final boolean hatKaputze;
    private final boolean hatTasche;

    public SweatShirt(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int aermelLaenge, String schnitt, boolean hatKaputze, boolean hatTasche) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, aermelLaenge, schnitt);
        this.hatKaputze = hatKaputze;
        this.hatTasche = hatTasche;
    }

    public SweatShirt(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String bildDateiPfad, int kleidungsID, int aermelLaenge, String schnitt, boolean hatKaputze, boolean hatTasche) {
        super(name, farbe, groesse, material, marke, anlass, wetter, bildDateiPfad, kleidungsID, aermelLaenge, schnitt);
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
