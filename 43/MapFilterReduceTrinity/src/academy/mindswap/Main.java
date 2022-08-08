package academy.mindswap;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    String prayer = new StringBuilder()
        .append("Oh Lord, won't you buy me a trash Mercedes Benz\n")
        .append("My friends all drive trash Porsche's, I must make trash amends\n")
        .append("Worked hard all my trash lifetime, no help from my trash friends\n")
        .append("So Lord, won't you buy me a trash Mercedes Benz")
        .toString();

    System.out.println(Arrays.stream(prayer.split(" "))
        .filter(word -> !word.equals("trash"))
        .collect(Collectors.joining(" "))
        .toUpperCase());

    String prayer2 = "Oh Lord, won't you buy me a trash Mercedes Benz\n" +
        "My friends all drive trash Porsches, I must make trash amends\n" +
        "Worked hard all my trash lifetime, no help from my trash friends\n" +
        "So Lord, won't you buy me a trash Mercedes Benz";

    System.out.println("----------------------------------------------------------------");

    System.out.println(Arrays.stream(prayer2.split(" "))
        .filter(word -> !word.equals("trash"))
        .map(word -> word.toUpperCase())
        .reduce("", (acc, element) -> {
          String joiner = acc.equals("") ? "" : " ";

          return acc + joiner + element;
        }));
  }
}
