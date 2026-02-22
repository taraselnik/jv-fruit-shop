package core.basesyntax.service.writer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        if (data == null || filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("Data or file path can't be null");
        }
        try {
            Path path = Path.of(filePath);
            Files.createDirectories(path.getParent());
            Files.write(path, data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Can't write file: " + filePath, e);
        }
    }
}
