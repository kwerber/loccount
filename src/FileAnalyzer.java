import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileAnalyzer {

  private static final String COMMENT_PREFIX = "//";

  public static List<CountedFile> analyzeFiles(List<Path> files) {
    return files.stream()
        .map(FileAnalyzer::analyzeFile)
        .toList();
  }

  public static CountedFile analyzeFile(Path filePath) {
    var fileName = filePath.toAbsolutePath().toString();
    var lines = readLinesOfFile(filePath);
    var lineCount = lines.size();
    var codeLineCount = countCodeLines(lines);
    return new CountedFile(fileName, lineCount, codeLineCount);
  }

  private static List<String> readLinesOfFile(Path filePath) {
    try {
      return Files.readAllLines(filePath);
    } catch (IOException e) {
      System.err.println("Failed to read file: " + filePath);
      e.printStackTrace();
      return Collections.emptyList();
    }
  }

  private static int countCodeLines(List<String> lines) {
    return (int) lines.stream()
        .map(String::trim)
        .filter(line -> !line.isBlank())
        .filter(line -> !line.startsWith(COMMENT_PREFIX))
        .count();
  }

}
