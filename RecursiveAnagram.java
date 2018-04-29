import java.util.*;

class RecursiveAnagram {

  private static char[] arrChar;
  private static int count = 1;
  private static int size;

  private static void displayWord() {
    System.out.print(count++ + " ");
    for(char letter : arrChar) {
      System.out.print(letter);
    }
    System.out.println("");
  }

  private static void rotate(int newSize) {
    int position = size - newSize;
    int j;
    char temp = arrChar[position];
    for (j = position + 1; j < size; j++) {
      arrChar[j-1] = arrChar[j];
    }
    arrChar[j-1] = temp;

  }

  private static void doAnagram(int newSize) {
    if (newSize == 1) {
      return;
    }
    for (int k = 0; k < newSize; k++) {
      doAnagram(newSize - 1);
      if (newSize == 2) {
        displayWord();
      }
      rotate(newSize);
    }
  }

  public static void main(String[] args) {
    System.out.println("This program uses recursive calls list all permutations of a given word");
    System.out.print("Enter a word: ");
    Scanner scanner = new Scanner(System.in);
    String word = scanner.nextLine();
    size = word.length();
    arrChar = new char[size];
    for(int i = 0; i < size; i++) {
      arrChar[i] = word.charAt(i);
    }

    doAnagram(size);

    //System.out.println("You typed: " + arrChar[0] + arrChar[1] + arrChar[2] + arrChar[3]);
  }
}
