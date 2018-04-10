import java.util.*;

public class MaxSingleDigitsTwoOperators {

  private static int findMaxPossible(int[] operands) {

    int max = 0;

    for(int i = 0; i < operands.length; i++) {
      if (operands[i] == 1 || max == 1) {
        max += operands[i];
      } else if (operands[i] == 0 ||  max == 0) {
        max += operands[i];
      } else {
        max *= operands[i];
      }
    }

    return max;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a string of single-digit positive integers separated by spaces");
    String response = scanner.nextLine();
    String[] strNum = (response.split(" "));
    int[] operands = new int[strNum.length];


    for(int i = 0; i < strNum.length; i++) {
      operands[i] = Integer.parseInt(strNum[i]);
    }

    int maxPossible = findMaxPossible(operands);
    System.out.println("Max possible value is: " + maxPossible);

  }
}
