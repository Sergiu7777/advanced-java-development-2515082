package _07_05;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExercise {

  public static void main(String[] args) throws Exception {
    // Create a new empty file called example.txt inside folderA
    Path aPath = Paths.get("src/main/java/_07_05/folderA/example.txt");
    if (Files.notExists(aPath)) {
      Files.createFile(aPath);
    }

    // Copy the file to folderB
    Path bPath = Paths.get("src/main/java/_07_05/folderB/example.txt");
    if (Files.notExists(bPath)) {
      Files.copy(aPath, bPath);
    }

    // List the contents of folderB to check that your file is in there
    Files.list(Paths.get("src/main/java/_07_05/folderB")).forEach(System.out::println);
  }
}
