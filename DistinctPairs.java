import java.util.*;

public class DistinctPairs {

  private static int totalDistinctPairs(int [] arr, int k) {

    // use HashMap to store pairs that match difference
    Map<Integer, Integer> pairsMap = new HashMap<>();
    int bigOCount = 0;

    for(int i=0; i < arr.length; i++) {

      for(int j=i; j < arr.length - 1; j++) {
        bigOCount++;
        // figure out the higher and lower values
        int higher, lower;
        if(arr[i] < arr[j+1]) {
          lower = arr[i];
          higher = arr[j+1];
        } else {
          lower = arr[j+1];
          higher = arr[i];
        }
        // calculate difference & compare
        if(higher - lower == k) {
          if (pairsMap.containsKey(higher)) {
            // do not add, already exists in the hash map
          } else {
            // use the higher int as the key every time
            pairsMap.put(higher, lower);
          }
        }
      }
    }
    System.out.println("BigO iterations: " + bigOCount);
    return pairsMap.size();
  }

  // private static int[] quickSort(int[] arr) {
  //
  //   int pivot = arr[arr.length / 2];
  //   int low = arr[0];
  //   int high = arr[arr.length - 1];
  //
  //   while(low <= high) {
  //     while(arr[i] < pivot) {
  //       low++;
  //     }
  //     while(arr[j] > pivot) {
  //       high--;
  //     }
  //     if(low <= high) {
  //       swapNumbers(low, high, arr);
  //       low++;
  //       high--;
  //     }
  //
  //
  //
  //   }
  //
  //   return arr;
  // }
  //
  // private static int[] swapNumbers(int i, int j, int[] arr) {
  //   int temp = arr[i];
  //   arr[i] = arr[j];
  //   arr[j] = temp;
  //   return arr;
  // }

  public static void main(String [] args) {

    // output for diff1 and arr1 should be 2
    // output for diff2 and arr2 should be 5

    int diff1 = 3;
    int diff2 = 4;
    int[] arr1 = {1, 5, 3, 4, 2};
    int[] arr2 = {8, 12, 16, 4, 0, 20};

    System.out.println(totalDistinctPairs(arr2, diff2));
  }
}
