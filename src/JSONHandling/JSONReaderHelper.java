package JSONHandling;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Logger;
import Exception.KeineJsonGefundenException;
import java.util.ArrayList;
import java.util.Arrays;

// Vorher waren diese Helper nur in der JSON ReaderKleidungstuecke, nun sind sie ausgekoppelt
public class JSONReaderHelper {


    public static String[][] KlassenStringAusJSONStringListe(String Filename, String[][] VererbteDaten){
        // VererbteDaten leer → direkt null zurückgeben
        if (VererbteDaten == null || VererbteDaten.length == 0
                || VererbteDaten[0] == null || VererbteDaten[0].length == 0) {
            return null;
        }
        String[][] KlasseAusJson = LesenSafe(Filename);
        if(KlasseAusJson != null && KlasseAusJson.length > 0
                && KlasseAusJson[0] != null && KlasseAusJson[0].length > 0)
        {
            return JSONjoin(KlasseAusJson,0,VererbteDaten,5);
        }
        else
        {
            return null;
        }
    }

    public static int berechneZeilenProEintrag(ArrayList<String> Zeilen){
        int Start = -1;
        int Start2 = -1;

        for (int i = 0; i < Zeilen.size(); i++)
        {
            if (Start == -1)
            {
                if(Zeilen.get(i).contains("{"))
                {
                    Start = i;
                }
            }
            else
            {
                if(Zeilen.get(i).contains("{"))
                {
                    Start2 = i;
                    break;
                }
            }
        }

        // Zweites { gefunden → normaler Mehrfacheintrag-Fall
        if (Start2 != -1) {
            return Start2 - Start;
        }

        // Kein zweites { gefunden → nur ein Eintrag in der Datei
        // Zeilenzahl bis zum ersten } nach dem { zählen
        if (Start != -1) {
            for (int i = Start + 1; i < Zeilen.size(); i++) {
                if (Zeilen.get(i).contains("}")) {
                    return (i - Start) + 1;
                }
            }
        }

        return 0; // leere Datei
    }


    public static String[][] JSONjoin(String[][] Grundliste,int indexIDGrundliste,String[][] Erweitrungsliste, int indexIDErweitrungsliste)
    {
        // Sicherheitsprüfung: leere oder null Arrays abfangen
        if (Grundliste == null || Erweitrungsliste == null
                || Grundliste.length == 0 || Erweitrungsliste.length == 0
                || Grundliste[0] == null || Erweitrungsliste[0] == null
                || Grundliste[0].length == 0 || Erweitrungsliste[0].length == 0) {
            return new String[0][0];
        }

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

    // Überprüft, ob das Lesen der JSON-Datei existiert – wichtig für den ersten Start
    public static String[][] LesenSafe(String filename)
    {
        try{
            return JSONzu2Darray(filename);
        }
        catch(KeineJsonGefundenException e){
            System.out.println("Datei nicht gefunden, überspringe: " + filename);
            return null;
        }
    }

    public static boolean LesenMoeglich(String filename)
    {
        File File = new File(filename + ".json");
        return File.exists();
    }

    public static String[][] JSONzu2Darray(String Filename) throws KeineJsonGefundenException
    {
        if (!LesenMoeglich(Filename))
        {
            throw new KeineJsonGefundenException(Filename);
        }
        else
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

                String[] AlleZeilen = Content.toString().split("\n");
                ArrayList<String> ZeilenArrayList = new ArrayList<>(Arrays.asList(AlleZeilen));
                int ZeilenProEintrag = berechneZeilenProEintrag(ZeilenArrayList);

                // Sicherheitsprüfung: ungültige oder leere Datei
                if (ZeilenProEintrag <= 2) {
                    Logger LOGGER = Logger.getLogger(JSONReaderKleidungstuecke.class.getName());
                    LOGGER.severe(String.valueOf(ZeilenProEintrag));
                    return null;
                }

                int Anzahl = (ZeileAnzahl-2) / ZeilenProEintrag;

                // Sicherheitsprüfung: keine Einträge
                if (Anzahl <= 0) {
                    return null;
                }

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
                return null;
            }
        }
    }

    // Herausfinden des Datentyps aus JSON
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
        // Leerzeichen ignorieren
        return arrayInJSON.split("\\s*,\\s*");
    }

    public static Integer ReadInteger(String line)
    {
        String[] parts = line.split(":");
        return Integer.parseInt(parts[1].trim().replace(",", "").replace("\"", ""));
    }
}