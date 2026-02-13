import java.util.ArrayList;
public class Nutzer {
    private String nutzername;
    private String pfadZumBild;
    private ArrayList<String> LeiblingsFarbe;
    private String Standort;

    public Nutzer(String pfadZumBild, String nutzername) {
        this.pfadZumBild = pfadZumBild;
        this.nutzername = nutzername;
    }

    public void setNutzername(String nutzername) {
        this.nutzername = nutzername;
    }

    public String getPfadZumBild() {
        return pfadZumBild;
    }

    public void setPfadZumBild(String pfadZumBild) {
        this.pfadZumBild = pfadZumBild;
    }

    public ArrayList<String> getLeiblingsFarbe() {
        return LeiblingsFarbe;
    }

    public void setLeiblingsFarbe(ArrayList<String> leiblingsFarbe) {
        LeiblingsFarbe = leiblingsFarbe;
    }

    public String getStandort() {
        return Standort;
    }

    public void setStandort(String standort) {
        Standort = standort;
    }
}
