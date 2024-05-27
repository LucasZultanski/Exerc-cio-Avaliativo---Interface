import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String filename = "log.txt";
        if (!Files.exists(Paths.get(filename))) {
            Files.createFile(Paths.get(filename));
        }

        Logger loggerConsole = LoggerFactory.onConsole();
        loggerConsole.log(Level.DEBUG, "Mensagem de debug");
        loggerConsole.log(Level.WARNING, "Mensagem de warning");
        loggerConsole.log(Level.ERROR, "Mensagem de erro");

        Logger loggerFile = LoggerFactory.onFile(filename);
        loggerFile.log(Level.DEBUG, "Mensagem de debug");
        loggerFile.log(Level.WARNING, "Mensagem de warning");
        loggerFile.log(Level.ERROR, "Mensagem de erro");
    }
}