package Wetter;

public class Wetter {
    private String WetterLage; // Sonne, Regen, Schnee, Windig
    private Double TempraturInGrad;
    private String WetterSituation;

    public Wetter(String wetterLage,  Double tempraturInGrad) {
        WetterLage = wetterLage;
        TempraturInGrad = tempraturInGrad;
        WetterSituation = bestimmeWetterSituation(tempraturInGrad, wetterLage);

    }

    private String bestimmeWetterSituation(double tempraturInGrad,String WetterLage) {
        String TemperaturInString;
        if (TempraturInGrad < 0)
        {
            TemperaturInString = "Eisig";
        }
        else if (TempraturInGrad < 15)
        {
            TemperaturInString = "Kalt";
        }
        else if (TempraturInGrad < 25)
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
