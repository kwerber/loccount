import java.util.List;

public class UI {

  public static void outputResults(List<CountedFile> files) {
    var totalLines = calculateTotalLineCount(files);
    var totalLinesOfCode = calculateTotalCodeLineCount(files);
    outputDetails(files);
    outputSummary(totalLines, totalLinesOfCode);
  }

  private static void outputDetails(List<CountedFile> files) {
    for (CountedFile file : files) {
      System.out.printf("%s %s %s%n", file.name(), file.lineCount(), file.codeLineCount());
    }
  }

  private static int calculateTotalLineCount(List<CountedFile> files) {
    return files.stream()
        .mapToInt(CountedFile::lineCount)
        .sum();
  }

  private static int calculateTotalCodeLineCount(List<CountedFile> files) {
    return files.stream()
        .mapToInt(CountedFile::codeLineCount)
        .sum();
  }

  private static void outputSummary(int totalLines, int totalLinesOfCode) {
    System.out.printf("%nTotal: %n");
    System.out.printf("  Lines: %s%n", totalLines);
    System.out.printf("  LOC:   %s%n", totalLinesOfCode);
  }

}
