import java.util.*;

public class Permutation {

  private static String isPermutation(String input1, String input2) {
    if (input1.length() != input2.length()) {
      return "NO, not even correct length.";
    }

    // create and populate HashMap from first input string
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for(int i = 0; i < input1.length(); i++) {
      if (map.containsKey(input1.charAt(i))) {
        map.put(input1.charAt(i), map.get(input1.charAt(i)) + 1);
      } else {
        map.put(input1.charAt(i), 1);
      }
    }

    // compare this to either string length at end
    int zeroCount = 0;
    // decrement values in the same hashmap if values exist
    for(int i = 0; i < input2.length(); i++) {
      if (!map.containsKey(input2.charAt(i))) {
        return "NO, " + input2.charAt(i) + " only exists in first string.";
      } else if (map.get(input2.charAt(i)) < 1) {
        return "NO, " + input2.charAt(i) + " has extras in second string.";
      } else {
        map.put(input2.charAt(i), map.get(input2.charAt(i)) - 1);
          if (map.get(input2.charAt(i)) == 0) {
            zeroCount++;
          }
      }
    }

    // prob unnecessary since length of both strings are already compared?
    if (zeroCount != input1.length()) {
      return "NO";
    }

    return "YES";

  }


  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Permutation reads in two string inputs to see if one is a permutation of the other");
    System.out.print("----");
    System.out.println("Enter String 1: ");
    String input1 = scanner.nextLine();
    System.out.println("Enter String 2: ");
    String input2 = scanner.nextLine();

    System.out.println(isPermutation(input1, input2));
  }
}
