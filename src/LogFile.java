import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogFile {

    static FileWriter myWriter;

    public static void fileWriter(String testResult){
        LocalDateTime now = LocalDateTime.now();
        String date = String.format("%s_%s_%s", now.getYear(), now.getMonthValue(), now.getDayOfMonth());

        try {
            myWriter = new FileWriter(String.format("Benchmark_IPSENH_%s.txt", date));
            myWriter.append(testResult);
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}