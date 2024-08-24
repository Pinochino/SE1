import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Excerixe1 {

    public static void main(String[] args) {
        try {
            String text = "Tran Dinh Hung" + "\n" +
                    "My class is 7C22";
            File file = new File("file.txt");

            FileWriter fileWriter = new FileWriter(file);

//            while (line = fileWriter)

            fileWriter.write(text.replaceAll(" ", ""));

            System.out.println(text.replaceAll(" ", ""));

            fileWriter.close();
            System.out.println(
                    "File is created successfully with the content.");

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
