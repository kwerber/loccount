import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    var searchPath = ArgParser.getSearchPath(args);
    var files = FileFinder.findCodeFiles(searchPath);
    var countedFiles = FileAnalyzer.analyzeFiles(files);
    UI.outputResults(countedFiles);
  }

}