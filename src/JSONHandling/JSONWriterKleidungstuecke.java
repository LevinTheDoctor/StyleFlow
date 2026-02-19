package JSONHandling;
import static JSONHandling.JSONWriterHelper.*;
import KleidungsKlassen.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

public class JSONWriterKleidungstuecke {

    public void JSONWrite(KleidungsContainer AlleKleidungsStuecke) {
        if (AlleKleidungsStuecke == null) return;

        // 1. Basis & Kopfbedeckungen
        if (AlleKleidungsStuecke.getKleidungsstuecke() != null)
            KleidungstueckWriter(AlleKleidungsStuecke.getKleidungsstuecke());

        if (AlleKleidungsStuecke.getKopfbedeckungen() != null)
            KopfbeckungWriter(AlleKleidungsStuecke.getKopfbedeckungen());

        if (AlleKleidungsStuecke.getMuetzen() != null)
            MeutzeWriter(AlleKleidungsStuecke.getMuetzen());

        if (AlleKleidungsStuecke.getHuete() != null)
            HueteWriter(AlleKleidungsStuecke.getHuete());

        if (AlleKleidungsStuecke.getCaps() != null)
            CapWriter(AlleKleidungsStuecke.getCaps());

        if (AlleKleidungsStuecke.getUnterteile() != null)
            UnterteilWriter(AlleKleidungsStuecke.getUnterteile());

        if (AlleKleidungsStuecke.getHosen() != null)
            HoseWriter(AlleKleidungsStuecke.getHosen());

        if (AlleKleidungsStuecke.getRoecke() != null)
            RockWriter(AlleKleidungsStuecke.getRoecke());

        if (AlleKleidungsStuecke.getEinteiler() != null)
            EinteilerWriter(AlleKleidungsStuecke.getEinteiler());

        if (AlleKleidungsStuecke.getKleider() != null)
            KleidWriter(AlleKleidungsStuecke.getKleider());

        if (AlleKleidungsStuecke.getOveralls() != null)
            OverallWriter(AlleKleidungsStuecke.getOveralls());

        if (AlleKleidungsStuecke.getSchuhe() != null)
            SchuheWriter(AlleKleidungsStuecke.getSchuhe());

        if (AlleKleidungsStuecke.getHighHeels() != null)
            HighHeelWriter(AlleKleidungsStuecke.getHighHeels());

        if (AlleKleidungsStuecke.getSneakers() != null)
            SneakerWriter(AlleKleidungsStuecke.getSneakers());

        if (AlleKleidungsStuecke.getStiefel() != null)
            StiefelWriter(AlleKleidungsStuecke.getStiefel());

        if (AlleKleidungsStuecke.getSandalen() != null)
            SandalenWriter(AlleKleidungsStuecke.getSandalen());

        if (AlleKleidungsStuecke.getHalbschuhe() != null)
            HalbschueWriter(AlleKleidungsStuecke.getHalbschuhe());

        if (AlleKleidungsStuecke.getOberteile() != null)
            OberteilWriter(AlleKleidungsStuecke.getOberteile());

        if (AlleKleidungsStuecke.getHemden() != null)
            HemdWriter(AlleKleidungsStuecke.getHemden());

        if (AlleKleidungsStuecke.getPolos() != null)
            PoloWriter(AlleKleidungsStuecke.getPolos());

        if (AlleKleidungsStuecke.getPullover() != null)
            PulloverWriter(AlleKleidungsStuecke.getPullover());

        if (AlleKleidungsStuecke.getHoodies() != null)
            HoodieWriter(AlleKleidungsStuecke.getHoodies());

        if (AlleKleidungsStuecke.getTshirts() != null)
            TShirtWriter(AlleKleidungsStuecke.getTshirts());

        if (AlleKleidungsStuecke.getTops() != null)
            TopWriter(AlleKleidungsStuecke.getTops());

        if (AlleKleidungsStuecke.getJacken() != null)
            JackeWriter(AlleKleidungsStuecke.getJacken());

        if (AlleKleidungsStuecke.getMaentel() != null)
            MantelWriter(AlleKleidungsStuecke.getMaentel());

        if (AlleKleidungsStuecke.getWinterJacken() != null)
            WinterJackeWriter(AlleKleidungsStuecke.getWinterJacken());

        if (AlleKleidungsStuecke.getRegenJacken() != null)
            RegenJackeWriter(AlleKleidungsStuecke.getRegenJacken());

        if (AlleKleidungsStuecke.getSweatshirtJacken() != null)
            SweatshirtJackeWriter(AlleKleidungsStuecke.getSweatshirtJacken());

        if (AlleKleidungsStuecke.getUebergangsJacken() != null)
            UebergangsJackeWriter(AlleKleidungsStuecke.getUebergangsJacken());
    }
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

