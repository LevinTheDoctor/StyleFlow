import java.io.File;
import java.io.PrintWriter;
import java.util.logging.Logger;
public class JSONWriter {
    public void Komma(PrintWriter writer, Boolean LetztesElement)
    {
        if (LetztesElement)
        {
            writer.println(",");
        }
        else
        {
            writer.println("");
        }
    }
    public void WriteBoolean (PrintWriter writer,String name, Boolean Wert,Boolean LetztesElement)
    {
        writer.print("\""+ name +"\":" + Wert);
        Komma(writer,LetztesElement);
    }

    public void WriteInteger (PrintWriter writer,String name, Integer Wert, Boolean LetztesElement)
    {
        writer.print("\""+ name +"\":" + Wert);
        Komma(writer,LetztesElement);
    }
    public void WriteString (PrintWriter writer,String name, String Wert, Boolean LetztesElement)
    {
        writer.print("\""+ name +"\": \"" + Wert + "\"");
        Komma(writer,LetztesElement);
    }

    public void WriteStringArray (PrintWriter writer,String name, String[] Werte, Boolean LetztesElementBool)
    {
        String LetztesElement = Werte[Werte.length -1];
        writer.print("\""+ name + "\": [");
        for (String Wert : Werte)
        {
            writer.print("\"" + Wert + "\"");
            if (!Wert.equals(LetztesElement))
            {
                writer.print(", ");
            }
        }
        writer.print("]");
        Komma(writer,LetztesElementBool);
    }
    // Wirklich Schreibfunktionen für die jeweiligen Kleidungsstücke
    public void KleidungsstueckWriter(Kleidungsstueck[] kleidungsstuecke)
    {
        try
        {
            File KleidungstueckeFile = new File("Kleidungsstuecke.json");
            PrintWriter writer = new PrintWriter(KleidungstueckeFile);
            writer.println("[");
            Kleidungsstueck LetzesKleidungsstueck = kleidungsstuecke[kleidungsstuecke.length -1];
            for (Kleidungsstueck kleidungsstueck : kleidungsstuecke) {
                writer.println("{");
                WriteString(writer,"Name",kleidungsstueck.getAnlass(),false);
                WriteStringArray(writer,"Farbe",kleidungsstueck.getFarbe(),false);
                WriteString(writer,"Groesse",kleidungsstueck.getGroesse(),false);
                WriteStringArray(writer,"Material",kleidungsstueck.getMaterial(),false);
                WriteString(writer,"Marke",kleidungsstueck.getMarke(),false);
                WriteString(writer,"Anlass",kleidungsstueck.getAnlass(),false);
                WriteString(writer,"Wetter",kleidungsstueck.getWetter(),false);
                WriteString(writer,"BildDateiPfad",kleidungsstueck.getBildDateiPfad(),false);
                WriteInteger(writer,"KleidungsID",kleidungsstueck.getKleidungsID(),true);
                if (kleidungsstueck.equals(LetzesKleidungsstueck))
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            // Logger da e.printStackTrace() Warungen ausgeworfen hat
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    // Oberteil Writer
    public void OberteilWriter(Oberteil[] oberteile)
    {
        try
        {
            File OberteilFile = new File("Oberteil.json");
            PrintWriter writer = new PrintWriter(OberteilFile);
            writer.println("[");
            Oberteil LetzeKopfbedeckung = oberteile[oberteile.length -1];
            for (Oberteil oberteil : oberteile) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",oberteil.getKleidungsID(),false);
                WriteInteger(writer,"AermelLaenge",oberteil.getAermelLaenge(),false);
                WriteString(writer,"Schnitt",oberteil.getSchnitt(),true);
                if (oberteil.equals(LetzeKopfbedeckung))
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }
    //Writer für die Ausprägungen von Oberteil
    public void hemdWriter(Hemd[] hemden)
    {
        try
        {
            File HemdFile = new File("Hemden.json");
            PrintWriter writer = new PrintWriter(HemdFile);
            writer.println("[");
            Hemd LetztesHemd = hemden[hemden.length -1];
            for (Hemd hemd : hemden) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",hemd.getKleidungsID(),false);
                WriteString(writer,"KragenArt",hemd.getKragenArt(),false);
                WriteString(writer,"KnopfMaterial",hemd.getKnopfMaterial(),true);
                if (hemd.equals(LetztesHemd))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        } catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void pulloverWriter(Pullover[] pullover)
    {
        try
        {
            File PulloverFile = new File("Pullover.json");
            PrintWriter writer = new PrintWriter(PulloverFile);
            writer.println("[");
            Pullover LetzterPullover = pullover[pullover.length -1];
            for (Pullover pulli : pullover) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",pulli.getKleidungsID(),false);
                WriteString(writer,"AusschnitArt",pulli.getAusschnitArt(),false);
                WriteString(writer,"Muster",pulli.getMuster(),false);
                WriteString(writer,"Strickart",pulli.getStrickArt(),true);
                if (pulli.equals(LetzterPullover))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        } catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void TShirtWriter(TShirt[] tShirts)
    {
        try
        {
            File TShirtFile = new File("TShirts.json");
            PrintWriter writer = new PrintWriter(TShirtFile);
            writer.println("[");
            TShirt LetztesTShirt = tShirts[tShirts.length -1];
            for (TShirt tShirt : tShirts) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",tShirt.getKleidungsID(),false);
                WriteString(writer,"AusschnitArt",tShirt.getAusschnitArt(),false);
                WriteString(writer,"Motiv",tShirt.getMotiv(),true);
                if (tShirt.equals(LetztesTShirt))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void SweatShirtWriter(SweatShirt[] sweatShirts)
    {
        try
        {
            File SweatShirtFile = new File("SweatShirts.json");
            PrintWriter writer = new PrintWriter(SweatShirtFile);
            writer.println("[");
            SweatShirt LetztesSweatShirt = sweatShirts[sweatShirts.length -1];
            for (SweatShirt sweatShirt : sweatShirts) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",sweatShirt.getKleidungsID(),false);
                WriteBoolean(writer,"HatKapuzen",sweatShirt.isHatKaputze(),false);
                WriteBoolean(writer,"HatTasche",sweatShirt.isHatTasche(),true);
                if (sweatShirt.equals(LetztesSweatShirt))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void PoloWriter(Polo[] polos)
    {
        try
        {
            File PoloFile = new File("Polos.json");
            PrintWriter writer = new PrintWriter(PoloFile);
            writer.println("[");
            Polo LetztesPolo = polos[polos.length -1];
            for (Polo polo : polos) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",polo.getKleidungsID(),false);
                WriteString(writer,"AusschnitArt",polo.getAusschnitArt(),false);
                WriteInteger(writer,"AnzahlKnopfe",polo.getAnzahlKnopfe(),false);
                WriteString(writer,"Muster",polo.getMuster(),true);

                if (polo.equals(LetztesPolo))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void topWriter(Top[] tops)
    {
        try
        {
            File TopFile = new File("Tops.json");
            PrintWriter writer = new PrintWriter(TopFile);
            writer.println("[");
            Top LetztesTop = tops[tops.length -1];
            for (Top top : tops) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",top.getKleidungsID(),false);
                WriteString(writer,"AusschnitArt",top.getAusschnitArt(),false);
                WriteString(writer,"TraegerArt",top.getTraegerArt(),true);
                if (top.equals(LetztesTop))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void jackeWriter(Jacke[] jacken)
    {
        try
        {
            File JackeFile = new File("Jacken.json");
            PrintWriter writer = new PrintWriter(JackeFile);
            writer.println("[");
            Jacke LetzteJacke = jacken[jacken.length -1];
            for (Jacke jacke : jacken) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",jacke.getKleidungsID(),false);
                WriteString(writer,"VerschlussArt",jacke.getVerschlussArt(),false);
                WriteBoolean(writer,"IstWasserdicht",jacke.isIstWasserdicht(),false);
                WriteString(writer,"FutterMaterial",jacke.getFutterMaterial(),true);
                if (jacke.equals(LetzteJacke))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }
    //Kopfbedeckung Writer und Auspraegungen
    public void kopfbedeckungWriter(Kopfbedeckung[] kopfbedeckungen) {
        try
        {
            File KopfbedeckungFile = new File("Kopfbedeckungen.json");
            PrintWriter writer = new PrintWriter(KopfbedeckungFile);
            writer.println("[");
            Kopfbedeckung LetzeKopfbedeckung = kopfbedeckungen[kopfbedeckungen.length -1];
            for (Kopfbedeckung kopfbedeckung : kopfbedeckungen) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",kopfbedeckung.getKleidungsID(),false);
                WriteBoolean(writer,"HatSchirm",kopfbedeckung.getHatSchirm(),false);
                WriteBoolean(writer,"BedecktGesicht",kopfbedeckung.getBedecktGesicht(),true);
                if (kopfbedeckung.equals(LetzeKopfbedeckung))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void cappeWriter(Cappe[] cappen)
    {
        try
        {
            File CappeFile = new File("Cappes.json");
            PrintWriter writer = new PrintWriter(CappeFile);
            writer.println("[");
            Cappe LetzteCappe = cappen[cappen.length -1];
            for (Cappe cappe : cappen) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",cappe.getKleidungsID(),false);
                WriteBoolean(writer,"SchirmGekrummt",cappe.isSchrimGekruemt(),false);
                WriteString(writer,"VerschlussArt",cappe.getVerschlussaArt(),true);
                if (cappe.equals(LetzteCappe))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void hutWriter(Hut[] huete)
    {
        try
        {
            File HutFile = new File("Huete.json");
            PrintWriter writer = new PrintWriter(HutFile);
            writer.println("[");
            Hut LetzterHut = huete[huete.length -1];
            for (Hut hut : huete) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",hut.getKleidungsID(),false);
                WriteInteger(writer,"Hoehe",hut.getHoehe(),false);
                WriteString(writer,"From",hut.getForm(),false);
                WriteBoolean(writer,"istSteif",hut.isIstSteif(),false);
                WriteBoolean(writer,"HatBand",hut.isHatBand(),true);
                if (hut.equals(LetzterHut))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void muetzeWriter(Muetze[] muetzen)
    {
        try
        {
            File MuetzeFile = new File("Muetzen.json");
            PrintWriter writer = new PrintWriter(MuetzeFile);
            writer.println("[");
            Muetze LetzteMuetze = muetzen[muetzen.length -1];
            for (Muetze muetze : muetzen) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",muetze.getKleidungsID(),false);
                WriteString(writer,"Stil",muetze.getStil(),false);
                WriteBoolean(writer,"HatUmschlag",muetze.isHatUmschlag(),true);
                if (muetze.equals(LetzteMuetze))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void sturmhaubeWriter(Sturmhaube[] sturmhauben)
    {
        try
        {
            File SturmhaubeFile = new File("Sturmhauben.json");
            PrintWriter writer = new PrintWriter(SturmhaubeFile);
            writer.println("[");
            Sturmhaube LetzteSturmhaube = sturmhauben[sturmhauben.length -1];
            for (Sturmhaube sturmhaube : sturmhauben) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",sturmhaube.getKleidungsID(),false);
                WriteString(writer,"StrickArt",sturmhaube.getStrickArt(),false);
                WriteString(writer,"AugenAuschnittArt",sturmhaube.getAugenAusschnitsArt(),true);
                if (sturmhaube.equals(LetzteSturmhaube))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void unterteilWriter(Unterteil[] unterteile)
    {
        try
        {
            File UnterteilFile = new File("Unterteile.json");
            PrintWriter writer = new PrintWriter(UnterteilFile);
            writer.println("[");
            Unterteil LetzesUnterteil = unterteile[unterteile.length -1];
            for (Unterteil unterteil : unterteile) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",unterteil.getKleidungsID(),false);
                WriteInteger(writer,"AnzahlTaschen",unterteil.getAnzahlTaschen(),false);
                WriteInteger(writer,"Laenge",unterteil.getLaenge(),true);
                if (unterteil.equals(LetzesUnterteil))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void hoseWriter(Hose[] hosen)
    {
        try
        {
            File HoseFile = new File("Hosen.json");
            PrintWriter writer = new PrintWriter(HoseFile);
            writer.println("[");
            Hose LetzteHose = hosen[hosen.length -1];
            for (Hose hose : hosen) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",hose.getKleidungsID(),false);
                WriteBoolean(writer,"HatDoppeltesKnie",hose.isHatDoppeltesKine(),false);
                WriteBoolean(writer,"HatFalten",hose.isHatFalten(),false);
                WriteString(writer,"Schnitt",hose.getSchnitt(),false);
                WriteString(writer,"HatGurtelschlaufen",hose.getArtDerHose(),true);
                if (hose.equals(LetzteHose))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void rockWriter(Rock[] rocke)
    {
        try
        {
            File RockFile = new File("Roecke.json");
            PrintWriter writer = new PrintWriter(RockFile);
            writer.println("[");
            Rock LetzterRock = rocke[rocke.length -1];
            for (Rock rock : rocke) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",rock.getKleidungsID(),false);
                WriteString(writer,"BundDetails",rock.getBundDetails(),false);
                WriteInteger(writer,"WeiteInCM",rock.getWeiteInCM(),false);
                WriteString(writer,"Art",rock.getArt(),true);
                if (rock.equals(LetzterRock))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void schuheWriter(Schuhe[] schuhe)
    {
        try
        {
            File SchuheFile = new File("Schuhe.json");
            PrintWriter writer = new PrintWriter(SchuheFile);
            writer.println("[");
            Schuhe LetzerSchuh = schuhe[schuhe.length -1];
            for (Schuhe Schuh : schuhe) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",Schuh.getKleidungsID(),false);
                WriteString(writer,"SolenMaterial",Schuh.getSolenMaterial(),false);
                WriteString(writer,"VerschlussTyp",Schuh.getVerschlussTyp(),true);
                if (Schuh.equals(LetzerSchuh))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void sneakerWriter(Sneaker[] sneaker)
    {
        try
        {
            File SneakerFile = new File("Sneaker.json");
            PrintWriter writer = new PrintWriter(SneakerFile);
            writer.println("[");
            Sneaker LetzterSneaker = sneaker[sneaker.length -1];
            for (Sneaker schuh : sneaker) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",schuh.getKleidungsID(),false);
                WriteBoolean(writer,"Colaboration",schuh.isColaboration(),false);
                WriteString(writer,"Technolgie",schuh.getTechnologie(),true);
                if (schuh.equals(LetzterSneaker))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void stiefelWriter(Stiefel[] stiefel)
    {
        try
        {
            File StiefelFile = new File("Stiefel.json");
            PrintWriter writer = new PrintWriter(StiefelFile);
            writer.println("[");
            Stiefel LetzterStiefel = stiefel[stiefel.length -1];
            for (Stiefel schuh : stiefel) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",schuh.getKleidungsID(),false);
                WriteInteger(writer,"SchafthheInCM",schuh.getAbsatzGroesse(),false);
                WriteString(writer,"Art",schuh.getArt(),false);
                WriteString(writer,"Muster",schuh.getMuster(),true);
                if (schuh.equals(LetzterStiefel))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

public void kleidWriter(Kleid[] kleider) {
        try
        {
            File KleidFile = new File("Kleid.json");
            PrintWriter writer = new PrintWriter(KleidFile);
            writer.println("[");
            Kleid LetzesKleide = kleider[kleider.length -1];
            for (Kleid kleid : kleider) {
                writer.println("{");
                WriteString(writer,"AuschnittArt",kleid.getAuschnitArt(),false);
                WriteString(writer,"Schnitt",kleid.getSchnitt(),false);
                WriteInteger(writer,"LangeInCM",kleid.getLangeInCM(),false);
                WriteBoolean(writer,"HatArmel",kleid.isHatAermel(),true);
                if (kleid.equals(LetzesKleide))
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
}

}
