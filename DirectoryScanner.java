import java.io.IOException;
import java.nio.file.*;

/**
 * Scans directories recursively.
 */
public class DirectoryScanner {

    public static void scan(Path directory) throws IOException {
        Files.walk(directory)
                .filter(Files::isRegularFile)
                .forEach(System.out::println);
    }
}
