import java.io.*;

public class CopyBytes {

    public static void main(String[] args) throws IOException {

        File file = new File("d:\\in1.txt");
        File fileOutput = new File("d:\\out1.txt");

        byte[] array = readFromFile(file);
        writeToFile(array, fileOutput);

        /*for (byte b : array) {
            System.out.println(b);
        }*/
    }

    private static byte[] readFromFile(File file) throws IOException {

        try (FileInputStream inputStream = new FileInputStream(file)) {
            int file_length = (int) file.length();
            byte[] array = new byte[file_length];

            int value;
            int i = 0;
            while ((value = inputStream.read()) != -1) {
                System.out.print((char) value);
                array[i++] = (byte) value;
            }

            return array;
        }
    }

    private static void writeToFile(byte[] array, File file) {

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);

            for (byte b : array) {
                outputStream.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
