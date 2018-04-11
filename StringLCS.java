import java.util.*;


// StringLCS (Longest Common Subsequence) uses a String for final output value, tempOutput value, 3 for loops, and a placement pointer for seq2LastMatch
// 1st loop: iterates through seq1, keeping track of tempOutput and seq2LastMatch the whole time
//  2nd loop: iterates through the remainder of seq1 again, this is needed cause you have to clip off values toward the start of the loop and compare your results (tempValue) with the highest output value
//    3rd loop: iterates through seq2
//      if match, concat the char to tempOutput, reset seq2LastMatch to current j, and break inner loop
//  before next iteration of 1st loop, compare tempOutput to final output, if larger, reassign, to final output

// ALTERNATIVELY: You could keep track of ALL common subsequences or multiple LCS's by storing in an array of Strings
// HashTable would NOT work cause you can only track 1 of each size 

public class StringLCS {

  private static String findLCS(String seq1, String seq2) {
    String output = "";

    for (int i = 0; i < seq1.length(); i++) {
      String tempOutput = "";
      int seq2LastMatch = -1;

      for (int k = i; k < seq1.length(); k++) {
        for (int j = seq2LastMatch + 1; j < seq2.length(); j++) {
          if (seq1.charAt(k) == seq2.charAt(j)) {
            tempOutput += seq2.charAt(j);
            seq2LastMatch = j;
            break;
          }
        }
      }
      if (tempOutput.length() > output.length()) {
        output = tempOutput;
      }
    }

    if (output.equals("")) {
      return "**No Matching Characters**";
    }

    return output;

  }

  public static void main(String[] args) {
    String seq1 = "ABCDGH";
    String seq2 = "AEDFHR";

    String seq3 = "AGGTAB";
    String seq4 = "GXTXAYB";

    String seq5 = "ABAZDC";
    String seq6 = "BACBAD";

    System.out.println("Longest Common Subsequence is " + findLCS(seq5, seq6));
  }
}
