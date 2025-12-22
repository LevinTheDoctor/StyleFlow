public abstract class Schuhe extends Kleidungsstueck{
    private final String SolenMaterial;
    private final String VerschlussTyp;
    public Schuhe(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter,String BildDateiPfad,String solenMaterial, String verschlussTyp) {
        super(name, farbe, groesse, material, marke, anlass, wetter,BildDateiPfad);
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
