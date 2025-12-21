public abstract class Kleidungsstueck {
    private final String Name;
    private final String[] Farbe;
    private final String Groesse;
    private final String[] Material;
    private final String Marke;
    private final String Anlass;
    private final String Wetter;
    private String BildDateiPfad;


    public Kleidungsstueck(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter) {
        Name = name;
        Farbe = farbe;
        Groesse = groesse;
        Material = material;
        Marke = marke;
        Anlass = anlass;
        Wetter = wetter;
    }

    public String getName() {
        return Name;
    }

    public String[] getFarbe() {
        return Farbe;
    }
    public String getGroesse() {
        return Groesse;
    }

    public String[] getMaterial() {
        return Material;
    }

    public String getMarke() {
        return Marke;
    }

    public String getAnlass() {
        return Anlass;
    }

    public String getWetter() {
        return Wetter;
    }

    public String getBildDateiPfad() {
        return BildDateiPfad;
    }
}

