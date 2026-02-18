package JSONHandling;

import KleidungsKlassen.*;

import java.util.ArrayList;

import static JSONHandling.JSONReaderHelper.*;

// Die Ganze JSON Read geschichte ist eingetlich daher verschulde das ich im abi und jetzt in der Ausbildung nur mit Datenbanken rumhantier und ich versuche quasi ein Join der JSON Datein manuel über Java ich weiß das ist nicht elgenat aber das kenne ich halt - Levin
public class JSONReaderKleidungstuecke {

    // Reader Klasse nimmt ids aus allen katehgorien um mit ein string array zu erzeugen der dann von den klassen eingelsen wird
    public static KleidungsContainer ReadKleidungsJSON() {
        ArrayList<Kleidungsstueck> kleidungsstueckeJSON = new ArrayList<>();

        ArrayList<Kopfbedeckung> kopfbedeckungeJSON = new ArrayList<>();
        ArrayList<Muetze> muetzeJSON = new ArrayList<>();
        ArrayList<Hut> hueteJSON = new ArrayList<>();
        ArrayList<Cap> capsJSON = new ArrayList<>();

        ArrayList<Unterteil> unterteileJSON = new ArrayList<>();
        ArrayList<Hose> hosenJSON = new ArrayList<>();
        ArrayList<Rock>  roeckeJSON = new ArrayList<>();

        ArrayList<Schuhe> schuheJSON = new ArrayList<>();
        ArrayList<HighHeels>  highheelsJSON = new ArrayList<>();
        ArrayList<Sneaker> sneakerJSON = new ArrayList<>();
        ArrayList<Stiefel> stiefelJSON = new ArrayList<>();
        ArrayList<Sandalen> sandalenJSON = new ArrayList<>();
        ArrayList<Halbschuhe> halbschuheJSON = new ArrayList<>();

        ArrayList<Oberteil> oberteileJSON = new ArrayList<>();
        ArrayList<Hemd> hemdJSON = new ArrayList<>();
        ArrayList<Polo> poloJSON = new ArrayList<>();
        ArrayList<Pullover> pulloverJSON = new ArrayList<>();
        ArrayList<Hoodie> hoodieJSON = new ArrayList<>();
        ArrayList<TShirt> tShirtJSON = new ArrayList<>();
        ArrayList<Top> topJSON = new ArrayList<>();

        ArrayList<Jacke> jackeJSON = new ArrayList<>();
        ArrayList<Mantel>  mantelJSON = new ArrayList<>();
        ArrayList<WinterJacke> winterjackeJSON = new ArrayList<>();
        ArrayList<RegenJacke> regenjackeJSON = new ArrayList<>();
        ArrayList<SweatshirtJacke> sweatshirtjackeJSON = new ArrayList<>();
        ArrayList<UebergangsJacke> uebergangsJackeJSON = new ArrayList<>();

        String[][] Kleidungsstuecke = LesenSafe("Kleidungsstueck");
        if (Kleidungsstuecke != null) {
            String[][] Kopfbedckungen = LesenSafe("Kopfbedeckung");
            if (Kopfbedckungen != null) {
                String[][] KopfbdeckungJoined = JSONjoin(Kopfbedckungen,0,Kleidungsstuecke,5);
                for (String[] string : Kopfbedckungen) {
                    kopfbedeckungeJSON.add(Kopfbedckungen(string));
                }
                for(String[] Inhalt : KlassenStringAusJSONStringListe("Muetze",KopfbdeckungJoined)){
                    muetzeJSON.add(Muetze(Inhalt));
                }
                for(String[] Inhalt : KlassenStringAusJSONStringListe("Huete",KopfbdeckungJoined)){
                    hueteJSON.add(Hut(Inhalt))
                }
                for(String[] Inhalt : KlassenStringAusJSONStringListe("Caps",KopfbdeckungJoined)){
                    capsJSON.add(Cap(Inhalt));
                }
            } else{
                kopfbedeckungeJSON = null;
                muetzeJSON = null;
                hueteJSON = null;
                capsJSON = null;
            }
            String[][] Unterteil = LesenSafe("Unterteil");
            if (Unterteil != null) {
                String[][] UnterteilJoined = JSONjoin(Unterteil,0,Kleidungsstuecke,5);
                for (String[] string : UnterteilJoined) {
                    unterteileJSON.add(Unterteil(string));
                }
                for(String[] Inhalt : KlassenStringAusJSONStringListe("Hosen",UnterteilJoined)) {
                    hosenJSON.add(Hose(Inhalt));
                }
                for(String[] Inhalt : KlassenStringAusJSONStringListe("Rocke",UnterteilJoined)) {
                    roeckeJSON.add(Rock(Inhalt));
                }
            }else{
                unterteileJSON = null;
                hosenJSON = null;
                roeckeJSON = null;
            }
            String[][] Schuhe = LesenSafe("Schuhe");
            if (Schuhe != null) {
                String[][] SchuheJoined = JSONjoin(Schuhe, 0, Kleidungsstuecke, 5);
                for (String[] string : SchuheJoined) {
                    schuheJSON.add(new Schuhe(string));
                }
                for (String[] Inhalt : KlassenStringAusJSONStringListe("HighHeels", SchuheJoined)) {
                    highheelsJSON.add(new HighHeels(Inhalt));
                }
                for (String[] Inhalt : KlassenStringAusJSONStringListe("Sneaker", SchuheJoined)) {
                    sneakerJSON.add(new Sneaker(Inhalt));
                }
                for (String[] Inhalt : KlassenStringAusJSONStringListe("Stiefel", SchuheJoined)) {
                    stiefelJSON.add(new Stiefel(Inhalt));
                }
                for (String[] Inhalt : KlassenStringAusJSONStringListe("Sandalen", SchuheJoined)) {
                    sandalenJSON.add(new Sandalen(Inhalt));
                }
                for (String[] Inhalt : KlassenStringAusJSONStringListe("Halbschuhe", SchuheJoined)) {
                    halbschuheJSON.add(new Halbschuhe(Inhalt));
                }
            }
            else{
                schuheJSON = null;
                highheelsJSON = null;
                sneakerJSON = null;
                stiefelJSON = null;
                sandalenJSON = null;
                halbschuheJSON = null;
            }
            String[][] Oberteile = LesenSafe("Oberteil");
            if (Oberteile != null) {
                String[][] OberteilJoined = JSONjoin(Oberteile, 0, Kleidungsstuecke, 5);
                for (String[] string : OberteilJoined) {
                    oberteileJSON.add(new Oberteil(string));
                }
                for (String[] Inhalt : KlassenStringAusJSONStringListe("Hemd", OberteilJoined)) {
                    hemdJSON.add(new Hemd(Inhalt));
                }
                for (String[] Inhalt : KlassenStringAusJSONStringListe("Polo", OberteilJoined)) {
                    poloJSON.add(new Polo(Inhalt));
                }
                for (String[] Inhalt : KlassenStringAusJSONStringListe("Pullover", OberteilJoined)) {
                    pulloverJSON.add(new Pullover(Inhalt));
                }
                for (String[] Inhalt : KlassenStringAusJSONStringListe("Hoodie", OberteilJoined)) {
                    hoodieJSON.add(new Hoodie(Inhalt));
                }
                for (String[] Inhalt : KlassenStringAusJSONStringListe("TShirt", OberteilJoined)) {
                    tShirtJSON.add(new TShirt(Inhalt));
                }
                for (String[] Inhalt : KlassenStringAusJSONStringListe("Top", OberteilJoined)) {
                    topJSON.add(new Top(Inhalt));
                }


                String[][] Jacke = LesenSafe("Jacke");
                if (Jacke != null) {
                    // Hier joinen wir Jacke mit dem bereits fertigen OberteilJoined
                    String[][] JackeJoined = JSONjoin(Jacke, 0, OberteilJoined, 5);
                    for (String[] string : JackeJoined) {
                        jackeJSON.add(new Jacke(string));
                    }
                    for (String[] Inhalt : KlassenStringAusJSONStringListe("Mantel", JackeJoined)) {
                        mantelJSON.add(new Mantel(Inhalt));
                    }
                    for (String[] Inhalt : KlassenStringAusJSONStringListe("WinterJacke", JackeJoined)) {
                        winterjackeJSON.add(new WinterJacke(Inhalt));
                    }
                    for (String[] Inhalt : KlassenStringAusJSONStringListe("RegenJacke", JackeJoined)) {
                        regenjackeJSON.add(new RegenJacke(Inhalt));
                    }
                    for (String[] Inhalt : KlassenStringAusJSONStringListe("SweatshirtJacke", JackeJoined)) {
                        sweatshirtjackeJSON.add(new SweatshirtJacke(Inhalt));
                    }
                    for (String[] Inhalt : KlassenStringAusJSONStringListe("UebergangsJacke", JackeJoined)) {
                        uebergangsJackeJSON.add(new UebergangsJacke(Inhalt));
                    }
                }else{
                    oberteileJSON = null;
                    hemdJSON = null;
                    poloJSON = null;
                    pulloverJSON = null;
                    hoodieJSON = null;
                    tShirtJSON = null;
                    topJSON = null;
                    jackeJSON = null;
                    mantelJSON = null;
                    winterjackeJSON = null;
                    regenjackeJSON = null;
                    sweatshirtjackeJSON = null;
                    uebergangsJackeJSON = null;
                }
            }else{
                jackeJSON = null;
                mantelJSON = null;
                winterjackeJSON = null;
                regenjackeJSON = null;
                sweatshirtjackeJSON = null;
                uebergangsJackeJSON = null;
            }
            return KleidungsContainer(kleidungsstueckeJSON,kopfbedeckungeJSON,muetzeJSON,hueteJSON,capsJSON,unterteileJSON,hosensJSON,roeckeJSON,schuheJSON,highheelsJSON,sneakerJSON,stiefelJSON,sandalenJSON,halbschuheJSON,oberteileJSON,hemdJSON,poloJSON,pulloverJSON,hoodieJSON,tShirtJSON,topJSON,jackeJSON,mantelJSON,winterjackeJSON,regenjackeJSON,sweatshirtjackeJSON,uebergangsJackeJSON);
        } else {
          return null;
        }
    }
}


