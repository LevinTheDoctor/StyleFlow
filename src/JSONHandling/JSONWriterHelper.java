package JSONHandling;
import java.io.PrintWriter;

public class JSONWriterHelper {
    public static void Komma(PrintWriter writer, Boolean LetztesElement)
    {
        if (!LetztesElement)
        {
            writer.println(",");
        }
        else
        {
            writer.println("");
        }
    }
    public static void WriteBoolean (PrintWriter writer,String name, Boolean Wert,Boolean LetztesElement)
    {
        writer.print("\""+ name +"\":" + Wert);
        Komma(writer,LetztesElement);
    }

    public static void WriteInteger (PrintWriter writer,String name, Integer Wert, Boolean LetztesElement)
    {
        writer.print("\""+ name +"\":" + Wert);
        Komma(writer,LetztesElement);
    }
    public static void WriteString (PrintWriter writer,String name, String Wert, Boolean LetztesElement)
    {
        writer.print("\""+ name +"\": \"" + Wert + "\"");
        Komma(writer,LetztesElement);
    }

    public static void WriteStringArray (PrintWriter writer,String name, String[] Werte, Boolean LetztesElementBool)
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
}