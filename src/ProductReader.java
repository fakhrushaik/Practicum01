import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                System.out.printf("%-10s %-15s %-30s %-10s%n", "ID#", "Name", "Description", "Cost");
                System.out.println("===============================================================");
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(", ");
                    System.out.printf("%-10s %-15s %-30s %-10s%n", data[0], data[1], data[2], data[3]);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        }
    }
}
