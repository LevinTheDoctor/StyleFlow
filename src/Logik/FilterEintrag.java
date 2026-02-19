package Logik;

public class FilterEintrag {

    private String attributBezeichnung;
    private String attributWert;

    public FilterEintrag(String attributBezeichnung, String attributWert) {
        this.attributBezeichnung = attributBezeichnung;
        this.attributWert = attributWert;
    }


    public void setAttributBezeichnung(String attributBezeichnung) {
        this.attributBezeichnung = attributBezeichnung;
    }

    public void setAttributWert(String attributWert) {
        this.attributWert = attributWert;
    }


    public String getAttributBezeichnung() {
        return attributBezeichnung;
    }

    public String getAttributWert() {
        return attributWert;
    }
}