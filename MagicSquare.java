import java.util.*;

public class MagicSquare {

  private static List<int[]> possibleList = new ArrayList<>();

  private static void createPossibleSquares() {
    int[] pre1 = {8, 1, 6, 3, 5, 7, 4, 9, 2};
    int[] pre2 = {6, 1, 8, 7, 5, 3, 2, 9, 4};
    int[] pre3 = {4, 9, 2, 3, 5, 7, 8, 1, 6};
    int[] pre4 = {2, 9, 4, 7, 5, 3, 6, 1, 8};
    int[] pre5 = {8, 3, 4, 1, 5, 9, 6, 7, 2};
    int[] pre6 = {4, 3, 8, 9, 5, 1, 2, 7, 6};
    int[] pre7 = {6, 7, 2, 1, 5, 9, 8, 3, 4};
    int[] pre8 = {2, 7, 6, 9, 5, 1, 4, 3, 8};

    possibleList.add(pre1);
    possibleList.add(pre2);
    possibleList.add(pre3);
    possibleList.add(pre4);
    possibleList.add(pre5);
    possibleList.add(pre6);
    possibleList.add(pre7);
    possibleList.add(pre8);
  }

  private static int findMagicDiff(int[][] s) {

    // first, reformat 2d array into 1d array
    int[] reformattedS = new int[9];
    int slot = 0;
    for(int row = 0; row < 3; row++) {
      for(int col = 0; col < 3; col++) {
        reformattedS[slot] = s[row][col];
        slot++;
      }
    }

    int masterDiff = 1000;
    for(int[] arr: possibleList) {

      int initialDiff = 0;

      for(int i = 0; i < arr.length; i++) {
        if(arr[i] != reformattedS[i]) {
          initialDiff += Math.abs(arr[i] - reformattedS[i]);
        }
      }
      if(initialDiff < masterDiff) {
        masterDiff = initialDiff;
      }
    }

    return masterDiff;

  }

  public static void main(String[] args) {

    // first initialize all possible combinations for magic squares
    createPossibleSquares();

    int[] row1 = {4, 8, 2};
    int[] row2 = {4, 5, 7};
    int[] row3 = {6, 1, 6};
    int[][] square = {row1, row2, row3};

    int magicDiff = findMagicDiff(square);
    System.out.println("Magic square difference is: " + magicDiff);

  }
}
