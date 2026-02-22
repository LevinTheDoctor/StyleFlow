package GUI.Controller;

public class BasisVorauswahl {

    private final String bezeichnung;
    private final String bedecktesKoerperteil;
    private final String wetterLage;
    private final String bildPfad;
    private final String marke;
    private final String anmerkung;
    private final String[] farben;
    private final String[] material;
    private final String[] style;

    public BasisVorauswahl(String bezeichnung, String bedecktesKoerperteil,
                           String wetterLage, String bildPfad,
                           String marke, String anmerkung,
                           String[] farben, String[] material, String[] style) {
        this.bezeichnung          = bezeichnung;
        this.bedecktesKoerperteil = bedecktesKoerperteil;
        this.wetterLage           = wetterLage;
        this.bildPfad             = bildPfad;
        this.marke                = marke;
        this.anmerkung            = anmerkung;
        this.farben               = farben;
        this.material             = material;
        this.style                = style;
    }

    public String   getBezeichnung()          { return bezeichnung; }
    public String   getBedecktesKoerperteil() { return bedecktesKoerperteil; }
    public String   getWetterLage()           { return wetterLage; }
    public String   getBildPfad()             { return bildPfad; }
    public String   getMarke()                { return marke; }
    public String   getAnmerkung()            { return anmerkung; }
    public String[] getFarben()               { return farben; }
    public String[] getMaterial()             { return material; }
    public String[] getStyle()                { return style; }
}
