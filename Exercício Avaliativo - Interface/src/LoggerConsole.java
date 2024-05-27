import java.time.LocalDateTime;

public class LoggerConsole implements Logger {
    @Override
    public void log(Level level, String message) {
        LocalDateTime now = LocalDateTime.now();
        String date = String.format("%02d/%02d/%04d %02d:%02d:%02d", now.getDayOfMonth(), now.getMonthValue(), now.getYear(), now.getHour(), now.getMinute(), now.getSecond());
        String color = "";
        switch (level) {
            case DEBUG:
                color = "\u001B[32m"; // verde
                break;
            case WARNING:
                color = "\u001B[33m"; // amarelo
                break;
            case ERROR:
                color = "\u001B[31m"; // vermelho
                break;
        }
        System.out.println(color + "[" + date + "] [" + level + "] " + message + "\u001B[0m"); // reset color
    }
}