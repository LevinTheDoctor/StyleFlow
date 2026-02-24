package JSONHandling;

import KleidungsKlassen.*;

import java.util.ArrayList;

import static JSONHandling.JSONReaderHelper.*;

// Die ganze JSON-Read-Geschichte ist eigentlich daher verschuldet, dass ich im Abi und jetzt in der Ausbildung nur mit Datenbanken rumhantiere und ich versuche quasi einen Join der JSON-Dateien manuell über Java – ich weiß, das ist nicht elegant, aber das kenne ich halt – Levin
public class JSONReaderKleidungstuecke {

    // Reader-Klasse nimmt IDs aus allen Kategorien, um ein String-Array zu erzeugen, der dann von den Klassen eingelesen wird
    public static KleidungsContainer ReadKleidungsJSON() {
        ArrayList<Kleidungsstueck> kleidungsstueckeJSON = new ArrayList<>();

        ArrayList<Kopfbedeckung> kopfbedeckungeJSON = new ArrayList<>();
        ArrayList<Muetze> muetzeJSON = new ArrayList<>();
        ArrayList<Hut> hueteJSON = new ArrayList<>();
        ArrayList<Cap> capsJSON = new ArrayList<>();

        ArrayList<Unterteil> unterteileJSON = new ArrayList<>();
        ArrayList<Hose> hosenJSON = new ArrayList<>();
        ArrayList<Rock>  roeckeJSON = new ArrayList<>();

        ArrayList<Einteiler> einteilerJSON = new ArrayList<>();
        ArrayList<Kleid>  kleiderJSON = new ArrayList<>();
        ArrayList<Overall> overallJSON = new ArrayList<>();

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

                String[][] muetzeInhalt = KlassenStringAusJSONStringListe("Muetze", KopfbdeckungJoined);
                if (muetzeInhalt != null) {
                    for(String[] Inhalt : muetzeInhalt) {
                        muetzeJSON.add(new Muetze(Inhalt));
                    }
                }

                String[][] hueteInhalt = KlassenStringAusJSONStringListe("Huete", KopfbdeckungJoined);
                if (hueteInhalt != null) {
                    for(String[] Inhalt : hueteInhalt) {
                        hueteJSON.add(new Hut(Inhalt));
                    }
                }

                String[][] capsInhalt = KlassenStringAusJSONStringListe("Cap", KopfbdeckungJoined);
                if (capsInhalt != null) {
                    for(String[] Inhalt : capsInhalt) {
                        capsJSON.add(new Cap(Inhalt));
                    }
                }

                kopfbedeckungeJSON.addAll(muetzeJSON);
                kopfbedeckungeJSON.addAll(hueteJSON);
                kopfbedeckungeJSON.addAll(capsJSON);
            } else{
                kopfbedeckungeJSON = null;
                muetzeJSON = null;
                hueteJSON = null;
                capsJSON = null;
            }

            String[][] Unterteil = LesenSafe("Unterteil");
            if (Unterteil != null) {
                String[][] UnterteilJoined = JSONjoin(Unterteil,0,Kleidungsstuecke,5);

                String[][] hosenInhalt = KlassenStringAusJSONStringListe("Hose", UnterteilJoined);
                if (hosenInhalt != null) {
                    for(String[] Inhalt : hosenInhalt) {
                        hosenJSON.add(new Hose(Inhalt));
                    }
                }

                String[][] roeckeInhalt = KlassenStringAusJSONStringListe("Rocke", UnterteilJoined);
                if (roeckeInhalt != null) {
                    for(String[] Inhalt : roeckeInhalt) {
                        roeckeJSON.add(new Rock(Inhalt));
                    }
                }

                unterteileJSON.addAll(hosenJSON);
                unterteileJSON.addAll(roeckeJSON);
            }else{
                unterteileJSON = null;
                hosenJSON = null;
                roeckeJSON = null;
            }

