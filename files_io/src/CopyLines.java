import java.io.*;

public class CopyLines {

    public static void main(String[] args) {

        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader("d:\\in3.txt"));
            writer = new BufferedWriter(new FileWriter("d:\\out3.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);

                String[] words = line.split(" ");
                for (String word : words) {
                    writer.write(word);
                    writer.newLine();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
