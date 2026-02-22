package core.basesyntax.service.writer;

import java.nio.file.Files;
import java.nio.file.Path;


public class FileWriterImpl implements FileWriter {
  @Override
  public void write(String data, String filePath) {
    if (data == null || filePath == null) {
      throw new IllegalArgumentException("Data or file path can't be null");
    }
    try {
      Files.write(Path.of(filePath), data.getBytes());
    } catch (Exception e) {
      throw new RuntimeException("Can't write file: " + filePath, e);
    }
  }
}
