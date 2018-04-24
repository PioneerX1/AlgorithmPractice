import java.util.*;

public class SimpleSorts {

  private static void printArray(int[] arr) {
    // used by all methods including main to print the current order of contents
    for(int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println("\n");
  }

  private static void bubbleSort(int[] arr) {
    // bubbles up the max values to the right (or top) of the array

    // array is an object and actually a pointer, must be cloned
    int[] a = new int[arr.length];
    for(int i = 0; i < a.length; i++) {
      a[i] = arr[i];
    }

    // for logging BigO efficiency
    int swaps = 0;
    int comparisons = 0;

    for (int high = a.length - 1; high > 0; high--) {
      for (int low = 0; low < high; low++) {
        comparisons++;
        if (a[low] > a[low + 1]) {
          // swap
          int temp = a[low + 1];
          a[low + 1] = a[low];
          a[low] = temp;
          swaps++;
        }
      }
    }
    System.out.println("--- " + comparisons + " comparisons and " + swaps + " swaps made with BubbleSort ---\n");
    printArray(a);
  }

  private static void selectionSort(int[] arr) {
    // reads through whole array (n-1) times, each time, finding the minimum and swapping it with the left most pointer, left pointer is incremented.

    // since passed in array is really an object pointer, must clone
    int[] a = new int[arr.length];
    for(int i = 0; i < a.length; i++) {
      a[i] = arr[i];
    }

    int swaps = 0;
    int comparisons = 0;

    for (int left = 0; left < a.length - 1; left++) {
      int least = a[left];
      int leastIndex = left;
      for (int right = left + 1; right < a.length; right++) {
        comparisons++;
        if (a[right] < least) {
          least = a[right];
          leastIndex = right;
        }
      }
      if (least < a[left]) {
        //swap
        int temp = a[left];
        a[left] = a[leastIndex];
        a[leastIndex] = temp;
        swaps++;
      }
    }

    System.out.println("--- " + comparisons + " comparisons and " + swaps + " swaps made with SelectionSort ---\n");

    printArray(a);
  }

  private static void insertionSort(int[] arr) {
    // expands out a sorted section of array by shifting items up to insert one in

    // since passed in array is really an object pointer, must clone
    int[] a = new int[arr.length];
    for(int i = 0; i < a.length; i++) {
      a[i] = arr[i];
    }

    int swaps = 0;
    int comparisons = 0;

    for (int out = 1; out < a.length; out++) {  // start at 1 so you can assign to 0th element if need be
      int temp = a[out];  // save that value to be moved
      int in = out;
      while (in > 0 && a[in - 1] >= temp) {   // don't decrement in past 0, make sure the decremented value is >= to the value you want to move
        comparisons++;
        a[in] = a[in -1];   // shift up
        in--;   // move in left
      }
      swaps++;
      a[in] = temp;   // fill in value where it needs to go
    }

    System.out.println("--- " + comparisons + " comparisons and " + swaps + " swaps made with InsertionSort ---\n");
    printArray(a);
  }

  public static void main(String[] args) {
    //Scanner scanner = new Scanner(System.in);
    int[] arr = {5, 3, 9, 10, 2, 0, 20, 1, 22, 7};
    System.out.println("Simple Sorts demonstrates Bubble, Selection, and Insertion sorts with the following int array.\n");
    System.out.println("Before ....");
    // print array before its sorted
    printArray(arr);

    // call 3 different simple sorts that also print
    bubbleSort(arr);
    selectionSort(arr);
    insertionSort(arr);

  }
}
