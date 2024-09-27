import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try {
            // Read all lines from the input file
            List<String> lines = Files.readAllLines(inputFile.toPath());

            // Create a FileWriter to write to the output file
            FileWriter fileWriter = new FileWriter(outputFile);

            for (String line : lines) {
                // Remove extra spaces but preserve single spaces and line breaks
                String processedLine = line.trim().replaceAll("\\s+", "");
                fileWriter.write(processedLine + System.lineSeparator());
            }

            // Close the FileWriter to finalize the file
            fileWriter.close();
            System.out.println("The short version of the file is created successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
