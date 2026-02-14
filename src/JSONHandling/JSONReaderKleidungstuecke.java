package JSONHandling;

import KleidungsKlassen.*;
import static JSONHandling.JSONReaderHelper.*;

// Die Ganze JSON Read geschichte ist eingetlich daher verschulde das ich im abi und jetzt in der Ausbildung nur mit Datenbanken rumhantier und ich versuche quasi ein Join der JSON Datein manuel über Java ich weiß das ist nicht elgenat aber das kenne ich halt - Levin
public class JSONReaderKleidungstuecke {


    // Reader Klasse nimmt ids aus allen katehgorien um mit ein string array zu erzeugen der dann von den klassen eingelsen wird
    public void KleidungStartReader(){
        if (LesenMoeglich("Kleidungsstuecke"))
        {
            String[][] KleidungstueckeWerte = JSONzu2Darray("Kleidungsstuecke",11);
            // Oberteile und Unterklassen
            // Die Oberklasse MUSS Existiren daher wird nur darin geschekt ob die Datei der Unterklasse Existirt sonst könnte es zu Fehlerhaften Daten kommen
            if (LesenMoeglich("Oberteile"))
            {
                String[][] OberteileWerte = JSONjoin(JSONzu2Darray("Oberteile",5),0,KleidungstueckeWerte,8);
                if (LesenMoeglich("Hemd"))
                {
                    String[][] HemdWerte = JSONjoin(JSONzu2Darray("Hemd",5),0,OberteileWerte,8);
                    for (String[] Werte : HemdWerte){
                        Hemd hemd = new Hemd(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Integer.parseInt(Werte[9]),Werte[10],Werte[11],Werte[12]);
                    }
                }
                if (LesenMoeglich("Pullover"))
                {
                    String[][] PulloverWerte = JSONjoin(JSONzu2Darray("Pullover",6),0,OberteileWerte,8);
                    for (String[] Werte : PulloverWerte){
                        Pullover pullover = new Pullover(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Integer.parseInt(Werte[9]),Werte[10],Werte[11],Werte[12],Werte[13]);
                    }
                }
                if (LesenMoeglich("Tshirts"))
                {
                    String[][] TshirtWerte = JSONjoin(JSONzu2Darray("Tshirts",5),0,OberteileWerte,8);
                    for (String[] Werte : TshirtWerte){
                        TShirt tShirt = new TShirt(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Integer.parseInt(Werte[9]),Werte[10],Werte[11],Werte[12]);
                    }
                }
                if (LesenMoeglich("SweatShirts"))
                {
                    String[][] SweatShritWerte = JSONjoin(JSONzu2Darray("SweatShirts",5),0,OberteileWerte,8);
                    for (String[] Werte : SweatShritWerte){
                        SweatShirt sweatShirt = new SweatShirt(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Integer.parseInt(Werte[9]),Werte[10],Boolean.parseBoolean(Werte[11]),Boolean.parseBoolean(Werte[12]));
                    }
                }
                if(LesenMoeglich("Polos"))
                {
                    String[][] PoloWerte = JSONjoin(JSONzu2Darray("Polos",6),0,OberteileWerte,8);
                    for (String[] Werte : PoloWerte){
                        Polo polo = new Polo(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Integer.parseInt(Werte[9]),Werte[10],Werte[11],Integer.parseInt(Werte[12]),Werte[13]);
                    }
                }
                if(LesenMoeglich("Tops"))
                {
                    String[][] TopsWerte = JSONjoin(JSONzu2Darray("Tops",5),0,OberteileWerte,8);
                    for (String[] Werte : TopsWerte){
                        Top top = new Top(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Integer.parseInt(Werte[9]),Werte[10],Werte[11],Werte[12]);
                    }
                }
                if(LesenMoeglich("Jacken"))
                {
                    String[][] JackerWerte = JSONjoin(JSONzu2Darray("Jacken",6),0,OberteileWerte,8);
                    for (String[] Werte : JackerWerte){
                        Jacke jacke = new Jacke(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Integer.parseInt(Werte[9]),Werte[10],Werte[11],Boolean.parseBoolean(Werte[12]),Werte[13]);
                    }
                }
            }
            // Kopfbedckung und Unterklassen
            if (LesenMoeglich("Kopfbedckungen"))
            {
                String[][] KopfbedckungWerte =  JSONjoin(JSONzu2Darray("Kopfbedeckungen",5),0,KleidungstueckeWerte,8);
                if (LesenMoeglich("Cappen"))
                {
                    String[][] CappeWerte =  JSONjoin(JSONzu2Darray("Cappen",5),0,KopfbedckungWerte,8);
                    for (String[] Werte : CappeWerte){
                        Cappe cappe = new Cappe(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Boolean.parseBoolean(Werte[9]),Boolean.parseBoolean(Werte[10]),Boolean.parseBoolean(Werte[11]),Werte[12]);
                    }
                }
                if  (LesenMoeglich("Huete"))
                {
                    String[][] HutWerte =  JSONjoin(JSONzu2Darray("Huete",7),0,KopfbedckungWerte,8);
                    for (String[] Werte : HutWerte){
                        Hut hut = new Hut(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Boolean.parseBoolean(Werte[9]),Boolean.parseBoolean(Werte[10]),Integer.parseInt(Werte[11]),Werte[12],Boolean.parseBoolean(Werte[13]),Boolean.parseBoolean(Werte[14]));
                    }
                }
                if (LesenMoeglich("Muetzen"))
                {
                    String[][] MuetzenWerte =  JSONjoin(JSONzu2Darray("Muetzen",5),0,KopfbedckungWerte,8);
                    for (String[] Werte : MuetzenWerte){
                        Muetze muetze = new Muetze(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Boolean.parseBoolean(Werte[9]),Boolean.parseBoolean(Werte[10]),Werte[11],Werte[12],Boolean.parseBoolean(Werte[13]));
                    }
                }
            }
            // Unterteil und Unterklassen
            if (LesenMoeglich("Unterteile"))
            {
                String[][] UnterteilWerte = JSONjoin(JSONzu2Darray("Unterteile",5),0,KleidungstueckeWerte,8);
                if (LesenMoeglich("Hosen"))
                {
                    String[][] HoseWerte = JSONjoin(JSONzu2Darray("Hosen",7),0,UnterteilWerte,8);
                    for (String[] Werte : HoseWerte){
                        Hose hose = new Hose(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Integer.parseInt(Werte[9]),Integer.parseInt(Werte[10]),Boolean.parseBoolean(Werte[11]),Boolean.parseBoolean(Werte[12]),Werte[13],Werte[14]);
                    }
                }
                if (LesenMoeglich("Roecke"))
                {
                    String[][] RockWerte = JSONjoin(JSONzu2Darray("Roecke",6),0,UnterteilWerte,8);
                    for (String[] Werte : RockWerte){
                        Rock rock = new Rock(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Integer.parseInt(Werte[9]),Integer.parseInt(Werte[10]),Werte[11],Integer.parseInt(Werte[12]),Werte[13]);
                    }
                }
            }
            //Schue und Unterklassen
            if (LesenMoeglich("Schuhe"))
            {
                String[][] SchuheWerte = JSONjoin(JSONzu2Darray("Schuhe",5),0,KleidungstueckeWerte,8);

                if (LesenMoeglich("Sneaker"))
                {
                    String[][] SneakerWerte = JSONjoin(JSONzu2Darray("Sneaker",5),0,SchuheWerte,8);
                    for (String[] Werte : SneakerWerte){
                        Sneaker sneaker = new Sneaker(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Werte[9],Werte[10],Boolean.parseBoolean(Werte[11]),Werte[12]);
                    }
                }
                if (LesenMoeglich("Steifel"))
                {
                    String[][] SteifelWerte = JSONjoin(JSONzu2Darray("Steifel",6),0,SchuheWerte,8);
                    for (String[] Werte : SteifelWerte){
                        Stiefel stiefel = new Stiefel(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Werte[9],Werte[10],Integer.parseInt(Werte[11]),Werte[12],Werte[13]);
                    }
                }
                if (LesenMoeglich("Halbschuhe")){
                    String[][] HalbschuheWerte = JSONjoin(JSONzu2Darray("Halbschuhe",5),0,SchuheWerte,8);
                    for (String[] Werte : HalbschuheWerte){
                        Halbschuhe halbschuhe = new Halbschuhe(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Werte[9],Werte[10],Werte[11],Werte[12]);
                    }
                }
            }
            //Kleid
            if (LesenMoeglich("Kleid"))
            {
                String[][] KleidWerte = JSONjoin(JSONzu2Darray("Kleid",6),0,KleidungstueckeWerte,8);
                for (String[] Werte : KleidWerte){
                    //Kleid kleid = new Kleid(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Werte[9],Werte[10],Integer.parseInt(Werte[11]),Boolean.parseBoolean(Werte[12]));
                }
            }
        }
    }
}


