import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PersonReader
{
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        //chooser.setCurrentDirectory(new File("."));
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            Path file = selectedFile.toPath();

            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String record;
                System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("==========================================================");

                while ((record = reader.readLine()) != null) {
                    String[] fields = record.split(", ");
                    System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", fields[0], fields[1], fields[2], fields[3], fields[4]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
