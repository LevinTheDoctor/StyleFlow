import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Logger;
public class JSONReader {

    // Reader Klasse nimmt ids aus allen katehgorien um mit ein string array zu erzeugen der dann von den klassen eingelsen wird
    public void StartReader(){
        int[] KleidungstueckIDs = JSONgetID("Kleidungsstuecke",11,10);
        // Oberteile und Unterklassen
        int[] OberteilIDs = JSONgetID("Oberteile",5,1);
        int[] HemdIDs = JSONgetID("Hemd",5,1);
        int[] PulloverIDs = JSONgetID("Pullover",6,1);
        int[] TshirtIDs = JSONgetID("Tshirts",5,1);
        int[] SweatShritIDs = JSONgetID("SweatShirts",5,1);
        int[] PoloIDs =  JSONgetID("Polos",6,1);
        int[] TopIDs = JSONgetID("Tops",5,1);
        int[] JackerIDs = JSONgetID("Jacken",6,1);
        // Kopfbedckung und Unterklassen
        int[] KopfbedckungIDs = JSONgetID("Kopfbedeckungen",5,1);
        int[] CappeIDs = JSONgetID("Cappen",5,1);
        int[] HutIDs = JSONgetID("Huete",7,1);
        int[] muetzeIDs = JSONgetID("Muetzen",5,1);
        int[] sturmhaubeIDs = JSONgetID("Sturmhauben",5,1);
        // Unterteil und Unterklassen
        int[] UnterteilIDs = JSONgetID("Unterteile",5,1);
        int[] HoseIDs = JSONgetID("Hosen",7,1);
        int[] RockIDs = JSONgetID("Roecke",6,1);
        //Schue und Unterklassen
        int[] SchuheIDs = JSONgetID("Schuhe",5,1);
        int[] SneakerIDs = JSONgetID("Sneaker",5,1);
        int[] SteifelIDs = JSONgetID("Steifel",6,1);
        //Kleid
        int[] KleidIDs = JSONgetID("Kleid",6,1);

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

    // Methode um IDs zu bekommen
    public int[] JSONgetID(String filename,Integer ZeilenProEintrag, Integer IDZeile)
    {
        try(BufferedReader Reader = new BufferedReader(new FileReader(filename + ".json")))
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
            int JSONIndex = 1+IDZeile;
            int[] IDs = new int[Anzahl];
            for (int i = 0; i < Anzahl; i++)
            {
                IDs[i] = ReadInteger(AlleZeilen[JSONIndex]);
                JSONIndex += ZeilenProEintrag;
            }
            return IDs;
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONReader.class.getName());
            LOGGER.severe(e.getMessage());
            return new int[0];
        }
    }

}


