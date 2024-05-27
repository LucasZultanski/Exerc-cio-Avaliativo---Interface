import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class LoggerFile implements Logger {
    private String filename;

    public LoggerFile(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(Level level, String message) {
        try {
            LocalDateTime now = LocalDateTime.now();
            String date = String.format("%02d/%02d/%04d %02d:%02d:%02d", now.getDayOfMonth(), now.getMonthValue(), now.getYear(), now.getHour(), now.getMinute(), now.getSecond());
            String logMessage = String.format("[%s] [%s] %s%n", date, level, message);
            Files.write(Paths.get(filename), logMessage.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo");
            e.printStackTrace();
        }
    }
}