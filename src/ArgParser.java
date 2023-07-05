import java.nio.file.Path;

public class ArgParser {

  public static Path getSearchPath(String[] args) {
    return Path.of(args[0]);
  }

}
