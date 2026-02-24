package Logik;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BildHelper {

    public static String BildRichtigerPfad(String RelativerPfad)
    {
        return Paths.get(System.getProperty("user.dir"),RelativerPfad).toString();
    }

    // Verschieben von Bild zu Inventory und Json Speicher in Inventory
    public static String BildBewegen(String BildPfadString)
    {
        if (BildPfadString == null || BildPfadString.isBlank()) {
            return "";
        }
        Path OrginalBildPfad = Paths.get(BildPfadString);
       String BildName = OrginalBildPfad.getFileName().toString();
       Path ProgrammPfad = Paths.get(System.getProperty("user.dir"), "Inventory");
       Path PfadMitBild = Paths.get(ProgrammPfad.toString(), BildName);
        try {
            // wenn Ordner nicht existiert
            if (!Files.exists(ProgrammPfad))
            {
                Files.createDirectories(ProgrammPfad);
            }
            // Bilder mit selben datei namen werden überschreiben
            Files.copy(OrginalBildPfad, PfadMitBild, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // ist von IntelliJ, weil copy eine Exception wirft
            throw new RuntimeException(e);
        }
        // relativer Pfad, sodass es auch auf anderen Computern gefunden werden kann
        return "Inventory/" + BildName;
    }


    public static boolean IsFarbeHell(String FarbeInHexCode)
    {
        // basierend auf Helligkeitsformel für RGB, die ich online gefunden habe: http://www.fseitz.de/blog/index.php?/archives/112-Helligkeit-von-Farben-des-RGB-Farbraums-berechnen.html
        int[] rgb = HexZuRGB(FarbeInHexCode);
        Double Helligkeit = Math.sqrt(0.299 * Math.pow(rgb[0],2) + 0.587 * Math.pow(rgb[1],2) + 0.114 * Math.pow(rgb[2],2));
        return Helligkeit > 128;
    }

    public static String HexZuRGBString(String FarbeInHexCode)
    {
        int[] rgbIntArray = HexZuRGB(FarbeInHexCode);
        String rgbString = "";
        for (int element : rgbIntArray) {
            rgbString += Integer.toString(element);
        }
        return rgbString;
    }

    // nimmt die Substrings
    public static int[] HexZuRGB (String FarbeInHexCodeMitX)
    {
        String FarbeInHexCode = FarbeInHexCodeMitX.split("x")[1];
        String RinHex = FarbeInHexCode.substring(0,2);
        String GinHex = FarbeInHexCode.substring(2,4);
        String BinHex = FarbeInHexCode.substring(4,6);
        int R = HexZuDez(RinHex);
        int G = HexZuDez(GinHex);
        int B = HexZuDez(BinHex);
        return new int[]{R,G,B};
    }

    // ich will nicht mehr – das hat einfach funktioniert, aber ich habe es vorher nicht gefunden
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
