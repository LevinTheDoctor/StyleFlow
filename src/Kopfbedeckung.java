public class Kopfbedeckung extends Kleidungsstueck{
    private final Boolean HatSchirm;
    private final Boolean BedecktGesicht;

    public Kopfbedeckung(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, Boolean hatSchirm, Boolean bedecktGesicht) {
        super(name, farbe, groesse, material, marke, anlass, wetter);
        this.HatSchirm = hatSchirm;
        BedecktGesicht = bedecktGesicht;
    }

    public Boolean getHatSchirm() {
        return HatSchirm;
    }

    public Boolean getBedecktGesicht() {
        return BedecktGesicht;
    }
}
