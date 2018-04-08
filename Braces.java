
public class Braces {

  private static String[] balancedBraces(String[] bracesArray) {
    String[] responses = new String[bracesArray.length];
    // outer loop string in the array
    for(int i = 0; i < bracesArray.length; i++) {
      // System.out.println("-------");
      // System.out.println(i + " iteration");
      // System.out.println("-------");

      String bracesText = bracesArray[i];
      // initial validators
      // if first char in string is an ending brace
      if(findBraceType(bracesText.charAt(0)).equals("ENDING")) {
        //System.out.println(i + " ENDING brace in first slot");
        responses[i] = "NO";
        continue;
      }
      // if last char in string is a starting brace
      if(findBraceType(bracesText.charAt(bracesText.length() - 1)).equals("STARTING")) {
        //System.out.println(i + " STARTING brace in last slot");
        responses[i] = "NO";
        continue;
      }

      // there should NEVER be more end braces than start braces,
      // enabling this should ensure pointers don't go out of bounds
      int counterStartBrace = 0;
      int counterEndBrace = 0;
      // temp array stack with pointer
      // array must be full length for cases like: {{{((([[[}
      char[] tempStack = new char[bracesText.length()];
      int stackPointer = 0;

      // inner loop for each char in string
      for(int j = 0; j < bracesText.length(); j++) {
        if (findBraceType(bracesText.charAt(j)).equals("STARTING")) {
          tempStack[stackPointer] = bracesText.charAt(j);
          //System.out.println("Added to tempStack: " + tempStack[j]);
          stackPointer++;
          counterStartBrace++;
        } else if (findBraceType(bracesText.charAt(j)).equals("ENDING")) {
          counterEndBrace++;
          //System.out.println("tempStack element compared: " + stackPointer);
          if (endToStartMatch(tempStack[stackPointer - 1], bracesText.charAt(j))) {
            stackPointer--;
          } else {
            //System.out.println(i + " line 45");
            responses[i] = "NO";
            break;
          }
        } else {
          // do nothing, we don't care about non-brace chars
        }
        // make sure there are not more ending braces than starting braces
        if (counterEndBrace > counterStartBrace) {
          //System.out.println(i + " more ending than starting braces");
          responses[i] = "NO";
          break;
        }
        // no problems, all good
        responses[i] = "YES";
      }
    }
    return responses;
  }

  private static boolean endToStartMatch(char start, char end) {
    //System.out.println("start brace: " + start + " end brace: " + end);
    if (start == '{' && end == '}') {
      return true;
    } else if (start == '(' && end == ')') {
      return true;
    } else if (start == '[' && end == ']') {
      return true;
    } else {
      return false;
    }
  }

  private static String findBraceType(char brace) {
    if (brace == '{' || brace == '(' || brace == '[') {
      return "STARTING";
    } else if (brace == '}' || brace == ')' || brace == ']') {
      return "ENDING";
    } else {
      return "NEITHER";
    }
  }

  public static void main(String [] args) {
    // Are these braces balanced?
    String braces1 = "{([])}";  // yes
    String braces2 = "{}[]()";  // yes
    String braces3 = "{[}]()";  // no, one container reaches outside its outer one
    String braces4 = "({}[])";  // yes
    String braces5 = "{([)}()";  // no, there is an extra start bracket
    String braces6 = "{([])[]}";  // yes

    String[] bracesArray = {braces1, braces2, braces3, braces4, braces5, braces6};

    String[] responses = balancedBraces(bracesArray);

    for(String response : responses) {
      System.out.println(response);
    }
  }
}
