package JSONHandling;
import static JSONHandling.JSONWriterHelper.*;
import KleidungsKlassen.*;
import Nutzer.Nutzer;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

public class JSONWriterKleidungstuecke {

    public void  KleidungstueckWriter(ArrayList<Kleidungsstueck> Kleidunsstuecke)
    {
        try
        {
            File KleidungsstueckFile = new File("Kleidungsstueck.json");
            PrintWriter writer = new PrintWriter(KleidungsstueckFile);
            writer.println("[");
            int i = 0;
            for (Kleidungsstueck indexkleidungsstuck : Kleidunsstuecke)
            {
                writer.println("{");
                WriteString(writer,"Bezeichnung",indexkleidungsstuck.getBezeichnung(),false);
                WriteStringArray(writer,"Farben",indexkleidungsstuck.getFarben(),false);
                WriteString(writer,"BedecktesKoerperteil",indexkleidungsstuck.getBedecktesKoerperteil(),false);
                WriteString(writer,"Wettereignung",indexkleidungsstuck.getWettereignung(),false);
                WriteString(writer,"BildDateiPfad",indexkleidungsstuck.getBildDateiPfad(),false);
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),true);
                if (i == Kleidunsstuecke.size()-1)
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
                i++;
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch ( Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriterKleidungstuecke.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void  KopfbeckungWriter(ArrayList<Kopfbedeckung> Kopfbecekung)
    {
        try
        {
            File KopfbedeckungFile = new File("Kopfbedeckung.json");
            PrintWriter writer = new PrintWriter(KopfbedeckungFile);
            writer.println("[");
            int i = 0;
            for (Kopfbedeckung indexkleidungsstuck : Kopfbecekung)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),true);
                if (i == Kopfbecekung.size()-1)
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
                i++;
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch ( Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriterKleidungstuecke.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }


    public void UnterteilWriter(ArrayList<Unterteil> Unterteile){
        try
        {
            File UnterteileFile = new File("Unterteil.json");
            PrintWriter writer = new PrintWriter(UnterteileFile);
            writer.println("[");
            int i = 0;
            for (Unterteil indexkleidungsstuck : Unterteile)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteInteger(writer,"lange",indexkleidungsstuck.getLaenge(),false);
                WriteInteger(writer,"anzahlTasch",indexkleidungsstuck.getAnzahlTaschen(),true);
                if (i == Unterteile.size()-1)
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
                i++;
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch ( Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriterKleidungstuecke.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void EinteilerWriter(ArrayList<Einteiler> Einteriler){
        try
        {
            File EinteilerFile = new File("Einteiler.json");
            PrintWriter writer = new PrintWriter(EinteilerFile);
            writer.println("[");
            int i = 0;
            for (Einteiler indexkleidungsstuck : Einteriler)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"auschnittArt",indexkleidungsstuck.getAusschnittArt(),false);
                WriteString(writer,"weite",indexkleidungsstuck.getWeite(),false);
                WriteInteger(writer,"lange",indexkleidungsstuck.getLaenge(),false);
                WriteBoolean(writer,"hatAermel",indexkleidungsstuck.isHatAermel(),true);
                if (i == Einteriler.size()-1)
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
                i++;
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch ( Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriterKleidungstuecke.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void SchuheWriter(ArrayList<Schuhe> Schuhe){
        try
        {
            File SchuheFile = new File("Schuhe.json");
            PrintWriter writer = new PrintWriter(SchuheFile);
            writer.println("[");
            int i = 0;
            for (Schuhe indexkleidungsstuck : Schuhe)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"absatzHoehe",indexkleidungsstuck.getAbsatzHoehe(),true);
                if (i == Schuhe.size()-1)
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
                i++;
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch ( Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriterKleidungstuecke.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void OberteilWriter(ArrayList<Oberteil> Oberteil){
        try
        {
            File ObrteilFile = new File("Oberteil.json");
            PrintWriter writer = new PrintWriter(ObrteilFile);
            writer.println("[");
            int i = 0;
            for (Oberteil indexkleidungsstuck : Oberteil)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteInteger(writer,"aermelLaenge", indexkleidungsstuck.getAermelLaenge(), false);
                WriteString(writer,"schnitt",indexkleidungsstuck.getSchnitt(),true);
                if (i == Oberteil.size()-1)
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
                i++;
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch ( Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriterKleidungstuecke.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void JackeWriter(ArrayList<Jacke> Jacke){
        try
        {
            File JackeFile = new File("Jacke.json");
            PrintWriter writer = new PrintWriter(JackeFile);
            writer.println("[");
            int i = 0;
            for (Jacke indexkleidungsstuck : Jacke)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"VerschlussArt",indexkleidungsstuck.getVerschlussArt(),false);
                WriteBoolean(writer,"istWasserdicht",indexkleidungsstuck.isIstWasserdicht(),false);
                WriteString(writer,"futterMaterial",indexkleidungsstuck.getFutterMaterial(),true);
                if (i == Jacke.size()-1)
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
                i++;
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch ( Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriterKleidungstuecke.class.getName());
            LOGGER.severe(e.getMessage());
        }

    }





}
