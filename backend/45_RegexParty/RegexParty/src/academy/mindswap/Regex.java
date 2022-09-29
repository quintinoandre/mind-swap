package academy.mindswap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Regex {
  private Regex() {
  }

  public static void check(String string, String regex) {
    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    final Matcher matcher = pattern.matcher(string);

    while (matcher.find()) {
      System.out.println("Full match: " + matcher.group(0));

      for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
      }
    }
  }
}
