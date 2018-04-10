
// Two methods for determining if a string has ALL unique characters or not
// 1. unique1() uses an extra data structure (HashMap) but is faster, has O(n) complexity
// 2. unique2() only uses one data structure but takes longer, has O(n^n-1) complexity

import java.util.*;

public class UniqueChars {

  private static String unique1(String input) {
    for(int i = 0; i < input.length() - 1; i++) {
      for(int k = i + 1; k < input.length(); k++) {
        if(input.charAt(i) == input.charAt(k)) {
          return "NO, duplicates present. i: " + input.charAt(i) + " k: " + input.charAt(k);
        }
      }
    }

    return "YES, all unique chars!";
  }

  // private static String unique2(String input) {
  //
  // }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("UniqueChars reads one string of input and outputs YES if it contains all unique chars or NO if it does not");
    String input = scanner.nextLine();

    System.out.println(unique1(input));

  }

}
