import java.util.*;

public class StringCompress {

  private static String compress(String input) {

      String output = "";
      // iterate with nested loops, set 1st counter = 2nd counter
      for (int i = 0; i < input.length(); i++) {
        output += input.charAt(i);
        int count = 1;
        // first while loop argument has to be FIRST otherwise OutofBoundsException
        while ((i < input.length() - 1) && (input.charAt(i) == input.charAt(i + 1))) {
          count++;
          i++;
        }
        output += count;
        //System.out.println(i + " iteration");
      }

      // need to check if any benefit, otherwise notify and return original string
      if (output.length() >= input.length()) {
        System.out.println("No space saved or benefit to compression. Printing original String.");
        return input;
      } else {
        return output;
      }
  }

  public static void main(String[] args) {
    System.out.println("Enter a String and this program will compress it where characters repeat");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    System.out.println(compress(input));
  }
}
