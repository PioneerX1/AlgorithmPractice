import java.util.*;

public class MissingParen {

  // THIS IS OVERKILL
  // You don't really need a Stack to return the missing parentheses here.
  // Just read in each char, if its a starting paren, increment startCount
  // If it's an ending paren, increment endCount
  // return the appropriate response

  private static char getMissingParen(String exp) {

    Stack<Character> parenStack = new Stack<Character>();

    for(int i = 0; i < exp.length(); i ++) {
      //parenStack.add(exp.charAt(i));
      if(exp.charAt(i) == '(' || exp.charAt(i) == ')') {
        parenStack.push(exp.charAt(i));
      }
    }

    int startParen = 0;
    int endParen = 0;

    for(Character charStack : parenStack) {
      if (charStack == '(') {
        startParen++;
      } else {
        endParen++;
      }
    }

    if (startParen > endParen) {
      return ')';
    } else if (endParen > startParen) {
      return '(';
    } else {
      return '@';
    }


  }

  public static void main(String[] args) {
    System.out.println("MissingParen reads in an expression and returns the missing parentheses.");
    System.out.println("---Enter an expression below---");

    Scanner scanner = new Scanner(System.in);

    String exp = scanner.nextLine();
    char missingParen = getMissingParen(exp);
    System.out.println("Missing parentheses is: " + missingParen);

  }
}
