import java.util.*;

public class Palindrome {

  private static boolean isPalindromeLLMethod(LinkedList input) {
    // LinkedList method, iterate up and down LinkedList?
    int size = input.size();

    int i = 0;
    int k = size - 1;

    while(i < k) {
      if (input.get(i) != input.get(k)) {
        return false;
      }
      i++;
      k--;
    }
    return true;
  }

  private static boolean isPalindromeStringMethod(String input) {
    //Non LinkedList method, iterate up and down String
    int i = 0;
    int k = input.length() - 1;
    while(i < k) {
      if (input.charAt(i) != input.charAt(k)) {
        return false;
      }
      i++;
      k--;
    }
    return true;

  }

  public static void main(String[] args) {

    LinkedList<Character> charList = new LinkedList<Character>();
    charList.add('3');
    charList.add('2');
    charList.add('1');
    charList.add('2');
    charList.add('3');
    //charList.add('1');

  //   System.out.println("Palindrome Linked List determines if a user inputted String is a Palindrome");
  //   System.out.println("Type in a String below, this is case sensitive");
  //   Scanner scanner = new Scanner(System.in);
  //   String input = scanner.nextLine();
  //
    if (isPalindromeLLMethod(charList)) {
      System.out.println("YES - Palindrome!");
    } else {
      System.out.println("NO - Not a palindrome :-(");
    }
  }
}
