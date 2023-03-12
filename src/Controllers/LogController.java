package Controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class LogController {

    public static void fileWriter(String testResult){
        LocalDateTime now = LocalDateTime.now();
        String date = String.format("%s-%s-%s", now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        String folderName = "./Output";
        String fileName = String.format("%s/Benchmark-%s.txt", folderName, date);
        int value = 0;

        try {
            Files.createDirectories(Path.of(folderName));

            while (Files.exists(Path.of(fileName))) {
                value++;
                int lastIndex = fileName.lastIndexOf("(");
                if (lastIndex != -1) {
                    String prefix = fileName.substring(0, lastIndex);
                    fileName = String.format("%s(%d)", prefix, value);
                } else {
                    fileName = String.format("%s(%d)", fileName, value);
                }
            }

            FileWriter myWriter = new FileWriter(fileName);
            myWriter.append(testResult);
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}