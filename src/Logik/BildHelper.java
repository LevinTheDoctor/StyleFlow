package Logik;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BildHelper {

    public static String BildRichtigerPfad(String RelativerPfad)
    {
        return Paths.get(System.getProperty("user.dir"),RelativerPfad).toString();
    }

    // Verschieben von Bild zu Inventory und Json Speicher in Inventory
    public static String BildBewegen(String BildPfadString)
    {
       Path OrginalBildPfad = Paths.get(BildPfadString);
       String BildName = OrginalBildPfad.getFileName().toString();
       Path ProgrammPfad = Paths.get(System.getProperty("user.dir"), "Inventory");
       Path PfadMitBild = Paths.get(ProgrammPfad.toString(), BildName);
        try {
            // wenn ordner nicht existir
            if (!Files.exists(ProgrammPfad))
            {
                Files.createDirectories(ProgrammPfad);
            }
            Files.copy(OrginalBildPfad, PfadMitBild);
        } catch (IOException e) {
            // ist von intellij weil copy ne exception schmeist
            throw new RuntimeException(e);
        }
        //relativer pfad so das es auch auf anderen computern gefunden werden kann
        return "Inventory/" + BildName;
    }


    public static boolean IsFarbeHell(String FarbeInHexCode)
    {
        // basierend auf helligkeitsformel für RGB hab ich online gefunden http://www.fseitz.de/blog/index.php?/archives/112-Helligkeit-von-Farben-des-RGB-Farbraums-berechnen.html
        int[] rgb = HexZuRGB(FarbeInHexCode);
        Double Helligkeit = Math.sqrt(0.299 * Math.pow(rgb[0],2) + 0.587 * Math.pow(rgb[1],2) + 0.114 * Math.pow(rgb[2],2));
        return Helligkeit > 128;
    }


    // nimmt die substrings
    public static int[] HexZuRGB (String FarbeInHexCode)
    {
        String RinHex = FarbeInHexCode.substring(0,2);
        String GinHex = FarbeInHexCode.substring(2,4);
        String BinHex = FarbeInHexCode.substring(4,6);
        int R = HexZuDez(RinHex);
        int G = HexZuDez(GinHex);
        int B = HexZuDez(BinHex);
        return new int[]{R,G,B};
    }

    // ich will nicht mehr das hat einfach gegangen aber ich habe es vorher nicht gefunden lol
    public static int HexZuDez (String Hex)
    {
        int countDurchgaenge = 0;
        int ValueDez = 0;
        for (int index = Hex.length()-1; index >= 0; index--){
            Hex.charAt(index);
            int vauleOfHexAtChar;
            // mit map
            switch (Hex.charAt(index)){

                case 'A':
                    vauleOfHexAtChar = 10;
                    break;
                case 'B':
                    vauleOfHexAtChar = 11;
                    break;
                case 'C':
                    vauleOfHexAtChar = 12;
                    break;
                case 'D':
                    vauleOfHexAtChar = 13;
                    break;
                case 'E':
                    vauleOfHexAtChar = 14;
                    break;
                case 'F':
                    vauleOfHexAtChar = 15;
                    break;
                default:
                    vauleOfHexAtChar = Character.getNumericValue(Hex.charAt(index));
            }
            ValueDez += vauleOfHexAtChar * Math.pow(16,countDurchgaenge);
            countDurchgaenge++;
        }
        return ValueDez;
    }
}
