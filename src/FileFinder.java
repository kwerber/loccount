import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileFinder {

  public static List<Path> findCodeFiles(Path searchDirectory) throws IOException {
    var files = findFilesRecursively(searchDirectory);
    return filterCodeFiles(files);
  }

  private static List<Path> findFilesRecursively(Path searchDirectory) throws IOException {
    try (var fileStream = Files.walk(searchDirectory)) {
      return fileStream.toList();
    }
  }

  private static List<Path> filterCodeFiles(List<Path> files) {
    return files.stream()
        .filter(FileFinder::isCodeFile)
        .toList();
  }

  private static boolean isCodeFile(Path filePath) {
    var fileName = filePath.getFileName().toString();
    return fileName.endsWith(".java");
  }

}
