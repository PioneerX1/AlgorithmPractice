import java.util.*;

public class MatrixZero {

  private static final int ROW_SIZE = 10;
  private static final int COL_SIZE = 10;
  private static int[][] matrix = new int[ROW_SIZE][COL_SIZE];

  private static void initializeMatrix() {
    int count = 1;
    for (int i = 0; i < ROW_SIZE; i++) {
      for (int k = 0; k < COL_SIZE; k++) {
        matrix[i][k] = count++;
      }
    }
  }

  private static void printMatrix() {
    for (int i = 0; i < ROW_SIZE; i++) {
      for (int k = 0; k < COL_SIZE; k++) {
        if (matrix[i][k] > 99) {
          System.out.print(" " + matrix[i][k]);
        } else if (matrix[i][k] > 9) {
          System.out.print("  " + matrix[i][k]);
        } else {
          System.out.print("   " + matrix[i][k]);
        }
      }
      System.out.println("");
    }
  }

  private static void modifyMatrix(int row, int col) {
    // assume input is valid
    // change each element in the row
    for (int i = 0; i < ROW_SIZE; i++) {
      matrix[row][i] = 0;
    }
    // change each element in the column
    for (int i = 0; i < COL_SIZE; i++) {
      matrix[i][col] = 0;
    }
  }

  public static void main(String[] args) {
    initializeMatrix();
    System.out.println("MatrixZero reads in two integers separated by a space, each from 0 to " + (ROW_SIZE-1));
    System.out.println("It then changes that placement value to zero, as well as all elements in the same row and column");
    System.out.println("---MATRIX BEFORE CHANGE---");
    printMatrix();
    System.out.println("Enter 2 integers between 0 and " + (ROW_SIZE-1) + " separated by a space");

    Scanner scanner = new Scanner(System.in);
    int row = scanner.nextInt();
    int col = scanner.nextInt();
    // assume input is valid 
    modifyMatrix(row, col);

    System.out.println("---MATRIX AFTER CHANGE---");
    printMatrix();
  }
}
