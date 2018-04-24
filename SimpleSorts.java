import java.util.*;

public class SimpleSorts {

  private static int[] bubbleSort(int[] arr) {
    // for logging BigO efficiency
    int swaps = 0;
    int comparisons = 0;

    for (int high = arr.length - 1; high > 0; high--) {
      for (int low = 0; low < high; low++) {
        comparisons++;
        if (arr[low] > arr[low + 1]) {
          // swap
          int temp = arr[low + 1];
          arr[low + 1] = arr[low];
          arr[low] = temp;
          swaps++;
        }
      }
    }
    System.out.println("--- " + comparisons + " comparisons and " + swaps + " swaps made with BubbleSort ---\n");
    return arr;
  }

  private static int[] selectionSort(int[] arr) {
    // reads through whole array (n-1) times, each time, finding the minimum and swapping it with the left most pointer, left pointer is incremented.

    int swaps = 0;
    int comparisons = 0;

    for (int left = 0; left < arr.length - 1; left++) {
      int least = arr[left];
      int leastIndex = left;
      for (int right = left + 1; right < arr.length; right++) {
        comparisons++;
        if (arr[right] < least) {
          least = arr[right];
          leastIndex = right;
        }
      }
      if (least < arr[left]) {
        //swap
        int temp = arr[left];
        arr[left] = arr[leastIndex];
        arr[leastIndex] = temp;
        swaps++;
      }
    }

    System.out.println("--- " + comparisons + " comparisons and " + swaps + " swaps made with SelectionSort ---\n");

    return arr;
  }

  public static void main(String[] args) {
    //Scanner scanner = new Scanner(System.in);
    int[] arr = {5, 3, 9, 10, 2, 0, 20, 1, 22, 7};
    System.out.println("Simple Sorts demonstrates Bubble, Selection, and Insertion sorts with the following int array.\n");
    System.out.println("Before ....");
    // print array before its sorted
    for(int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println("\n");

    arr = selectionSort(arr);

    System.out.println("After ....");
    for(int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println("\n");

  }
}
