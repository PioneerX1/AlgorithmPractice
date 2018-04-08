

public class QuickSort {

  private static int[] quickSort(int[] arr) {
    // this function needs to call itself recursively
    // validators
    if(arr.length == 1) {
      return arr;
    }

    int low = 0;
    int high = arr.length - 1;
    int pivot = arr.length / 2;



    return arr;
  }

  private static int[] partitionArray(int[] arr) {
    int low = 0;
    int high = arr.length - 1;

    int pivot = arr[high];
    int i = -1;

    // ceiling is - 2 cause pivot takes up the - 1 spot
    for(int j=low; j <= high - 1; j++) {
      if (arr[j] <= pivot) {
        i++;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      } else {    // if arr[j] > pivot
        // do nothing
      }
    }
    // pivot still in last place, may need swap
    if (arr[i+1] >= arr[high]) {
      int temp = arr[high];
      arr[high] = arr[i+1];
      arr[i+1] = temp;
    }

    return arr;
  }

  public static void main(String [] args) {
    int[] arr1 = {2, 4, 1, 6, 3, 0, 10, 2};
    int[] arr2 = {10, 80, 30, 90, 40, 50, 70};
    //arr = quickSort(arr);

    arr2 = partitionArray(arr2);
    for(int number : arr2) {
      System.out.print(number + " ");
    }
    System.out.println("");
  }
}
