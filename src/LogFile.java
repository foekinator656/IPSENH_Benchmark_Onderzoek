import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class LogFile {

    static FileWriter myWriter;

    // TODO: All files that are made, should be made in a specific folder.
    public static void fileWriter(String testResult){
        LocalDateTime now = LocalDateTime.now();
        String date = String.format("%s_%s_%s", now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        String fileName = String.format("Benchmark_IPSENH_%s.txt", date);
        int value = 0;
        try {
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

            myWriter = new FileWriter(fileName);
            myWriter.append(testResult);
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}