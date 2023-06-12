import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileWrite {
    public static void WriteData(String[] array) {
try (FileWriter fw = new FileWriter(array[0], true)) 
{
String str = Arrays.toString(array);
fw.write(str);
fw.append('\n');
fw.flush();
} catch (IOException ex) {
System.out.println(ex.getMessage());
}
    }
}
