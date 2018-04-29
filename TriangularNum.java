import java.util.*;

class TriangularNum {

  private static int triIt(int input) {
    int answer = 0;
    int j = input;
    while (j > 0) {
      answer += j--;
    }
    return answer;
  }

  private static int triRec(int input) {
    if (input == 1) {
      return input;
    }
    int answer = input + triRec(input - 1);
    return answer;
  }

  public static void main(String[] args) {
    System.out.println("This program calculates the nth term in a triangular number. You provide the height of the triangle and it outputs the total units of triangle.");
    System.out.println("It will return two results which should be the same, one from iterative approach, one from recursive approach.");
    System.out.print("Enter a number: ");
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();

    System.out.println("Iterative answer: " + triIt(input));
    System.out.println("Recursive anser: " + triRec(input));
  }
}
