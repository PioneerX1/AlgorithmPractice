import java.util.*;

public class ReplaceSpaces {

  private static String replaceSpaces(String input) {

    String output = "";
    for(int i = 0; i < input.length(); i++) {
      if(input.charAt(i) == ' ') {
        output += "%20";
      } else {
        output += input.charAt(i);
      }
    }
    return output;
  }


  public static void main(String[] args) {
    System.out.println("Enter a string below and this program will replace all the spaces with %20");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    System.out.println(replaceSpaces(input));
  }
}
