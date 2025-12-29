import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Logger;
// Die Ganze JSON Read geschichte ist eingetlich daher verschulde das ich im abi und jetzt in der Ausbildung nur mit Datenbanken rumhantier und ich versuche quasi ein Join der JSON Datein manuel über Java ich weiß das ist nicht elgenat aber das kenne ich halt - Levin
public class JSONReader {


    // Reader Klasse nimmt ids aus allen katehgorien um mit ein string array zu erzeugen der dann von den klassen eingelsen wird
    public void StartReader(){
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
                }
                if  (LesenMoeglich("Huete"))
                {
                    String[][] HutWerte =  JSONjoin(JSONzu2Darray("Huete",7),0,KopfbedckungWerte,8);
                }
                if (LesenMoeglich("Muetzen"))
                {
                    String[][] MuetzenWerte =  JSONjoin(JSONzu2Darray("Muetzen",5),0,KopfbedckungWerte,8);
                }
                if(LesenMoeglich("Sturmhauben"))
                {
                    String[][] SturmhaubenWerte =  JSONjoin(JSONzu2Darray("Sturmhauben",5),0,KopfbedckungWerte,8);
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
                    Kleid kleid = new Kleid(Werte[0],Werte[1].split(","),Werte[2],Werte[3].split(","),Werte[4],Werte[5],Werte[6],Werte[7],Integer.parseInt(Werte[8]),Werte[9],Werte[10],Integer.parseInt(Werte[11]),Boolean.parseBoolean(Werte[12]));
                }
            }
        }
    }


    public String[][] JSONjoin(String[][] Grundliste,int indexIDGrundliste,String[][] Erweitrungsliste, int indexIDErweitrungsliste)
    {
        String[][] JoinedListe = new String[Grundliste.length][Grundliste[0].length+Erweitrungsliste[0].length-1];
        int JoindListListIndex = 0;
        for(String[] GrundElement : Grundliste)
        {
            int ID = Integer.parseInt(GrundElement[indexIDGrundliste]);
            for(String[] ErweitrungElement : Erweitrungsliste)
            {
                int EID = Integer.parseInt(ErweitrungElement[indexIDErweitrungsliste]);
                if (ID == EID)
                {
                    System.arraycopy(ErweitrungElement, 0, JoinedListe[JoindListListIndex], 0, ErweitrungElement.length);
                    String[] GrundElementOhneID = new String[GrundElement.length-1];
                    int idxGrundOhneID = 0;
                    for (int indexG = 0; indexG < GrundElement.length; indexG++)
                    {
                        if (indexG != indexIDGrundliste) {
                            GrundElementOhneID[idxGrundOhneID] = GrundElement[indexG];
                            idxGrundOhneID++;
                        }
                    }
                    int StartIndex = ErweitrungElement.length;
                    System.arraycopy(GrundElementOhneID, 0, JoinedListe[JoindListListIndex], StartIndex , GrundElementOhneID.length);
                    JoindListListIndex++;
                }
            }

        }
        return JoinedListe;
    }

    public String[][] JSONzu2Darray(String Filename, Integer ZeilenProEintrag)
    {
        try(BufferedReader Reader = new BufferedReader(new FileReader(Filename + ".json")))
        {
            String line;
            StringBuilder Content = new StringBuilder();
            int ZeileAnzahl = 0;
            while ((line = Reader.readLine()) != null)
            {
                Content.append(line).append("\n");
                ZeileAnzahl++;
            }
            int Anzahl = (ZeileAnzahl-2) / ZeilenProEintrag;
            String[] AlleZeilen = Content.toString().split("\n");
            int JSONIndex = 2;
            String[][] Werte = new String[Anzahl][ZeilenProEintrag-2];
            for (int indexAnzahl = 0; indexAnzahl < Anzahl; indexAnzahl++)
            {
                for (int zeile = 0; zeile < ZeilenProEintrag-2; zeile++)
                {
                    String Typ = JSONerkenneTyp(AlleZeilen[JSONIndex+zeile]);
                    switch (Typ){
                        case "ARRAY":
                            Werte[indexAnzahl][zeile] = String.join(",",ReadStringArray(AlleZeilen[JSONIndex+zeile]));
                            break;
                        case "BOOLEAN":
                            if(ReadBoolean(AlleZeilen[JSONIndex+zeile]))
                            {
                                Werte[indexAnzahl][zeile] ="true";
                            }
                            else
                            {
                                Werte[indexAnzahl][zeile] ="false";
                            }

                            break;
                        case "STRING":
                            Werte[indexAnzahl][zeile] = ReadString(AlleZeilen[JSONIndex+zeile]);
                            break;
                        case "INTEGER":
                            Werte[indexAnzahl][zeile] = ReadInteger(AlleZeilen[JSONIndex+zeile]).toString();
                            break;
                }

                }
                JSONIndex += ZeilenProEintrag;
            }
            return Werte;
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONReader.class.getName());
            LOGGER.severe(e.getMessage());
            return new String[0][0];
        }
    }

    //Herraus finde Daten Typ JSON
    public String JSONerkenneTyp(String Wert) {
        String WertZugeschnitten = Wert.substring(Wert.indexOf(":") + 1).trim().replace(",", "");
        if (WertZugeschnitten.startsWith("[") && WertZugeschnitten.endsWith("]")) {
            return "ARRAY";
        }

        if (WertZugeschnitten.equals("true") || WertZugeschnitten.equals("false")) {
            return "BOOLEAN";
        }

        if (WertZugeschnitten.startsWith("\"") && WertZugeschnitten.endsWith("\"")) {
            return "STRING";
        }

        return "INTEGER";
    }

    // Überprüft, ob das Lesen der JSON-Datei Existirt wichtig für den Ersten Start
    public boolean LesenMoeglich(String filename)
    {
        File File = new File(filename + ".json");
        return File.exists();
    }

    // Methoden zum Parsen der Daten aus der JSON-Datei
    public boolean ReadBoolean(String line)
    {
        String[] parts = line.split(":");
        return Boolean.parseBoolean(parts[1].trim().replace(",", "").replace("\"", ""));
    }

    public String ReadString(String line) {
        String[] parts = line.split(":");
        return parts[1].trim().replace(",", "").replace("\"", "");
    }

    public String[] ReadStringArray(String line)
    {
        String[] parts = line.split(":");
        String arrayInJSON = parts[1].trim().replace(",", "").replace("[", "").replace("]", "").replace("\"", "");
        return arrayInJSON.split(",");
    }

    public Integer ReadInteger(String line)
    {
        String[] parts = line.split(":");
        return Integer.parseInt(parts[1].trim().replace(",", "").replace("\"", ""));
    }

}


