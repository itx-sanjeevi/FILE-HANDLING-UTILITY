import java.io.*;
import java.nio.file.*;

/**
 * Performs memory-efficient search & replace on large files.
 */
public class FileSearchReplace {

    public static void replace(Path input, Path output,
                               String target, String replacement) throws IOException {

        try (BufferedReader reader = Files.newBufferedReader(input);
             BufferedWriter writer = Files.newBufferedWriter(output)) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.replace(target, replacement));
                writer.newLine();
            }
        }
    }
}
