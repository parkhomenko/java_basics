import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new BufferedReader(new FileReader("d:\\in3.txt")));
//        scanner.useDelimiter(",");
        scanner.useLocale(Locale.ENGLISH);

        while (scanner.hasNextDouble()) {
            System.out.println(scanner.nextDouble());
        }

        scanner.close();
    }
}
