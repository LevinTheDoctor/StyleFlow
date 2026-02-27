package Wetter;

public class Wetter {
    private String WetterLage; // Sonne, Regen, Schnee, Windig
    private Double TemperaturInGrad;
    private String WetterSituation;

    public Wetter(String wetterLage,  Double temperaturInGrad) {
        WetterLage = wetterLage;
        TemperaturInGrad = temperaturInGrad;
        WetterSituation = bestimmeWetterSituation(temperaturInGrad, wetterLage);

    }

    private String bestimmeWetterSituation(double temperaturInGrad,String WetterLage) {
        String TemperaturInString;
        if (TemperaturInGrad < 0)
        {
            TemperaturInString = "Eisig";
        }
        else if (TemperaturInGrad < 15)
        {
            TemperaturInString = "Kalt";
        }
        else if (TemperaturInGrad < 25)
        {
            TemperaturInString = "Mild";
        }else{
            TemperaturInString = "Heiss";
        }
        String WetterSituationBerechnung = TemperaturInString + "er "+ WetterLage;
        return WetterSituationBerechnung;
    }

    public String getWetterLage() {
        return WetterLage;
    }

    public void setWetterLage(String wetterLage) {
        WetterLage = wetterLage;
    }

    public Double getTemperaturInGrad() {
        return TemperaturInGrad;
    }

    public void setTemperaturInGrad(Double temperaturInGrad) {
        TemperaturInGrad = temperaturInGrad;
    }

    public String getWetterSituation() {
        return WetterSituation;
    }

    public void setWetterSituation(String wetterSituation) {
        WetterSituation = wetterSituation;
    }
}
