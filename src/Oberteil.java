public class Oberteil extends Kleidungsstueck{
    private final Boolean hatSchirm;
    private final Boolean BedecktGesicht;

    public Oberteil(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, Boolean hatSchirm, Boolean bedecktGesicht) {
        super(name, farbe, groesse, material, marke, anlass, wetter);
        this.hatSchirm = hatSchirm;
        BedecktGesicht = bedecktGesicht;
    }

    public Boolean getHatSchirm() {
        return hatSchirm;
    }

    public Boolean getBedecktGesicht() {
        return BedecktGesicht;
    }
}
