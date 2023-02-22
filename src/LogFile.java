import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFile {
    static FileWriter myWriter;
    public static void fileWriter(String testResult){
        LocalDateTime now = LocalDateTime.now();
        String date = now.getYear()+"_"+now.getMonth()+"_"+now.getDayOfWeek();
        try {
            myWriter = new FileWriter("Benchmark_IPSENH"+"_"+date+".txt");
            myWriter.append(testResult);
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
