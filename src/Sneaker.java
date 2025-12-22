public class Sneaker extends Schuhe
{
    private final boolean Colaboration;
    private final String Technologie;

    public Sneaker(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, String solenMaterial, String verschlussTyp, boolean colaboration, String technologie) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, solenMaterial, verschlussTyp);
        Colaboration = colaboration;
        Technologie = technologie;
    }

    public boolean isColaboration() {
        return Colaboration;
    }

    public String getTechnologie() {
        return Technologie;
    }
}
