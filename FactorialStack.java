import java.util.*;

class FactorialStack {

  private static int factorial(int input) {
      Stack<Integer> fs = new Stack<Integer>();
      int j = 1;
      int answer = input;
      while (j < input) {
        fs.push(j++);
      }
      while (fs.size() > 1) {
        answer *= fs.pop();
      }

      return answer;
  }

  public static void main(String[] args) {
    System.out.println("This program computes a factorial from user input using a stack data structure.");
    System.out.println("Enter a number: ");
    Scanner scanner = new Scanner(System.in);
    int input = Integer.parseInt(scanner.nextLine());

    System.out.println("Factorial of " + input + " is " + factorial(input));

  }
}