            String[][] Einteiler = LesenSafe("Einteiler");
            if (Einteiler != null) {
                String[][] EinteilerJoined = JSONjoin(Einteiler,0,Kleidungsstuecke,5);

                String[][] kleiderInhalt = KlassenStringAusJSONStringListe("Kleid", EinteilerJoined);
                if (kleiderInhalt != null) {
                    for (String[] Inhalt : kleiderInhalt) {
                        kleiderJSON.add(new Kleid(Inhalt));
                    }
                }

                String[][] overallInhalt = KlassenStringAusJSONStringListe("Overall", EinteilerJoined);
                if (overallInhalt != null) {
                    for (String[] Inhalt : overallInhalt) {
                        overallJSON.add(new Overall(Inhalt));
                    }
                }

                einteilerJSON.addAll(kleiderJSON);
                einteilerJSON.addAll(overallJSON);
            } else {
                einteilerJSON = null;
                kleiderJSON = null;
                overallJSON = null;
            }

            String[][] Schuhe = LesenSafe("Schuhe");
            if (Schuhe != null) {
                String[][] SchuheJoined = JSONjoin(Schuhe, 0, Kleidungsstuecke, 5);

                String[][] highheelsInhalt = KlassenStringAusJSONStringListe("HighHeels", SchuheJoined);
                if (highheelsInhalt != null) {
                    for (String[] Inhalt : highheelsInhalt) {
                        highheelsJSON.add(new HighHeels(Inhalt));
                    }
                }

                String[][] sneakerInhalt = KlassenStringAusJSONStringListe("Sneaker", SchuheJoined);
                if (sneakerInhalt != null) {
                    for (String[] Inhalt : sneakerInhalt) {
                        sneakerJSON.add(new Sneaker(Inhalt));
                    }
                }

                String[][] stiefelInhalt = KlassenStringAusJSONStringListe("Stiefel", SchuheJoined);
                if (stiefelInhalt != null) {
                    for (String[] Inhalt : stiefelInhalt) {
                        stiefelJSON.add(new Stiefel(Inhalt));
                    }
                }

                String[][] sandalenInhalt = KlassenStringAusJSONStringListe("Sandalen", SchuheJoined);
                if (sandalenInhalt != null) {
                    for (String[] Inhalt : sandalenInhalt) {
                        sandalenJSON.add(new Sandalen(Inhalt));
                    }
                }

                String[][] halbschuheInhalt = KlassenStringAusJSONStringListe("Halbschuhe", SchuheJoined);
                if (halbschuheInhalt != null) {
                    for (String[] Inhalt : halbschuheInhalt) {
                        halbschuheJSON.add(new Halbschuhe(Inhalt));
                    }
                }

                schuheJSON.addAll(highheelsJSON);
                schuheJSON.addAll(sneakerJSON);
                schuheJSON.addAll(stiefelJSON);
                schuheJSON.addAll(sandalenJSON);
                schuheJSON.addAll(halbschuheJSON);
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

                String[][] hemdInhalt = KlassenStringAusJSONStringListe("Hemd", OberteilJoined);
                if (hemdInhalt != null) {
                    for (String[] Inhalt : hemdInhalt) {
                        hemdJSON.add(new Hemd(Inhalt));
                    }
                }

                String[][] poloInhalt = KlassenStringAusJSONStringListe("Polo", OberteilJoined);
                if (poloInhalt != null) {
                    for (String[] Inhalt : poloInhalt) {
                        poloJSON.add(new Polo(Inhalt));
                    }
                }

                String[][] pulloverInhalt = KlassenStringAusJSONStringListe("Pullover", OberteilJoined);
                if (pulloverInhalt != null) {
                    for (String[] Inhalt : pulloverInhalt) {
                        pulloverJSON.add(new Pullover(Inhalt));
                    }
                }

                String[][] hoodieInhalt = KlassenStringAusJSONStringListe("Hoodie", OberteilJoined);
                if (hoodieInhalt != null) {
                    for (String[] Inhalt : hoodieInhalt) {
                        hoodieJSON.add(new Hoodie(Inhalt));
                    }
                }

                String[][] tshirtInhalt = KlassenStringAusJSONStringListe("TShirt", OberteilJoined);
                if (tshirtInhalt != null) {
                    for (String[] Inhalt : tshirtInhalt) {
                        tShirtJSON.add(new TShirt(Inhalt));
                    }
                }

                String[][] topInhalt = KlassenStringAusJSONStringListe("Top", OberteilJoined);
                if (topInhalt != null) {
                    for (String[] Inhalt : topInhalt) {
                        topJSON.add(new Top(Inhalt));
                    }
                }

                String[][] Jacke = LesenSafe("Jacke");
                if (Jacke != null) {
                    String[][] JackeJoined = JSONjoin(Jacke, 0, OberteilJoined, 5);

                    String[][] mantelInhalt = KlassenStringAusJSONStringListe("Mantel", JackeJoined);
                    if (mantelInhalt != null) {
                        for (String[] Inhalt : mantelInhalt) {
                            mantelJSON.add(new Mantel(Inhalt));
                        }
                    }

                    String[][] winterjackeInhalt = KlassenStringAusJSONStringListe("WinterJacke", JackeJoined);
                    if (winterjackeInhalt != null) {
                        for (String[] Inhalt : winterjackeInhalt) {
                            winterjackeJSON.add(new WinterJacke(Inhalt));
                        }
                    }

                    String[][] regenjackeInhalt = KlassenStringAusJSONStringListe("RegenJacke", JackeJoined);
                    if (regenjackeInhalt != null) {
                        for (String[] Inhalt : regenjackeInhalt) {
                            regenjackeJSON.add(new RegenJacke(Inhalt));
                        }
                    }

                    String[][] sweatshirtjackeInhalt = KlassenStringAusJSONStringListe("SweatshirtJacke", JackeJoined);
                    if (sweatshirtjackeInhalt != null) {
                        for (String[] Inhalt : sweatshirtjackeInhalt) {
                            sweatshirtjackeJSON.add(new SweatshirtJacke(Inhalt));
                        }
                    }

                    String[][] uebergangsJackeInhalt = KlassenStringAusJSONStringListe("UebergangsJacke", JackeJoined);
                    if (uebergangsJackeInhalt != null) {
                        for (String[] Inhalt : uebergangsJackeInhalt) {
                            uebergangsJackeJSON.add(new UebergangsJacke(Inhalt));
                        }
                    }

                    jackeJSON.addAll(mantelJSON);
                    jackeJSON.addAll(winterjackeJSON);
                    jackeJSON.addAll(regenjackeJSON);
                    jackeJSON.addAll(sweatshirtjackeJSON);
                    jackeJSON.addAll(uebergangsJackeJSON);
                    oberteileJSON.addAll(jackeJSON);
                }else{
                    jackeJSON = null;
                    mantelJSON = null;
                    winterjackeJSON = null;
                    regenjackeJSON = null;
                    sweatshirtjackeJSON = null;
                    uebergangsJackeJSON = null;
                }

                oberteileJSON.addAll(hemdJSON);
                oberteileJSON.addAll(poloJSON);
                oberteileJSON.addAll(pulloverJSON);
                oberteileJSON.addAll(hoodieJSON);
                oberteileJSON.addAll(tShirtJSON);
                oberteileJSON.addAll(topJSON);
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
            return new KleidungsContainer(
                    kleidungsstueckeJSON, kopfbedeckungeJSON, muetzeJSON, hueteJSON, capsJSON,
                    unterteileJSON, hosenJSON, roeckeJSON,einteilerJSON,kleiderJSON,overallJSON,
                    schuheJSON, highheelsJSON, sneakerJSON, stiefelJSON, sandalenJSON, halbschuheJSON,
                    oberteileJSON, hemdJSON, poloJSON, pulloverJSON, hoodieJSON, tShirtJSON, topJSON,
                    jackeJSON, mantelJSON, winterjackeJSON, regenjackeJSON, sweatshirtjackeJSON, uebergangsJackeJSON
            );
        } else {
            return null;
        }
    }
}