package JSONHandling;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Logger;
import Exception.KeineJsonGefundenException;

// Vorher waren diese helper erst nur in der JSON ReaderKleidundstücke nun ist es ausgekoppelt
public class JSONReaderHelper {



    public static String[][] JSONjoin(String[][] Grundliste,int indexIDGrundliste,String[][] Erweitrungsliste, int indexIDErweitrungsliste)
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

    public static String[][] JSONzu2Darray(String Filename, Integer ZeilenProEintrag)
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
            Logger LOGGER = Logger.getLogger(JSONReaderKleidungstuecke.class.getName());
            LOGGER.severe(e.getMessage());
            return new String[0][0];
        }
    }

    //Herraus finde Daten Typ JSON
    public static String JSONerkenneTyp(String Wert) {
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
    public static void LesenMoeglich(String filename)
    {
        File File = new File(filename + ".json");
        if (!File.exists()) {
            throw new KeineJsonGefundenException(filename);
        }
    }

    // Methoden zum Parsen der Daten aus der JSON-Datei
    public static boolean ReadBoolean(String line)
    {
        String[] parts = line.split(":");
        return Boolean.parseBoolean(parts[1].trim().replace(",", "").replace("\"", ""));
    }

    public static String ReadString(String line) {
        String[] parts = line.split(":");
        return parts[1].trim().replace(",", "").replace("\"", "");
    }

    public static String[] ReadStringArray(String line)
    {
        String[] parts = line.split(":");
        String arrayInJSON = parts[1].trim().replace("[", "").replace("]", "").replace("\"", "");
        // leerezeichen ignoriren
        return arrayInJSON.split("\\s*,\\s*");
    }

    public static Integer ReadInteger(String line)
    {
        String[] parts = line.split(":");
        return Integer.parseInt(parts[1].trim().replace(",", "").replace("\"", ""));
    }
}
