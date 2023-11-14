package _06_05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileReaderExercise {

  // This method should return the first line of BufferedReaderVsScanner.txt.
  String getFirstLine() {
    String firstLine = "";

    try (Scanner scanner =
        new Scanner(new File("src/main/java/_06_05/BufferedReaderVsScanner.txt")); ) {
      firstLine = scanner.nextLine();
    } catch (IOException e) {
      System.out.printf("Exception reading the file: %s.", e.getMessage());
    }
    return firstLine;
  }

  // This method should return all the content of BufferedReaderVsScanner.txt
  // as a single String.
  String getWholeFile() {
    String wholeFile = "";

    try (BufferedReader reader =
        new BufferedReader(new FileReader("src/main/java/_06_05/BufferedReaderVsScanner.txt"))) {
      wholeFile = reader.lines().collect(Collectors.joining(""));
    } catch (IOException e) {
      System.out.printf("Exception reading the file: %s.", e.getMessage());
    }

    return wholeFile;
  }
}
