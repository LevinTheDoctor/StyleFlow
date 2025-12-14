public class Schuhe extends Kleidungsstueck{
    private String SolenMaterial;
    private String VerschlussTyp;
    public Schuhe(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String solenMaterial, String verschlussTyp) {
        super(name, farbe, groesse, material, marke, anlass, wetter);
        SolenMaterial = solenMaterial;
        VerschlussTyp = verschlussTyp;
    }

    public String getSolenMaterial() {
        return SolenMaterial;
    }

    public String getVerschlussTyp() {
        return VerschlussTyp;
    }
}