    public void  MeutzeWriter(ArrayList<Muetze> muetzes)
    {
        try
        {
            File MuetzeFile = new File("Muetze.json");
            PrintWriter writer = new PrintWriter(MuetzeFile);
            writer.println("[");
            int i = 0;
            for (Muetze indexkleidungsstuck : muetzes)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"stil",indexkleidungsstuck.getStil(),false);
                WriteString(writer,"strickArt",indexkleidungsstuck.getStrickArt(),true);
                if (i == muetzes.size()-1)
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

    public void  HueteWriter(ArrayList<Hut> Huetes)
    {
        try
        {
            File HueteFile = new File("Huete.json");
            PrintWriter writer = new PrintWriter(HueteFile);
            writer.println("[");
            int i = 0;
            for (Hut indexkleidungsstuck : Huetes)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteInteger(writer,"hoehe",indexkleidungsstuck.getHoehe(),false);
                WriteString(writer,"Art",indexkleidungsstuck.getArtHut(),true);
                if (i == Huetes.size()-1)
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

    public void  CapWriter(ArrayList<Cap> Caps)
    {
        try
        {
            File CapFile = new File("Cap.json");
            PrintWriter writer = new PrintWriter(CapFile);
            writer.println("[");
            int i = 0;
            for (Cap indexkleidungsstuck : Caps)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteBoolean(writer,"SchirmGekruemt",indexkleidungsstuck.isIstSchirmGekruemmt(),false);
                WriteString(writer,"VerschlussArt",indexkleidungsstuck.getVerschlussArt(),true);
                if (i == Caps.size()-1)
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

    public void HoseWriter(ArrayList<Hose> Hosen){
        try
        {
            File HoseFile = new File("Hose.json");
            PrintWriter writer = new PrintWriter(HoseFile);
            writer.println("[");
            int i = 0;
            for (Hose indexkleidungsstuck : Hosen)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteBoolean(writer,"HatLoecher",indexkleidungsstuck.isHatLoecher(),false);
                WriteString(writer,"Weite",indexkleidungsstuck.getWeite(),false);
                WriteString(writer,"Waschung",indexkleidungsstuck.getWaschung(),false);
                WriteString(writer,"Besonderheiten",indexkleidungsstuck.getBesonderheiten(),false);
                WriteString(writer,"artDerHose",indexkleidungsstuck.getArtHose(),true);
                if (i == Hosen.size()-1)
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

    public void RockWriter(ArrayList<Rock> Rock){
        try
        {
            File UnterteileFile = new File("Unterteil.json");
            PrintWriter writer = new PrintWriter(UnterteileFile);
            writer.println("[");
            int i = 0;
            for (Rock indexkleidungsstuck : Rock)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"art",indexkleidungsstuck.getArtRock(),true);
                if (i == Rock.size()-1)
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

    public void KleidWriter(ArrayList<Kleid> Kleider){
        try
        {
            File KleidFile = new File("Kleid.json");
            PrintWriter writer = new PrintWriter(KleidFile);
            writer.println("[");
            int i = 0;
            for (Kleid indexkleidungsstuck : Kleider)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),true);
                if (i == Kleider.size()-1)
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

    public void OverallWriter(ArrayList<Overall> overalls){
        try
        {
            File OverallFile = new File("Overall.json");
            PrintWriter writer = new PrintWriter(OverallFile);
            writer.println("[");
            int i = 0;
            for (Overall indexkleidungsstuck : overalls)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),true);
                if (i == overalls.size()-1)
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

    public void HighHeelWriter(ArrayList<HighHeels> highHeels){
        try
        {
            File HighHeelsFile = new File("HighHells.json");
            PrintWriter writer = new PrintWriter(HighHeelsFile);
            writer.println("[");
            int i = 0;
            for (HighHeels indexkleidungsstuck : highHeels)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteBoolean(writer,"IstOffen",indexkleidungsstuck.isIstOffen(),true);
                if (i == highHeels.size()-1)
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

    public void SneakerWriter(ArrayList<Sneaker> Sneaker){
        try
        {
            File SneakerFile = new File("Sneaker.json");
            PrintWriter writer = new PrintWriter(SneakerFile);
            writer.println("[");
            int i = 0;
            for (Sneaker indexkleidungsstuck : Sneaker)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"technolgie",indexkleidungsstuck.getTechnologie(),true);
                if (i == Sneaker.size()-1)
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

    public void StiefelWriter(ArrayList<Stiefel> Stiefel){
        try
        {
            File StiefelFile = new File("Stiefel.json");
            PrintWriter writer = new PrintWriter(StiefelFile);
            writer.println("[");
            int i = 0;
            for (Stiefel indexkleidungsstuck : Stiefel)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"art",indexkleidungsstuck.getArt(),false);
                WriteString(writer,"muster",indexkleidungsstuck.getMuster(),true);
                if (i == Stiefel.size()-1)
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

    public void SandalenWriter(ArrayList<Sandalen> Sandalen){
        try
        {
            File SandalenFile = new File("Sandalen.json");
            PrintWriter writer = new PrintWriter(SandalenFile);
            writer.println("[");
            int i = 0;
            for (Sandalen indexkleidungsstuck : Sandalen)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteBoolean(writer,"istOffen",indexkleidungsstuck.isIstOffen(),false);
                WriteInteger(writer,"almanFaktor",indexkleidungsstuck.getAlmanFaktor(),true);
                if (i == Sandalen.size()-1)
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

    public void HalbschueWriter(ArrayList<Halbschuhe> Halbschuhe){
        try
        {
            File HalbschuheFile = new File("Halbschuhe.json");
            PrintWriter writer = new PrintWriter(HalbschuheFile);
            writer.println("[");
            int i = 0;
            for (Halbschuhe indexkleidungsstuck : Halbschuhe)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"Art",indexkleidungsstuck.getArt(),false);
                WriteString(writer,"muster",indexkleidungsstuck.getMuster(),true);
                if (i == Halbschuhe.size()-1)
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

    public void HemdWriter(ArrayList<Hemd> Hemd){
        try
        {
            File HemdFile = new File("Hemd.json");
            PrintWriter writer = new PrintWriter(HemdFile);
            writer.println("[");
            int i = 0;
            for (Hemd indexkleidungsstuck : Hemd)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"kragenArt",indexkleidungsstuck.getKragenArt(),false);
                WriteString(writer,"Muster",indexkleidungsstuck.getMuster(),true);
                if (i == Hemd.size()-1)
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

    public void PoloWriter(ArrayList<Polo> Polo){
        try
        {
            File PoloFile = new File("Polo.json");
            PrintWriter writer = new PrintWriter(PoloFile);
            writer.println("[");
            int i = 0;
            for (Polo indexkleidungsstuck : Polo)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"kragenArt",indexkleidungsstuck.getKragenArt(),false);
                WriteInteger(writer,"anzahlKnopfe", indexkleidungsstuck.getAnzahlKnopfe(), true);
                if (i == Polo.size()-1)
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

    public void PulloverWriter(ArrayList<Pullover> Pullover){
        try
        {
            File PulloverFile = new File("Pullover.json");
            PrintWriter writer = new PrintWriter(PulloverFile);
            writer.println("[");
            int i = 0;
            for (Pullover indexkleidungsstuck : Pullover)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"AusschnitArt",indexkleidungsstuck.getAusschnittArt(),false);
                WriteString(writer,"StrickArt",indexkleidungsstuck.getStrickArt(),true);
                if (i == Pullover.size()-1)
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
    public void HoodieWriter(ArrayList<Hoodie> Hoodie){
        try
        {
            File HoodieFile = new File("Hoodie.json");
            PrintWriter writer = new PrintWriter(HoodieFile);
            writer.println("[");
            int i = 0;
            for (Hoodie indexkleidungsstuck : Hoodie)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteBoolean(writer,"hatTaschen",indexkleidungsstuck.isHatTasche(),true);
                if (i == Hoodie.size()-1)
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

    public void TShirtWriter(ArrayList<TShirt> TShirt){
        try
        {
            File TShirtFile = new File("TShirt.json");
            PrintWriter writer = new PrintWriter(TShirtFile);
            writer.println("[");
            int i = 0;
            for (TShirt indexkleidungsstuck : TShirt)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"AusschnitArt",indexkleidungsstuck.getAusschnittArt(),true);

                if (i == TShirt.size()-1)
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

    public void TopWriter(ArrayList<Top> Top){
        try
        {
            File TopFile = new File("Top.json");
            PrintWriter writer = new PrintWriter(TopFile);
            writer.println("[");
            int i = 0;
            for (Top indexkleidungsstuck : Top)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),false);
                WriteString(writer,"AusschnitArt",indexkleidungsstuck.getAusschnittArt(),false);
                WriteString(writer,"ausschnitArt",indexkleidungsstuck.getAusschnittArt(),true);
                if (i == Top.size()-1)
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

    public void MantelWriter(ArrayList<Mantel> Mantel){
        try
        {
            File OverallFile = new File("Mantel.json");
            PrintWriter writer = new PrintWriter(OverallFile);
            writer.println("[");
            int i = 0;
            for (Mantel indexkleidungsstuck : Mantel)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),true);
                if (i == Mantel.size()-1)
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


    public void WinterJackeWriter(ArrayList<WinterJacke> WinterJacke){
        try
        {
            File WinterJackeFile = new File("WinterJacke.json");
            PrintWriter writer = new PrintWriter(WinterJackeFile);
            writer.println("[");
            int i = 0;
            for (WinterJacke indexkleidungsstuck : WinterJacke)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),true);
                if (i == WinterJacke.size()-1)
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

    public void RegenJackeWriter(ArrayList<RegenJacke> RegenJacke){
        try
        {
            File RegenJackeFile = new File("RegenJacke.json");
            PrintWriter writer = new PrintWriter(RegenJackeFile);
            writer.println("[");
            int i = 0;
            for (RegenJacke indexkleidungsstuck : RegenJacke)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),true);
                if (i == RegenJacke.size()-1)
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
    public void SweatshirtJackeWriter(ArrayList<SweatshirtJacke> SweatshirtJacke){
        try
        {
            File SweatshirtJackeFile = new File("SweatshirtJacke.json");
            PrintWriter writer = new PrintWriter(SweatshirtJackeFile);
            writer.println("[");
            int i = 0;
            for (SweatshirtJacke indexkleidungsstuck : SweatshirtJacke)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),true);
                if (i == SweatshirtJacke.size()-1)
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

    public void UebergangsJackeWriter(ArrayList<UebergangsJacke> UebergangsJacke){
        try
        {
            File UebergangsJackeFile = new File("UebergangsJacke.json");
            PrintWriter writer = new PrintWriter(UebergangsJackeFile);
            writer.println("[");
            int i = 0;
            for (UebergangsJacke indexkleidungsstuck : UebergangsJacke)
            {
                writer.println("{");
                WriteInteger(writer,"ID",indexkleidungsstuck.getKleidungsID(),true);
                if (i == UebergangsJacke.size()-1)
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
