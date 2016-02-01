import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("d:\\in2.txt");
        FileWriter fileWriter = new FileWriter("d:\\out2.txt");

        int ch;
        while ((ch = fileReader.read()) != -1) {
            System.out.print((char) ch);
            fileWriter.write(ch);
        }

        fileReader.close();
        fileWriter.close();
    }
}
