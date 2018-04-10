
// This class reverses the order of an array without the need of creating another array

public class ReverseArray {

  // sample data, change the array names here if you want to swap, not in code
  private static int[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};   // even # of elements
  private static int[] numbers1 = {11, 12, 13, 14, 15, 16, 17, 18, 19};    // odd # of elements

  private static void reverseTheArray() {
    int topCount = numbers1.length - 1;
    int floorCount = 0;

    while (floorCount < topCount) {
      int temp = numbers1[floorCount];
      numbers1[floorCount] = numbers1[topCount];
      numbers1[topCount] = temp;
      floorCount++;
      topCount--;
    }

  }

  public static void main(String[] args) {

    reverseTheArray();
    for(int number : numbers1) {
      System.out.print(number + " ");
    }

  }
}
