package Wetter;

public class Wetter {
    private String WetterPhaenomen;
    private Double Wind;
    private Double TempraturInGrad;

    public Wetter(String wetterPhaenomen, Double wind, Double tempraturInGrad) {
        WetterPhaenomen = wetterPhaenomen;
        Wind = wind;
        TempraturInGrad = tempraturInGrad;
    }

    public String getWetterPhaenomen() {
        return WetterPhaenomen;
    }

    public void setWetterPhaenomen(String wetterPhaenomen) {
        WetterPhaenomen = wetterPhaenomen;
    }

    public Double getWind() {
        return Wind;
    }

    public void setWind(Double wind) {
        Wind = wind;
    }

    public Double getTempraturInGrad() {
        return TempraturInGrad;
    }

    public void setTempraturInGrad(Double tempraturInGrad) {
        TempraturInGrad = tempraturInGrad;
    }
}
