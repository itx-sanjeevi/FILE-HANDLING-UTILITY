import java.io.*;
import java.nio.file.*;
import java.util.logging.*;

/**
 * FileManager handles core file operations using NIO and buffering.
 */
public class FileManager {

    private static final Logger logger = Logger.getLogger(FileManager.class.getName());

    static {
        try {
            FileHandler handler = new FileHandler("logs/app.log", true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
        } catch (IOException e) {
            System.err.println("Logging setup failed");
        }
    }

    public static void writeFile(Path path, String content) throws IOException {
        Files.writeString(path, content,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);
        logger.log(Level.INFO, "File written: {0}", path);
    }

    public static void readFile(Path path) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.lines().forEach(System.out::println);
        }
        logger.log(Level.INFO, "File read: {0}", path);
    }

    public static void copyFile(Path source, Path target) throws IOException {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        logger.log(Level.INFO, "File copied from {0} to {1}", new Object[]{source, target});
    }

    public static void moveFile(Path source, Path target) throws IOException {
        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        logger.log(Level.INFO, "File moved from {0} to {1}", new Object[]{source, target});
    }

    public static void deleteFile(Path path) throws IOException {
        Files.deleteIfExists(path);
        logger.log(Level.INFO, "File deleted: {0}", path);
    }
}
