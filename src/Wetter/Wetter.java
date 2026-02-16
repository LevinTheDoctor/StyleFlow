package Wetter;

public class Wetter {
    private String WetterLage; // Sonne, Regen, Schnne, Windig
    private Double TempraturInGrad;
    private String WetterSituation;

    public Wetter(String wetterPhaenomen, Double wind, Double tempraturInGrad) {
        WetterLage = wetterPhaenomen;
        TempraturInGrad = tempraturInGrad;
    }

    public String getWetterLage() {
        return WetterLage;
    }

    public void setWetterLage(String wetterLage) {
        WetterLage = wetterLage;
    }

    public Double getTempraturInGrad() {
        return TempraturInGrad;
    }

    public void setTempraturInGrad(Double tempraturInGrad) {
        TempraturInGrad = tempraturInGrad;
    }

    public String getWetterSituation() {
        return WetterSituation;
    }

    public void setWetterSituation(String wetterSituation) {
        WetterSituation = wetterSituation;
    }
}
