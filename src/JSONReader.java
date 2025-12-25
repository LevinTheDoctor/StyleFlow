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
        }

        // Oberteile und Unterklassen
        // Die Oberklasse MUSS Existiren daher wird nur darin geschekt ob die Datei der Unterklasse Existirt sonst könnte es zu Fehlerhaften Daten kommen
        if (LesenMoeglich("Oberteile"))
        {
            String[][] OberteileWerte = JSONzu2Darray("Oberteile",5);
            if (LesenMoeglich("Hemd"))
            {
                String[][] HemdWerte = JSONzu2Darray("Hemd",5);
            }
            if (LesenMoeglich("Pullover"))
            {
                String[][] PulloverWerte = JSONzu2Darray("Pullover",6);
            }
            if (LesenMoeglich("Tshirts"))
           {
               String[][] TshirtWerte = JSONzu2Darray("Tshirts",5);
           }
           if (LesenMoeglich("SweatShirts"))
           {
               String[][] SweatShritWerte = JSONzu2Darray("SweatShirts",5);
           }
           if(LesenMoeglich("Polos"))
            {
                String[][] PoloWerte = JSONzu2Darray("Polos",6);
            }
            if(LesenMoeglich("Tops"))
            {
                String[][] TopsWerte = JSONzu2Darray("Tops",5);
            }
            if(LesenMoeglich("Jacken"))
            {
                String[][] JackerWerte = JSONzu2Darray("Jacken",6);
            }
        }
        // Kopfbedckung und Unterklassen
        if (LesenMoeglich("Kopfbedckungen"))
        {
            String[][] KopfbedckungWerte =  JSONzu2Darray("Kopfbedeckungen",5);
            if (LesenMoeglich("Cappen"))
            {
                String[][] CappeWerte =  JSONzu2Darray("Cappen",5);
            }
            if  (LesenMoeglich("Huete"))
            {
                String[][] HutWerte =  JSONzu2Darray("Huete",7);
            }
            if (LesenMoeglich("Muetzen"))
            {
                String[][] MuetzenWerte =  JSONzu2Darray("Muetzen",5);
            }
            if(LesenMoeglich("Sturmhauben"))
            {
                String[][] SturmhaubenWerte =  JSONzu2Darray("Sturmhauben",5);
            }
        }
        // Unterteil und Unterklassen
        if (LesenMoeglich("Unterteile"))
        {
            String[][] UnterteilWerte = JSONzu2Darray("Unterteile",5);
            if (LesenMoeglich("Hosen"))
            {
                String[][] HoseWerte = JSONzu2Darray("Hosen",7);
            }
            if (LesenMoeglich("Roecke"))
            {
                String[][] RockWerte = JSONzu2Darray("Roecke",6);
            }


        }
        //Schue und Unterklassen
        if (LesenMoeglich("Schuhe"))
        {
            String[][] SchuheWerte = JSONzu2Darray("Schuhe",5);
            if (LesenMoeglich("Sneaker"))
            {
                String[][] SneakerWerte = JSONzu2Darray("Sneaker",5);
            }
            if (LesenMoeglich("Steifel"))
            {
                String[][] SteifelWerte = JSONzu2Darray("Steifel",6);
            }
        }
        //Kleid
        if (LesenMoeglich("Kleid"))
        {
            String[][] KleidWerte = JSONzu2Darray("Kleid",6);
        }
        // Zusammenfügen also Quasi die JOIN lodik wie in SQL
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


