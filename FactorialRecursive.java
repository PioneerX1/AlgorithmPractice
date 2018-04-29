import java.util.*;

class FactorialRecursive {

  private static int factRecur(int input) {

    if (input == 1) {
      return input;
    }
    int answer = input * factRecur(input - 1);
    return answer;
  }

  public static void main(String[] args) {
    System.out.println("This program uses repeated recursive calls to the same function to calculate a factorial.");
    System.out.println("Enter a number: ");
    Scanner scanner = new Scanner(System.in);
    int input = Integer.parseInt(scanner.nextLine());

    System.out.println("The factorial of " + input + " is " + factRecur(input));
  }
}
