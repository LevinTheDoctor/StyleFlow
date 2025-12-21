public class Oberteil extends  Kleidungsstueck{
    private final int AermelLaenge;
    private final String Schnitt;

    public Oberteil(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter,String BildDateiPfad, int aermelLaenge, String schnitt) {
        super(name, farbe, groesse, material, marke, anlass, wetter,BildDateiPfad);
        this.AermelLaenge = aermelLaenge;
        this.Schnitt = schnitt;
    }

    public int getAermelLaenge() {
        return AermelLaenge;
    }

    public String getSchnitt() {
        return Schnitt;
    }
}
