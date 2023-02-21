import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFile {
    public void fileWriter (String testResult){
        LocalDateTime now = LocalDateTime.now();
        try {
            FileWriter myWriter = new FileWriter("Benchmark_IPSENH"+"_"+now+".txt");
            myWriter.write(testResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
